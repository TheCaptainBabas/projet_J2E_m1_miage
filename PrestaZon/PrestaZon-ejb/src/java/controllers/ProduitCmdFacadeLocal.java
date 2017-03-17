/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import entites.Commande;
import entites.Produit;
import entites.ProduitCmd;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Benco
 */
@Local
public interface ProduitCmdFacadeLocal {

    void create(Commande commande, Produit produit, int quantite);

    void edit(Commande commande, Produit produit, int quantite);

    void remove(Commande commande, Produit produit);

    ProduitCmd find(Object id);

    List<ProduitCmd> findAll();

    List<ProduitCmd> findRange(int[] range);

    int count();
    
    ProduitCmd findByRefAndId(String ref, Long idProduit);
}
