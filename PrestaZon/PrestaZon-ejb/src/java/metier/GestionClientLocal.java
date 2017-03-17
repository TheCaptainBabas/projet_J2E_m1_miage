/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import entites.Client;
import javax.ejb.Local;

/**
 *
 * @author Benco
 */
@Local
public interface GestionClientLocal {

    void create(String n, String p, String e, String a, String cp, String mdp);
    
    void remove (String n, String p);
    
    Client findByName (String n, String p);
    
    Client findByID (Long ID);
    
    boolean connexion (String identifiant, String mdp); /*identifiant = email*/
}
