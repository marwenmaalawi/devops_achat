package tn.esprit.rh.achat;

import java.util.ArrayList;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;
import java.util.List;
import java.util.Optional;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Fournisseur;

import tn.esprit.rh.achat.entities.FournisseurRequestModel;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.services.FournisseurServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class FournisseurServiceImplMock {
	@Mock
	FournisseurRepository fourniseurRepository;
	@InjectMocks
	FournisseurServiceImpl fournisseurService;
	Fournisseur p=new Fournisseur((long) 1,"123","libelle 1");
	Fournisseur p1=new Fournisseur((long) 2,"123","libelle 2");
	Fournisseur p2=new Fournisseur((long) 3,"123","libelle 3");
	List<Fournisseur> listUsers = new ArrayList<Fournisseur>() {
		{
		add(p1);
		add(p2);
		}
		};
		
	@Test
	public void createFournisseurTest()
	{ 
		FournisseurRequestModel pR=new FournisseurRequestModel((long) 1,"123","libelle 1");
		fournisseurService.addFournisseur(pR);
	}
	@Test
	public void testRetrieveUser() {
	Mockito.when(fourniseurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(p));
		Fournisseur fournisseur1 = fournisseurService.retrieveFournisseur((long)(2));
		Assertions.assertNotNull(fournisseur1);
		}
	
	@Test
    public void updateFournisseurTest(){
        p.setLibelle("Libelle 1 updated");
        FournisseurRequestModel prm=new FournisseurRequestModel(p.getIdFournisseur(),p.getCode(),p.getLibelle());
        Fournisseur updatedFournisseur = fournisseurService.updateFournisseur(prm);
    }

    @Test
    public void deleteFournisseurTest(){
        willDoNothing().given(fourniseurRepository).deleteById(p1.getIdFournisseur());
        fournisseurService.deleteFournisseur(p1.getIdFournisseur());
    }

}
