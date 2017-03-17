/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.Serializable;
import java.util.ArrayList;
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
public class Commande implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;

    public void setRef(String ref) {
        this.ref = ref;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public void setPaye(boolean paye) {
        this.payé = paye;
    }

    public void setLivre(boolean livre) {
        this.livre = livre;
    }

    public void setLesProduits(ArrayList<Produit> lesProduits) {
        this.lesProduits = lesProduits;
    }
    private float montant;
    private boolean payé;

    public String getRef() {
        return ref;
    }

    public float getMontant() {
        return montant;
    }

    public boolean isPaye() {
        return payé;
    }

    public boolean isLivre() {
        return livre;
    }

    public ArrayList<Produit> getLesProduits() {
        return lesProduits;
    }
    private boolean livre;
    @ManyToOne
    @JoinColumn(name = "Produit.id")
    private ArrayList<Produit> lesProduits;

    public Commande() {

    }

    public Commande(String r, float m) {
        this.ref = r;
        this.montant = m;
        this.payé = false;
        this.livre = false;
        this.lesProduits = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Commande[ id=" + id + " ]";
    }

    public void ajouterProduit(Produit p) {
        this.lesProduits.add(p);
    }
}
