package tn.esprit.rh.achat;



import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.entities.FournisseurRequestModel;
import tn.esprit.rh.achat.services.IFournisseurService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)

public class FournisseurServiceImplTest {
	@Autowired
	IFournisseurService ps;
	FournisseurRequestModel p=new FournisseurRequestModel((long) 1,"123","libelle 1");
	FournisseurRequestModel p1=new FournisseurRequestModel((long) 2,"123","libelle 2");
	FournisseurRequestModel p2=new FournisseurRequestModel((long) 3,"123","libelle 3");
    
	@Test
	@Order(1)
	public void testAddFournisseur() {
		ps.addFournisseur(p);
		ps.addFournisseur(p1);
		ps.addFournisseur(p2);
	 System.out.println("fournisseur  added");
	}

	@Test
	@Order(2)
	public void testRetrieveAllFournisseurs() {
		List<Fournisseur> listFournisseur = ps.retrieveAllFournisseurs();
		 System.out.println("fournisseur listed :"+listFournisseur.size());
	}

	@Test
	@Order(3)
	public void testUpdateFournisseur() {
		
		ps.updateFournisseur(new FournisseurRequestModel((long) 1,"123","libelle 1 updated"));
		 System.out.println("fournisseur updated");

	}

	@Test
	@Order(4)
	public void testRetrieveFournisseur() {
		Fournisseur fournisseur = ps.retrieveFournisseur((long)1);
		System.out.println("fournisseur : "+fournisseur);
	}

	@Test
	@Order(5)
	public void testDeleteFournisseur() {
		ps.deleteFournisseur((long)1);
		System.out.println("fournisseur deleted");
	}


}


