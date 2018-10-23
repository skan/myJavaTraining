package com.sdz;

import com.sdz.View.Calculette;
import com.sdz.controler.AbstractControler;
import com.sdz.controler.CalculetteControler;
import com.sdz.model.AbstractModel;
import com.sdz.model.Calculator;

public class Main {

  public static void main(String[] args) {
    //Model
    AbstractModel calc = new Calculator();
    //Controler from model
    AbstractControler controler = new CalculetteControler(calc);
    //view from controller
    Calculette calculette = new Calculette(controler);
    //add View to Model observer
    calc.addObserver(calculette);
  }
}