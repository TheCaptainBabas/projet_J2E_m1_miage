/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import controllers.ClientFacadeLocal;
import entites.Client;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Benco
 */
@Stateless
public class GestionClient implements GestionClientLocal {

    @EJB
    private ClientFacadeLocal clientFacade;

    @Override
    public void create(String n, String p, String e, String a, String cp, String mdp) {
        Client c = new Client(n, p, e, a, cp, mdp);
        clientFacade.create(c);
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
