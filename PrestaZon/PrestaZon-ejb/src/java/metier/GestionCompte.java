/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import E.SoldeInsuffisantException;
import controllers.ClientFacadeLocal;
import controllers.CompteFacadeLocal;
import entites.Client;
import entites.Compte;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Benco
 */
@Stateless
public class GestionCompte implements GestionCompteLocal {

    @EJB
    private ClientFacadeLocal clientFacade;
    @EJB
    private CompteFacadeLocal compteFacade;

    @Override
    public void create(String nom, String prenom, double s) {
        Client c = clientFacade.findByName(nom, prenom);
        Compte co = new Compte(s, c);
        compteFacade.create(co);
    }

    @Override
    public void debiter(int id, double s) {
        Compte c = compteFacade.find(id);
        try {
            compteFacade.debiter(c, s, "debit");
        } catch (SoldeInsuffisantException ex) {
            Logger.getLogger(GestionCompte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void crediter(int id, double s) {
        Compte c = compteFacade.find(id);
        compteFacade.crediter(c, s, "credit");
    }

    @Override
    public void virement(int idOri, int idDest, double s) {
        Compte cOri = compteFacade.find(idOri);
        Compte cDest = compteFacade.find(idDest);
        try {
            compteFacade.virementmoins(cOri, s, "virement");
            compteFacade.virementplus(cDest, s, "virement");
        } catch (SoldeInsuffisantException ex) {
            Logger.getLogger(GestionCompte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void cloturer(int id) {
        Compte c = compteFacade.find(id);
        //compteFacade.cloturer(c);
    }

    @Override
    public void consulter(int id) {
        Compte c = compteFacade.find(id);
        compteFacade.consulterPosition(c);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
