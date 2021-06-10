package com.administrate.services;

import java.util.List;

import com.administrate.entity.Organisation;

public interface OrganisationFacade {
	public List<Object[]> getAllOrganisation();

	public int deleteOrg(int id);

	public int insertOrg(Organisation newOrg);

	public int updateOrg(Organisation updatedOrg);

}
