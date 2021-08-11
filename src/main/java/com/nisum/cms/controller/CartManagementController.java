package com.nisum.cms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nisum.cms.domain.CartDomain;
import com.nisum.cms.exception.CartManagementException;

import com.nisum.cms.model.CartRequest;
import com.nisum.cms.model.CartResponse;
import com.nisum.cms.service.CartService;
import com.nisum.cms.service.dto.CartRequestDto;

@Component
@RestController
@RequestMapping("/carts")
public class CartManagementController {
	/*
	 * @GetMapping public String getCart() {
	 * 
	 * return "in cartma";
	 */

	@Autowired
	private CartService cartService;
	

	@GetMapping
	public List<CartDomain> getAllCarts() throws CartManagementException {
		return cartService.getAll();
	}

	@GetMapping("/{cartId}")
	public CartDomain getById(@PathVariable Long cartId) throws CartManagementException {
		return cartService.getCartById(cartId);
	}
	@PostMapping()
	public String createCart(@RequestBody CartRequest cartRequest) {
		CartRequestDto cartRequestDto = CartDtoMapper.CartRequetToCartRequestDto(cartRequest);

		System.out.println(cartRequest.getUserId() + "  " + cartRequest.getCartId());
		// Cart cart = cartService.createCart(cartRequest);

		System.out.println("cartRequestDto " + cartRequestDto.getCardId());
		// convert entity to DTO
		// CartDto cartResponse = modelMapper.EntityToDto(cart);
		CartResponse cartres = cartService.createCart(cartRequestDto);
		System.out.println(" cart response " + cartres.getCardId());
		return "cart recoreds are saved" + cartres;
	}

	
	
	@PutMapping("/{cartId}")
    public String updateCart(@RequestBody CartRequest cartRequest, @PathVariable String cartId) {
		CartRequestDto cartRequestDto = CartDtoMapper.CartRequetToCartRequestDto(cartRequest);
        cartService.createCart(cartRequestDto);
        return "updated cartequest   ";
    }
	
	@DeleteMapping("/{cartId}")
    public String deleteCart(@PathVariable Long cartId) {
		cartService.deleteById(cartId);
        return "deleted cartID ";
    }
	
}
