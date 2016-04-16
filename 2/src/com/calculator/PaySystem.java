package com.calculator;

/**
 * Created by fowafolo
 * Date: 16/4/16
 * Time: 16:34
 */
public class PaySystem {

    static public boolean getPayStatus(Bill bill, String account, String password) {
        int x=(int)(Math.random()*100);
        if (x > 50) {
            return false;
        }else {
            return true;
        }
    }
}
