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

    @Override
    public void remove(String n, String p) {
        Client c = clientFacade.findByName(n, p);
        clientFacade.remove(c); 
    }

    @Override
    public Client findClient(String n, String p) {
        Client c = clientFacade.findByName(n, p);
        return c;
    }

    @Override
    public Client findByID(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int connexion(String identifiant, String mdp) {
        //a implémenter
        return 1;
    }
}
