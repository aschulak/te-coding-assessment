package com.techelevator.daos;

import java.util.List;

import com.techelevator.exceptions.PuppyNotFoundException;
import com.techelevator.models.Puppy;

/**
 * PuppyDao
 */
public interface PuppyDao {

	List<Puppy> getPuppies();

	Puppy getPuppy(int id) throws PuppyNotFoundException;

	void savePuppy(Puppy puppyToSave);
}