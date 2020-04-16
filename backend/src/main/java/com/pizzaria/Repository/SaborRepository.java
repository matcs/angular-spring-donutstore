package com.pizzaria.Repository;

import org.springframework.data.repository.CrudRepository;

import com.pizzaria.Model.Sabor;

public interface SaborRepository extends CrudRepository<Sabor, String> {
	Sabor findByIdSabor(long idSabor);
}
