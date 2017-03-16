/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Benco
 */
@Entity
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String adresse;
    private String cp;
    private String motDePasse;
    private boolean actif;
    private static final long serialVersionUID = 1L;
    @ManyToOne
    @JoinColumn(name = "Compte.id")
    private ArrayList<Compte> lesComptes;
    @ManyToOne
    @JoinColumn(name = "Commande.id")
    private ArrayList<Commande> lesCommandes;

    public Client() {
    }

    public Client(String n, String p, String e, String a, String c, String mdp) {
        this.nom = n;
        this.prenom = p;
        this.email = e;
        this.adresse = a;
        this.cp = c;
        this.motDePasse = mdp;
        this.lesComptes = new ArrayList<>();
        this.lesCommandes = new ArrayList<>();
        this.actif = true;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setLesComptes(ArrayList<Compte> lesComptes) {
        this.lesComptes = lesComptes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public List<Compte> getLesComptes() {
        return lesComptes;
    }

    public Long getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Client[ id=" + id + " ]";
    }
}
