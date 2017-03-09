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
import javax.persistence.OneToMany;

/**
 *
 * @author Benco
 */
@Entity
public class Compte implements Serializable {
    private double solde;
    @OneToMany
    @JoinColumn (name = "Operation.id")
    private ArrayList<Operation> lesOperations;
    private static final long serialVersionUID = 1L;     
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn (name = "Client.id")
    private Client leClient;
    private boolean cloturer;
    
    public Compte(){
        
    }
    public Compte(double somme, Client c){
        this.solde = somme;
        this.leClient = c;
        this.lesOperations = new ArrayList<Operation>();
        this.cloturer = false;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    } 
    public double getSolde(){
        return this.solde;
    }
    public void setSolde(double s){
        this.solde= s;
    }
    public ArrayList<Operation> getlesOperations(){
        return this.lesOperations;
    }  
    public Client getClient(){
        return leClient;
    }
    public void setClient(Client c){
        this.leClient = c;
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
        if (!(object instanceof Compte)) {
            return false;
        }
        Compte other = (Compte) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "entites.Compte[ id=" + id + " ]";
    }  
}
