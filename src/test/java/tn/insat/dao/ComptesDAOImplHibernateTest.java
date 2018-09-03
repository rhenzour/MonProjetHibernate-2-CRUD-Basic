package tn.insat.dao;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tn.insat.dao.ComptesDAOImplHibernate;
import tn.insat.dao.IComptesDAO;
import tn.insat.entities.Compte;

public class ComptesDAOImplHibernateTest {

	private IComptesDAO underTest; 
	
	@Before
	public void setUp() throws Exception {
	
		underTest = new ComptesDAOImplHibernate();
	}
	@After
	public void tearDown() throws Exception {
		underTest = null;
	}

	@Test
	public final void testFindById() {
		
		// ARRANGE
		String numero = "A100";
		Compte expected = new Compte("B200", "Nidhal Braham",
				new BigDecimal("200.200"));
		
		// ACT
		Compte actual = underTest.findById(numero);
		
		
		// ASSERT
		assertEquals(expected, actual);
	}

	@Test
	public final void test_nominal_Create() {
		// ARRANGE
		Compte nouveau = new Compte("B300", "Zina SOLTANI",
				new BigDecimal("300.300"));
		boolean expected = true;
		
		// ACT
		boolean actual= underTest.create(nouveau);
		
		// ASSERT
		assertEquals(expected, actual);			
		
	}
	@Test
	public final void test_failing_Create() {
		// ARRANGE
		Compte nouveau = new Compte("B300", "Zina SOLTANI",
				new BigDecimal("300.300"));
		//boolean expected = false;
		
		// ACT
		boolean actual= underTest.create(nouveau);
		
		// ASSERT
		assertFalse(actual);			
		
	}
	@Test
	public final void test_FindAll() {
		// ARRANGE
		int expected = 7;  // Nomber of BD racords 
	
		// ACT
		List<Compte> actual= underTest.findAll();
		
		// ASSERT
		assertEquals(expected, actual.size());   // This should be enhanced later			
		
	}
	
	@Test
	public final void test_Update() {
		// ARRANGE
		Compte theUpade = new Compte("B300", "zina soltani sungard engineer", new BigDecimal("3000.300"));
		Compte expected = theUpade;
		
		// ACT
		Compte actual= underTest.update(theUpade);
		
		// ASSERT
		assertEquals(expected, actual);			
		
	}
	@Test
	public final void test_nominal_Delete() {
		// ARRANGE
		String a_supprimer = "B900";  // Mohamed Romdhani
		// ACT
		boolean actual= underTest.delete(a_supprimer);
		
		// ASSERT
		assertTrue(actual);		
		
	}
	@Test
	public final void test_failing_Delete() {
		// ARRANGE
		String a_supprimer = "B900";  // Mohamed Romdhani
		// ACT
		boolean actual= underTest.delete(a_supprimer);
		
		// ASSERT
		assertFalse(actual);		
		
	}

}
