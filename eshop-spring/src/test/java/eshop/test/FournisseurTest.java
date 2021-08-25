package eshop.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import eshop.config.AppConfig;
import eshop.model.Fournisseur;
import eshop.repositories.FournisseurRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class FournisseurTest {

	@Autowired
	private FournisseurRepository frsRepo;

	@Test
	public void frsRepoExit() {
		assertNotNull(frsRepo);
	}

	@Test
	@Rollback(true)
	@Transactional
	public void testInsert() {
		Fournisseur fournisseurAInserer = new Fournisseur("abid", "jordan", "ajc");
		frsRepo.save(fournisseurAInserer);
		assertEquals(fournisseurAInserer, frsRepo.findById(fournisseurAInserer.getId()).get());
	}

}
