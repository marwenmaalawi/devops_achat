package tn.esprit.rh.achat;



import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.entities.ProduitRequestModel;
import tn.esprit.rh.achat.services.IProduitService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)

public class ProduitServiceImplTest {
	@Autowired
	IProduitService ps;
	ProduitRequestModel p=new ProduitRequestModel((long) 1,"123","libelle 1",50);
	ProduitRequestModel p1=new ProduitRequestModel((long) 2,"123","libelle 2",50);
	ProduitRequestModel p2=new ProduitRequestModel((long) 3,"123","libelle 3",70);
    
	@Test
	@Order(1)
	public void testAddProduit() {
		ps.addProduit(p);
		ps.addProduit(p1);
		ps.addProduit(p2);
	 System.out.println("product added");
	}

	@Test
	@Order(2)
	public void testRetrieveAllProduits() {
		List<Produit> listProduit = ps.retrieveAllProduits();
		 System.out.println("product listed "+listProduit.size());
	}

	@Test
	@Order(3)
	public void testUpdateProduit() {
		
		ps.updateProduit(new ProduitRequestModel((long) 1,"123","libelle 1 updated",50));
		 System.out.println("product updated");

	}

	@Test
	@Order(4)
	public void testRetrieveProduit() {
		Produit produit = ps.retrieveProduit((long)1);
		System.out.println("product "+produit);
	}

	@Test
	@Order(5)
	public void testDeleteProduit() {
		ps.deleteProduit((long)1);
		System.out.println("product deleted");
	}

}
