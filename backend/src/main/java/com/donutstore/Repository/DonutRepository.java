package com.donutstore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.donutstore.Model.Donut;

@Repository
public interface DonutRepository extends JpaRepository<Donut, Long> {
	Donut findByIdDonut(long idDonut);
}
