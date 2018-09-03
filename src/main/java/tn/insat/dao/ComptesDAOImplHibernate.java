package tn.insat.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import tn.insat.entities.Compte;
import tn.insat.utilities.HibernateUtil;

public class ComptesDAOImplHibernate implements IComptesDAO {

	@Override
	public boolean create(Compte c) {

		boolean a_retourner = false;
		Transaction transaction = null;
		try {
			Session session = HibernateUtil.createSessionFactory()
					.openSession();
			transaction = session.beginTransaction();

			session.save(c);
			transaction.commit();

			a_retourner = true;
		} catch (Exception e) {
			System.out.println("LOG : Exception lors de la creation. Détails :"
					+ e);
			if ((transaction != null) && transaction.isActive())
				transaction.rollback();
		}

		return a_retourner;
	}

	@Override
	public Compte findById(String id) {

		SessionFactory factory = HibernateUtil.createSessionFactory();

		// Obtenir une session de la session factory

		Session session = factory.openSession();

		// Work with the session
		Compte c = (Compte) session.get(Compte.class, id);

		// Clean up !
		session.close();
		factory.close();

		return c;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Compte> findAll() {
		SessionFactory factory = HibernateUtil.createSessionFactory();

		Session session = factory.openSession();

		Query query = session.createQuery("from Compte"); // HQL ...
		List<Compte> resultat = (List<Compte>) query.list();

		return resultat;
	}

	@Override
	public Compte update(Compte c) {
		Compte a_retourner = null;
		Session session = HibernateUtil.createSessionFactory().openSession();

		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(c);
			transaction.commit();
			a_retourner = c;
		} catch (Exception e) {
			System.out.println("LOG : Exception lors de Update. Détails => "+e);
			if (transaction != null)
				transaction.rollback();

		}

		return a_retourner;
	}

	@Override
	public boolean delete(String id) {
		boolean a_retourner = false;
		Session session = HibernateUtil.createSessionFactory().openSession();

		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Compte à_supprimer = (Compte)session.get(Compte.class, id);
			session.delete(à_supprimer);
			transaction.commit();
			a_retourner = true;
		} catch (Exception e) {
			System.out.println("LOG : Exception lors de Delete. Détails => "+e);
			if (transaction != null)
				transaction.rollback();
		}

		return a_retourner;

	}

}
