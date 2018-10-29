import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FolderScanner {

	private Path path = null;
	private String filter = "*";
	private long result = 0;

	public FolderScanner() {
	}

	public FolderScanner(Path p, String f) {
		path = p;
		filter = f;
	}

	/**
	 * M�thode qui se charge de scanner les dossiers de fa�on r�cursive
	 * 
	 * @throws ScanException
	 */
	public long sequentialScan() throws ScanException {
		// Si le chemin n'est pas valide, on l�ve une exception
		if (path == null || path.equals(""))
			throw new ScanException("Chemin � scanner non valide (vide ou null) !");

		System.out.println(
				"Scan du dossier : " + path + " � la recherche des fichiers portant l'extension " + this.filter);

		// On liste maintenant le contenu du r�pertoire pour traiter les sous-dossiers
		try (DirectoryStream<Path> listing = Files.newDirectoryStream(path)) {
			for (Path nom : listing) {
				// S'il s'agit d'un dossier, on le scanne gr�ce � notre objet
				if (Files.isDirectory(nom.toAbsolutePath())) {
					FolderScanner f = new FolderScanner(nom.toAbsolutePath(), this.filter);
					result += f.sequentialScan();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Maintenant, on filtre le contenu de ce m�me dossier sur le filtre d�fini
		try (DirectoryStream<Path> listing = Files.newDirectoryStream(path, this.filter)) {
			for (Path nom : listing) {
				// Pour chaque fichier correspondant, on incr�mente notre compteur
				result++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}
}