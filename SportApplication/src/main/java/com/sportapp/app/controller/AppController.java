package com.sportapp.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportapp.app.service.CricketerService;
import com.sportapp.cricketerentity.Cricketer;

@RestController
@RequestMapping("/cricketers")
public class AppController
{
	@Autowired
	private CricketerService cricketerService;
	@PostMapping("/createResource")
	public ResponseEntity<String> createCricketerC(@RequestBody Cricketer cricketer)
	{
		this.cricketerService.createCricketerS(cricketer);
		return ResponseEntity.status(HttpStatus.CREATED).body("Resource Created");
	}
	
	@GetMapping("/{capNumber}")
	public ResponseEntity<Optional<Cricketer>> getCricketerC(@PathVariable String capNumber)
	{
		 Optional<Cricketer> cricketer=this.cricketerService.getCricketerS(capNumber);
		 return ResponseEntity.status(HttpStatus.OK).body(cricketer);
	}
	@GetMapping("/")
	public ResponseEntity<List<Cricketer>> getAllCricketersC()
	{
		List<Cricketer> cricketers=this.cricketerService.getAllCricketersS();
		return ResponseEntity.status(HttpStatus.OK).body(cricketers);
	}
	
	@PutMapping("/{capNumber}")
	public ResponseEntity<Cricketer> updateCricketerC(@PathVariable String capNumber, @RequestBody Cricketer cricketer)
	{
	     this.cricketerService.updateCricketerS(capNumber, cricketer); 
	     return new ResponseEntity<>(cricketer, HttpStatus.OK);
	}
	@DeleteMapping("/{capNumber}")
	public ResponseEntity<String> deleteCricketerC(@PathVariable String capNumber)
	{
		this.cricketerService.deleteResourceS(capNumber);
		return ResponseEntity.status(HttpStatus.OK).body("Resorce Removed");
	}
	@GetMapping("/runmachine")
	public ResponseEntity<List<Cricketer>> getResult()
	{
		List<Cricketer> leadrun =this.cricketerService.leadingRunScorer();
		return new ResponseEntity<>(leadrun,HttpStatus.OK);
	}
}
