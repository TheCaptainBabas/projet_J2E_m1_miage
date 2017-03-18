/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import controllers.ClientFacadeLocal;
import controllers.ProduitFacadeLocal;
import entites.Client;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import entites.Produit;

/**
 *
 * @author Benco
 */
@Stateless
public class GestionProduit implements GestionProduitLocal {

    @EJB
    private ProduitFacadeLocal produitFacade;

    @Override
    public void create(String r, String l, float p, int s) {
        Produit produit = new Produit(r, l, p, s);
        produitFacade.create(produit);
    }

    @Override
    public void modify(String r, String l, float p, int s) {
        Produit produit = produitFacade.findByRef(r);
        produit.setLibelle(l);
        produit.setPrix(p);
        produit.setStock(s);
    }


    @Override
    public void augmenterStock(String ref, int val) {
       Produit produit = produitFacade.findByRef(ref);
       int stock = produit.getStock();
       stock = stock + val;
       produit.setStock(stock);
    }

    @Override
    public void deleteByRef(String ref) {
        Produit produit = produitFacade.findByRef(ref);
        produitFacade.remove(produit);
    }

    @Override
    public void deleteById(Long id) {
        Produit produit = produitFacade.find(id);
        produitFacade.remove(produit);
    }

    @Override
    public Produit findById(Long id) {
        Produit produit = produitFacade.find(id);
        return produit;
    }

    @Override
    public Produit findByRef(String ref) {
        Produit produit = produitFacade.findByRef(ref);
        return produit;
    }
}
