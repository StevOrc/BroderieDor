package com.broderieDor.model.commande;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.broderieDor.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Commande{
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private long idCommande;
	
	@ManyToOne
	@JoinColumn(name="client")
	private User client;
	
	@OneToMany(mappedBy="commande")
	private Collection<OrderLine> orderLines;
	
	private float prixTotal;
	
	private Date dateCommande;
	
	/**
	 * Constructeur sans paramètre
	 */
	public Commande() {
		
	}

	
	public Commande(User client, float prixTotal, Date dateCommande) {
		this.client = client;
		this.prixTotal = prixTotal;
		this.dateCommande = dateCommande;
	}



	//GETTERS - SETTERS
	public long getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public float getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(float prixTotal) {
		this.prixTotal = prixTotal;
	}

	public Date getDateCommandel() {
		return dateCommande;
	}

	public void setDateCommandel(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Collection<OrderLine> getOrderLines() {
		return orderLines;
	}


	public Date getDateCommande() {
		return dateCommande;
	}


	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}


	public void setOrderLines(Collection<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}
	
	
	
}
