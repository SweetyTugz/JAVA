package com.administrate.services;

import java.util.List;

import com.administrate.entity.Person;

public interface PersonFacade {
	public List<Object[]> getAllPersons();

	public int deletePerson(int id);

	public int insertPerson(Person newPerson);

	public int updatePerson(Person updatedPerson);

}
