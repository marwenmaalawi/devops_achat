package tn.esprit.rh.achat.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ProduitRequestModel {

	private static final long serialVersionUID = 1L;
	
	private Long idProduit;
	private String codeProduit;
	private String libelleProduit;
	private float prix;

	private Date dateCreation;
	
	private Date dateDerniereModification;
	
	private Stock stock;
	
	private Set<DetailFacture> detailFacture;
	
	private CategorieProduit categorieProduit;

}
