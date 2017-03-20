/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entites.Client;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Caro
 */
@Stateless
public class ClientFacade extends AbstractFacade<Client> implements ClientFacadeLocal {

    @PersistenceContext(unitName = "PrestaZon-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientFacade() {
        super(Client.class);
    }

    @Override
    public Client findByName(String nom, String prenom) {
        return (Client) em.createQuery("select c from Client.c where c.nom = :nom and c.prenom = :prenom")
                .setParameter("nom", nom)
                .setParameter("prenom", prenom)
                .getSingleResult();
    }

    @Override
    public boolean connexion(String identifiant, String mdp) {
        int res = (int) em.createQuery("select count(*) from Client.c where c.email = :identifiant and c.motDePasse = :mdp")
                .setParameter("identifiant", identifiant)
                .setParameter("mdp", mdp)
                .getSingleResult();
        
        return res > 0;
    }
    
}
