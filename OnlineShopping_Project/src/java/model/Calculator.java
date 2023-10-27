/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author aunchisachanatipkul
 */
public class Calculator {
    public static int unitCalculator(int price, int unit){
        return unit * price;
    }
    
    public static int totalCalculator(int totalPrice, int unitPrice){
        return unitPrice + totalPrice;
    }
}
