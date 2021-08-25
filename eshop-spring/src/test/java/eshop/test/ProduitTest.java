package eshop.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Optional;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import eshop.config.AppConfig;
import eshop.model.Produit;
import eshop.repositories.ProduitRepository;

public class ProduitTest {

	private static AnnotationConfigApplicationContext ctx;
	private ProduitRepository pr;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ctx = new AnnotationConfigApplicationContext(AppConfig.class);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		ctx.close();
	}

	@Before
	public void setUp() throws Exception {
		pr = ctx.getBean(ProduitRepository.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void produitRepositoryExist() {
		assertNotNull(pr);

	}

	@Test
	public void findById() {
		Optional<Produit> opt = pr.findById(1);
		Produit p = opt.get();
		assertEquals("avion", p.getLibelle());
		assertEquals(1000, p.getPrix(), 0);
	}

	@Test
	public void findAll() {
		assertEquals(3, pr.count(), 0);
	}

}
