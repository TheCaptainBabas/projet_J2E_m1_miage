/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Benco
 */
@Entity
public class Operation implements Serializable {
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date laDate;
    private String leType; 
    @ManyToOne
    @JoinColumn (name = "Compte.id")
    private Compte leCompte;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double somme;

    public Operation(){
        
    }
    public Operation(Date d, String t, Compte c, double s){
        this.laDate = d;
        this.leType = t;
        this.leCompte = c;
        this.somme = s;
    }
    
    public Long getId() {
        return id;
    }
    public Date getLaDate() {
        return laDate;
    }
    public String getLeType() {
        return leType;
    }
    public Compte getLeCompte() {
        return leCompte;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setLaDate(Date laDate) {
        this.laDate = laDate;
    }
    public void setLeType(String leType) {
        this.leType = leType;
    }
    public void setLeCompte(Compte leCompte) {
        this.leCompte = leCompte;
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
        if (!(object instanceof Operation)) {
            return false;
        }
        Operation other = (Operation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "entites.Operation[ id=" + id + " ]";
    }   
}
