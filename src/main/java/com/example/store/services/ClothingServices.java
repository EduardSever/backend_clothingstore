package com.example.store.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.store.dao.IClothingDao;
import com.example.store.entity.Clothing;
@Service
public class ClothingServices implements IClothingServices{
	
	@Autowired
	private IClothingDao dao;

	@Override
	public Clothing save(Clothing clothing) {
		return dao.save(clothing);
	}

	@Override
	public List<Clothing> findAll() {
		return (List<Clothing>) dao.findAll();
	}

	@Override
	public Clothing update(Clothing clothing) {
		return dao.save(clothing);
	}

	@Override
	public Clothing findById(Clothing id) {
		return dao.findById(id.getId()).orElse(null);
	}

	@Override
	public void deleteById(Long id) {
		dao.deleteById(id);
	}
}