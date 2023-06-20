package com.example.store.services;

import java.util.List;

import com.example.store.entity.Clothing;

public interface IClothingServices {
	
	public Clothing save(Clothing clothing);
	
	public List<Clothing>findAll();
	
	public Clothing update(Clothing clothing);

	public Clothing findById(Clothing id);
	
	public void deleteById(Long id);
}
