package com.pizzaria.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pizzaria.Model.Sabor;

public interface SaborRepository extends JpaRepository<Sabor, Long> {
	Sabor findByIdSabor(long idSabor);
}
