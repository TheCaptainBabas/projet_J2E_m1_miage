/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import exceptions.SoldeInsuffisantException;
import entites.Compte;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Benco
 */
@Local
public interface CompteFacadeLocal {

    void create(Compte compte);

    void edit(Compte compte);

    void remove(Compte compte);

    Compte find(Object id);

    List<Compte> findAll();

    List<Compte> findRange(int[] range);

    int count();

    void crediter(Compte c, double s, String type);

    void debiter(Compte c, double s, String type) throws SoldeInsuffisantException;

    void virementplus(Compte c, double s, String type) throws SoldeInsuffisantException;

    void virementmoins(Compte c, double s, String type) throws SoldeInsuffisantException;

    double consulterPosition(Compte c);
}
