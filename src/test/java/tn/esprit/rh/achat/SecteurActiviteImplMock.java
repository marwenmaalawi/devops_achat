package tn.esprit.rh.achat;

import static org.mockito.BDDMockito.willDoNothing;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;
import tn.esprit.rh.achat.services.SecteurActiviteServiceImpl;
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
class SecteurActiviteImplMock {
	
	@Mock
	SecteurActiviteRepository secteurActiviteRepository;
	
	@InjectMocks
	SecteurActiviteServiceImpl secteurActiviteService;
	
	SecteurActivite s= new SecteurActivite((long) 1,"100","libelle 1",null);
	SecteurActivite s2= new SecteurActivite((long) 2,"200","libelle 2",null);
	SecteurActivite s3= new SecteurActivite((long) 3,"300","libelle 3",null);
	List<SecteurActivite> list = new ArrayList<SecteurActivite>() {
		{
			add(s2);
			add(s3);		
		}
	};
	
	
	
	@Test
	void testRetrieveSecteur() {
        Mockito.when(secteurActiviteRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(s));
        SecteurActivite secteur = secteurActiviteService.retrieveSecteurActivite((long)2);
        System.out.print("Test retrieve");
        Assertions.assertNotNull(secteur);
        
	}
	
	/*@Test
	void createSecteurTest()
	{     
		SecteurActivite s4=new SecteurActivite((long) 4,"400","libelle 4",null);
		Mockito.when(secteurActiviteRepository.save(s4)).thenReturn(s4);
		
		Assertions.assertEquals(s4,secteurActiviteService.addSecteurActivite(s4));
	}
	
	@Test
	void updateSecteurTest(){
		Mockito.when(secteurActiviteRepository.save(s)).thenReturn(s);
        s.setLibelleSecteurActivite("Libelle 1 updated");
        Assertions.assertEquals(s,secteurActiviteService.updateSecteurActivite(s));
    }
	@Test
	void deleteSecteurTest(){
		secteurActiviteService.deleteSecteurActivite(s2.getIdSecteurActivite());
		Assertions.assertNotNull(list);
    }*/
	
}
