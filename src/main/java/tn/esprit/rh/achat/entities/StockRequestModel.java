package tn.esprit.rh.achat.entities;

import java.util.Set;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StockRequestModel {
	private Long idStock;
	private String libelleStock;
	private Integer qte;
	private Integer qteMin;
	private Set<Produit> produits;

}
