package com.sdz;

import com.sdz.controler.*;
import com.sdz.model.*;
import com.sdz.vue.Calculette;

public class Main {

  public static void main(String[] args) {
    //Instanciation de notre mod�le
    AbstractModel calc = new Calculator();
    //Cr�ation du contr�leur
    AbstractControler controler = new CalculetteControler(calc);
    //Cr�ation de notre fen�tre avec le contr�leur en param�tre
    Calculette calculette = new Calculette(controler);
    //Ajout de la fen�tre comme observer de notre mod�le
    calc.addObserver(calculette);
  }
}