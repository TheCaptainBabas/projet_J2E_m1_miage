/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import entites.Produit;
import javax.ejb.Local;

/**
 *
 * @author Benco
 */
@Local
public interface GestionProduitLocal {

    void create(String r, String l, float p, int s);
    
    void modify(String r, String l, float p, int s);
    
    void deleteByRef(String ref);

    void deleteById(Long id);
    
    Produit findById(Long id);
    
    Produit findByRef(String ref);
    
    void augmenterStock(String ref, int val);
}
