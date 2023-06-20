package com.example.store.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.store.entity.Clothing;

public interface IClothingDao extends CrudRepository<Clothing, Long> {

}
