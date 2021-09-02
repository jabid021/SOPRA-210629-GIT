package eshop.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import eshop.config.AppConfig;
import eshop.repositories.AchatRepository;
import eshop.repositories.ClientRepository;
import eshop.repositories.ElementAchatRepository;
import eshop.repositories.ProduitRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class TestClient {

	@Autowired
	private ClientRepository clientRepo;
	@Autowired
	private ProduitRepository produitRepo;
	@Autowired
	private AchatRepository achatRepo;
	@Autowired
	private ElementAchatRepository elementAchatRepo;

	@Test
	public void test() {
//		Client c = clientRepo.findById(1).get();

//		Achat achat = new Achat(LocalDate.of(2000, Month.JANUARY, 1), c);
//		achatRepo.save(achat);
//		Produit p = new Produit("test", 22, null);
//		produitRepo.save(p);
//		ElementAchat ea = new ElementAchat(new ElementAchatKey(p, achat), 2);
//		elementAchatRepo.save(ea);
	}

}
