package com.donutstore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.donutstore.Model.Donut;

public interface DonutRepository extends JpaRepository<Donut, Long> {
	Donut findByIdDonut(long idDonut);
}
