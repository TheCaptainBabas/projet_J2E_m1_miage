/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import javax.ejb.Local;

/**
 *
 * @author Benco
 */
@Local
public interface GestionCommandeLocal {

    void create(String r, float m);

    void livrerCommande(String ref);

    boolean vérifierCommande(String ref);

    void payerCommande(String ref);

    void ajouterProduit(String ref, Long idProduit);
}
