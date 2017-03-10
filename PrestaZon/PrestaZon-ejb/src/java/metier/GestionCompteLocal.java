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
public interface GestionCompteLocal {

    void create(String nom, String prenom, double somme);

    void debiter(int id, double s);

    void crediter(int id, double s);

    void virement(int idOri, int idDest, double s);

    void cloturer(int id);

    void consulter(int id);
}
