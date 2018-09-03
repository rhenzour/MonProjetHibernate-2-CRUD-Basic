package tn.insat.dao;

import java.util.List;

import tn.insat.entities.Compte;

public interface IComptesDAO {

	// CRUD
	boolean create(Compte c); // C du CRUD
    
	Compte findById(String id) ; // R du CRUD
	
	List<Compte> findAll();    // un autre R
	
	Compte update (Compte c);   // U du CRUD
	
	boolean delete (String id);  //un D
	
}
