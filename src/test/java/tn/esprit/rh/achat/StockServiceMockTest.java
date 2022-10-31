package tn.esprit.rh.achat;

import static org.mockito.BDDMockito.willDoNothing;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.entities.StockRequestModel;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.IStockService;
import tn.esprit.rh.achat.services.StockServiceImpl;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.log4j.Log4j;

import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@SpringBootTest
class StockServiceMockTest {
	
	@Autowired
	IStockService stockService;
	
	
	public static Long id_stock;
	
	@Test
	 void createStockTest()
	{ 
		StockRequestModel s= new StockRequestModel("libelle3",100,50);
		id_stock=stockService.addStock(s).getIdStock();
	}
	
	@Test
	 void testRetrieveSock() {
		stockService.retrieveStock(id_stock);		
	
	}
	
	@Test
     void updateSockTest(){
		StockRequestModel s= new StockRequestModel("libelle4",100,50);
		s.setIdStock(id_stock);
		stockService.updateStock(s);
		
       
    }
	@Test
     void deleteSecteurTest(){
		stockService.deleteStock(id_stock);
    }
	
}
