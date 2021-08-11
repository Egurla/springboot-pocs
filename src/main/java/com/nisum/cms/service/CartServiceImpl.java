package com.nisum.cms.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.nisum.cms.controller.CartDtoMapper;
import com.nisum.cms.domain.CartDomain;
import com.nisum.cms.exception.CartManagementException;
import com.nisum.cms.model.Cart;
import com.nisum.cms.model.CartRequest;
import com.nisum.cms.model.CartResponse;
import com.nisum.cms.repository.CartRepository;
import com.nisum.cms.service.dto.CartRequestDto;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;

	public CartServiceImpl(CartRepository cartRepository) {
		super();
		this.cartRepository = cartRepository;
	}

	@Override
	public CartResponse createCart(CartRequestDto cart) {
		CartDomain cartDomine = CartDtoMapper.cartRequestDtoToDomain(cart);
		cartDomine.setId(UUID.randomUUID().toString());
		CartDomain cartDomaine = cartRepository.save(cartDomine);
		CartResponse CartResponse = CartDtoMapper.DomaineToCartResponse(cartDomaine);
		return CartResponse;
	}
	/*
	 * public void deleteCart(long id) throws CartNotFoundException {
	 * 
	 * 
	 * CartDomaine cart = cartRepository.findById(id).orElseThrow(() -> new
	 * CartNotFoundException("Cart", "id", id)); // TODO Auto-generated catch block
	 * e.printStackTrace();
	 * 
	 * cartRepository.delete(cart);
	 * 
	 * }
	 */
	@Override
	public void deleteById(Long cartId) {
		cartRepository.deleteById(cartId);

	}

	@Override
	public CartDomain getCartById(Long id) throws CartManagementException {
		System.out.println("in service class id " + id);
		Optional<CartDomain> result = cartRepository.findById(id);
		CartDomain cartDomaine;
		if (result.isPresent()) {
			System.out.println("----------------------------");
			cartDomaine = result.get();
		} else {
			throw new CartManagementException("Cart", "id", id);
		}
		return null;
	}

	@Override
	public List<CartDomain> getAll() {
		List<CartDomain> cartDomine = cartRepository.findAll();
		return cartDomine;
	}

	@Override
	public CartResponse updateCart(CartRequestDto cartRequestDto) {
		CartDomain cartDomine = CartDtoMapper.cartRequestDtoToDomain(cartRequestDto);
		CartDomain cartDomaine = cartRepository.save(cartDomine);
		CartResponse CartResponse = CartDtoMapper.DomaineToCartResponse(cartDomaine);
		return CartResponse;
	}

	
}
