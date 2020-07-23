package com.donutstore.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.donutstore.Model.CompraProduto;

@Repository
public interface CompraProdutoRepository extends CrudRepository<CompraProduto, Long> {
}
