package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import voyage.config.AppConfig;
import voyage.exception.DepartementException;
import voyage.metier.Departement;
import voyage.metier.Region;
import voyage.services.DepartementService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class DepartementTest {

	// tous les test sont fait a partir d'une base de donnee vide

	@Autowired
	private DepartementService departementService;

	@Test
	@Rollback(true)
	@Transactional
	public void testSave() {
		Departement d = new Departement("departement test", "numero test", Region.Reunion);
		departementService.save(d);
		assertNotNull(departementService.findByNumero(d.getNumero()));
	}

	@Test(expected = DepartementException.class)
	@Rollback(true)
	@Transactional
	public void testSaveError() {
		Departement d = new Departement();
		departementService.save(d);
	}

	@Test
	@Rollback(true)
	@Transactional
	public void testFindByNomStrict() {
		Departement d = new Departement("departement test", "numero test", Region.Reunion);
		departementService.save(d);
		assertNotNull(departementService.findByNomStrict(d.getNom()));
		assertNotNull("toto");
	}

	@Test
	@Rollback(true)
	@Transactional
	public void testFindByNumero() {
		Departement d = new Departement("departement test", "numero test", Region.Reunion);
		departementService.save(d);
		assertNotNull(departementService.findByNumero(d.getNumero()));
		assertNotNull("toto");
	}

	@Test
	@Rollback(true)
	@Transactional
	public void testFindByRegion() {
		Departement d = new Departement("departement test", "numero test", Region.Reunion);
		departementService.save(d);
		assertNotNull(departementService.findByRegion(d.getRegion()));
	}

	@Test
	@Rollback(true)
	@Transactional
	public void testFindByNomContaining() {
		departementService.save(new Departement("departement test", "numero test", Region.Reunion));
		departementService.save(new Departement("departement test2", "numero test", Region.Reunion));
		departementService.save(new Departement("autre", "numero test", Region.Reunion));
		assertEquals(2, departementService.findByNomContaining("test").size());
		assertEquals(0, departementService.findByNomContaining("zzz").size());
	}

	@Test
	@Rollback(true)
	@Transactional
	public void testFilter() {
		departementService.save(new Departement("departement test", "numero test", Region.Reunion));
		departementService.save(new Departement("departement", "numero test", Region.Reunion));
		departementService.save(new Departement("autre", "numero", Region.Grand_Est));
		assertEquals(1, departementService.filter("Est").size());
		assertEquals(2, departementService.filter("test").size());
		assertEquals(0, departementService.filter("z").size());

	}

}
