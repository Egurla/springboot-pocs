package com.nisum.cms.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nisum.cms.domain.CartDomain;

@Repository
public interface CartRepository extends MongoRepository<CartDomain, Long>  {

//CartDomaine findAllById(Long cartId);
	
}
