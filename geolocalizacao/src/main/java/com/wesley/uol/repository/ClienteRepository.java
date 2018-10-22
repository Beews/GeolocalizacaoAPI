package com.wesley.uol.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.wesley.uol.entity.ClienteEntity;

public interface ClienteRepository extends MongoRepository<ClienteEntity, String> {

	@Query("{ 'nome' : ?0}")
	ClienteEntity find(String nome);
	
}
