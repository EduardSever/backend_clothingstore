package com.example.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.store.entity.Clothing;
import com.example.store.services.ClothingServices;

@RestController
@RequestMapping("/clothing")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT,RequestMethod.DELETE})
public class ClothingController {
	@Autowired
	private ClothingServices cloSer;
	
	@PostMapping("/createClothing")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?>createClothing(@RequestBody Clothing clothing){
		try {
			Clothing closave = cloSer.save(clothing);
			return ResponseEntity.ok(closave);
		} catch (Exception e) {
			return new ResponseEntity<Clothing>(HttpStatus.CONFLICT);
		}
	}
	@GetMapping("/getALLClothing")
	public ResponseEntity<?>getClothing(){
		List<Clothing>cloAll = this.cloSer.findAll();
		return ResponseEntity.ok(cloAll);
	}
	
	@PutMapping("/updateClothing")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?>updateClothing(@RequestBody Clothing clothing){
		Clothing cloupdate = cloSer.update(clothing);
		return ResponseEntity.ok(cloupdate);
	}
	@PostMapping("/findByIdClothing")
	public ResponseEntity<?>findByIdClothing(@RequestBody Clothing id){
		Clothing byid = cloSer.findById(id);
		return ResponseEntity.ok(byid);
	}
	@DeleteMapping("deleteClothing/{id}")
	//@RequestMapping(value = "deleteClothing/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteClothing(@PathVariable Long id){
		this.cloSer.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
