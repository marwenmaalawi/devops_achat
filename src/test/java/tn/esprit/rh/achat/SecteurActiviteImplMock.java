package tn.esprit.rh.achat;

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
        Assertions.assertNotNull(secteur);
        
	}
	
	@Test
	void createSecteurTest()
	{     
		SecteurActivite s4=new SecteurActivite((long) 4,"400","libelle 4",null);
		Mockito.when(secteurActiviteRepository.save(s4)).thenReturn(s4);
		list.add(s4);
		Assertions.assertEquals(3,list.size());
	}
	
	@Test
	void updateSecteurTest(){
		Mockito.when(secteurActiviteRepository.save(s)).thenReturn(s);
        s.setLibelleSecteurActivite("Libelle 1 updated");
        SecteurActivite secteur = secteurActiviteService.updateSecteurActivite(s);
        Assertions.assertEquals(s,secteur);
    }
	@Test
	void deleteSecteurTest(){
		secteurActiviteService.deleteSecteurActivite(s2.getIdSecteurActivite());
		Assertions.assertNotNull(list);
    }
	
}
