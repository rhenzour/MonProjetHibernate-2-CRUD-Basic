package tn.insat.client;

import java.math.BigDecimal;

import tn.insat.dao.ComptesDAOImplHibernate;
import tn.insat.dao.IComptesDAO;
import tn.insat.entities.Compte;

public class App {
	public static void main(String[] args) {

		IComptesDAO dao = new ComptesDAOImplHibernate();

		testFindById(dao);
		//testCreate(dao);

	}

	private static void testCreate(IComptesDAO dao) {
		boolean resultat = dao.create(new Compte("E100", "Mariem ATIG",
				new BigDecimal("200.200")));
		String message = resultat ?
				                   "SUCCESS DE LA CREATION DE Mariem ATIG"
				                  :
				                  "ECHEC DE LA CREATION DE Mariem ATIG";
				System.out.println(message);	                   
					                   
			

	}

	@SuppressWarnings("unused")
	private static void testFindById(IComptesDAO dao) {
		Compte resultat = dao.findById("E100");

		System.out.println(resultat);
	}
}
