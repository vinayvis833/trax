package com.trax.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trax.entities.Lead;
import com.trax.repositories.LeadRepository;

@RestController
public class LeadRestController {
	
	@Autowired
	private LeadRepository leadRepo;
	
	@GetMapping("listallleads")
	public List<Lead> getAllLeads() {
		List<Lead> leads = leadRepo.findAll();
		return leads;
		
	}
	
	@PostMapping("/saveApi")
	public void saveLead(@RequestBody Lead lead) {
		leadRepo.save(lead);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteLead(@PathVariable long id) {
		leadRepo.deleteById(id);
	}
	
	@PutMapping("/updateApi")
	public void updateLead(@RequestBody Lead lead) {
		leadRepo.save(lead);
	}
	
	@GetMapping("/getApi/{id}")
	public Lead getOneLead(@PathVariable long id, ModelMap model) {
		try {
			Optional<Lead> findById = leadRepo.findById(id);
			Lead lead = findById.get();
			return lead;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
