/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utl;

import java.util.Date;

/**
 *
 * @author Benco
 */
public class Position {
    private double solde;
    private Date date;

    public double getSomme() {
        return solde;
    }
    public Position(double s, Date d){
        solde = s;
        date = d;
    }
    
}
