/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import controllers.CommandeFacadeLocal;
import controllers.ProduitCmdFacadeLocal;
import controllers.ProduitFacadeLocal;
import entites.Commande;
import entites.Produit;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Benco
 */
@Stateless
public class GestionCommande implements GestionCommandeLocal {

    @EJB
    private CommandeFacadeLocal commandeFacade;
    private ProduitFacadeLocal ProduitFacade;
    private ProduitCmdFacadeLocal ProduitCmdFacade;

    @Override
    public void create(String ref, float montant) {
        Commande commande = new Commande(ref, montant);
        commandeFacade.create(commande);
    }

    @Override
    public void livrerCommande(String ref) {
        Commande c = commandeFacade.findByRef(ref);
        if (vérifierCommande(ref)) {
            c.setLivre(true);
        }
    }

    @Override
    public boolean vérifierCommande(String ref) {
        Commande c = commandeFacade.findByRef(ref);
        return c.isPaye();
    }

    @Override
    public void payerCommande(String ref) {
        Commande c = commandeFacade.findByRef(ref);
        c.setPaye(true);
    }

    @Override
    public void ajouterProduit(String ref, Long idProduit) {
        Commande c = commandeFacade.findByRef(ref);
        Produit p = ProduitFacade.find(idProduit);
        c.ajouterProduit(p);
        ProduitCmdFacade.create(c, p, 0);
    }
}
