package com.sportapp.app.service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportapp.app.repository.CricketerRepo;
import com.sportapp.cricketerentity.Cricketer;
import com.sportapp.exception.ResourceNotFoundException;
@Service
public class ServiceImplementation implements CricketerService
{
	@Autowired
	private CricketerRepo cricketerRepo;
	public Cricketer createCricketerS(Cricketer cricketer)
	{
		String capNumber = UUID.randomUUID().toString();
		cricketer.setCapNumber(capNumber);	
		return this.cricketerRepo.save(cricketer);
	}	
	public Optional<Cricketer> getCricketerS(String capNumber)
	{
		return  this.cricketerRepo.findById(capNumber);	
	}
	
    public List<Cricketer> getAllCricketersS()
    {
    	return this.cricketerRepo.findAll();
    }
    public Cricketer updateCricketerS(String capNumber, Cricketer cricketer)
    {
    	return this.cricketerRepo.save(cricketer);
    }
    
    public Optional<Cricketer> deleteResourceS(String capNumber)
    {	
    	Optional<Cricketer> deleteCricketer= this.cricketerRepo.findById(capNumber);
    	if(deleteCricketer.isPresent())
    	{
    		return deleteCricketer;
    	}
    	else {
    		throw new ResourceNotFoundException("Resorce Not Found with cap Numbare: "+capNumber);
    	}  	
    } 
    public List<Cricketer> leadingRunScorer()
    {
    	return this.cricketerRepo.findLeadingRunScorerAward();
    }
}
