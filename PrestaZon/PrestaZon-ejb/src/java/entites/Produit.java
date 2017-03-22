/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Benco
 */
@Entity
public class Produit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private String libelle;
    private float prix;
    private int stock;



    public Produit() {

    }

    public Produit(String r, String l, float p, int s) {
        this.ref = r;
        this.libelle = l;
        this.prix = p;
        this.stock = s;
    }

    public Long getId() {
        return id;
    }
    
    public String getRef() {
        return ref;
    }

    public String getLibelle() {
        return libelle;
    }

    public float getPrix() {
        return prix;
    }

    public int getStock() {
        return stock;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setStock(int stock) {
        this.stock = stock;
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
        if (!(object instanceof Produit)) {
            return false;
        }
        Produit other = (Produit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Produit[ id=" + id + " ]";
    }

}
