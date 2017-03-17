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
    public void livrerCommande() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void vérifierCommande() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void payerCommande() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ajouterProduit(Long idCommande, Long idProduit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
