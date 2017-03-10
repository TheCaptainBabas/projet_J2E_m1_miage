/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import E.SoldeInsuffisantException;
import entites.Compte;
import entites.Operation;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import utl.Position;

/**
 *
 * @author Benco
 */
@Stateless
public class CompteFacade extends AbstractFacade<Compte> implements CompteFacadeLocal {

    @PersistenceContext(unitName = "TP1_-_Banque-ejbPU")
    private EntityManager em;
    @EJB
    private OperationFacadeLocal operationFacade;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CompteFacade() {
        super(Compte.class);
    }

    @Override
    public void crediter(Compte c, double s, String type) {
        c.setSolde(c.getSolde() + s);
        Operation op = new Operation(new Date(), type, c, s);
        this.operationFacade.create(op);
    }

    @Override
    public void debiter(Compte c, double s, String type) throws SoldeInsuffisantException {
        if (c.getSolde() < s) {
            throw new SoldeInsuffisantException();
        }
        c.setSolde(c.getSolde() - s);
        Operation op = new Operation(new Date(), type, c, s);
        this.operationFacade.create(op);
    }

    @Override
    public void virementplus(Compte c, double s, String type) throws SoldeInsuffisantException {
        crediter(c, s, type);
    }

    @Override
    public void virementmoins(Compte c, double s, String type) throws SoldeInsuffisantException {
        debiter(c, s, type);
    }

    @Override
    public Position consulterPosition(Compte c) {
        return new Position(c.getSolde(), new Date());
    }

}
