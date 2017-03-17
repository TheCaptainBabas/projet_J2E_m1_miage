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

    @Override
    public void remove(String n, String p) {
        Client c = clientFacade.findByName(n, p);
        clientFacade.remove(c); 
    }

    @Override
    public Client findByName(String n, String p) {
        Client c = clientFacade.findByName(n, p);
        return c;
    }

    @Override
    public Client findByID(Long ID) {
        Client c = clientFacade.find(ID);
        return c;
    }

    @Override
    public boolean connexion(String identifiant, String mdp) {
        boolean cnx = clientFacade.connexion(identifiant, mdp);
        return cnx;
    }
}
