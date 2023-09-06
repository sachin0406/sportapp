package com.sportapp.app.service;

import java.util.List;
import java.util.Optional;

import com.sportapp.cricketerentity.Cricketer;
public interface CricketerService
{
    //To create a cricketer
	public abstract Cricketer createCricketerS(Cricketer cricketer);
	
	//To find a cricketer
	public abstract Optional<Cricketer> getCricketerS(String capNumber);
	
	//To find all cricketer's
	public abstract List<Cricketer> getAllCricketersS();
	
	//To Update a Cricketer
	public abstract Cricketer updateCricketerS(String capNumber, Cricketer cricketer);
	
	//To Delete a resource	
	public abstract Optional<Cricketer> deleteResourceS(String capNumber);
	
	//To find leading run scorer
	
	public abstract List<Cricketer> leadingRunScorer();
}
