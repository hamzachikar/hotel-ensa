package ma.ensa.hotelensa;

import ma.ensa.hotelensa.beans.Categorie;
import ma.ensa.hotelensa.beans.Chambre;
import ma.ensa.hotelensa.beans.Option;
import ma.ensa.hotelensa.services.ICategorieService;
import ma.ensa.hotelensa.services.IChambreService;
import ma.ensa.hotelensa.services.IClientService;
import ma.ensa.hotelensa.services.IOptionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class HotelEnsaApplicationTests {
	@Autowired
	private IClientService clientService;
	@Autowired
	private IChambreService chambreService;
	@Autowired
	private ICategorieService categorieService;
	@Autowired
	private IOptionService optionService;


	@Test
	public void categorieServiceTest(){
		Categorie categorie=categorieService.saveOrUpdateCategorie(new Categorie("categorietest"));
		assertNotNull(categorie);
	}
	@Test
	public void optionServiceTest(){
		Option option=optionService.saveOption(new Option("optiontest",1,1000));
		assertNotNull(option);
		Categorie categorie=categorieService.saveOrUpdateCategorie(new Categorie("categorietest"));
		assertTrue(optionService.affecterOptionToCategorie(option.getIdOption(),categorie.getId()));
	}
	@Test
	public void chambreServiceTest(){
		Chambre chambre=chambreService.saveChambre(new Chambre(10,1));
		assertNotNull(chambre);
		Categorie categorie=categorieService.saveOrUpdateCategorie(new Categorie("categorietest"));
		assertTrue(chambreService.affecterChambreACategorie(chambre.getIdChambre(),categorie.getId()));
	}
}
