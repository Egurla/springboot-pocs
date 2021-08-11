package com.nisum.cms.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nisum.cms.domain.CartDomain;
import com.nisum.cms.exception.CartManagementException;
import com.nisum.cms.exception.ErrorCode;
import com.nisum.cms.model.CartRequest;
import com.nisum.cms.model.LineItem;
import com.nisum.cms.repository.CartRepository;
import com.nisum.cms.service.CartService;

@RunWith(SpringJUnit4ClassRunner.class)
public class CartManagementControllerTest {
	private MockMvc mockMvc;

	@Mock
	private CartService cartService;

	@InjectMocks
	CartManagementController cartManagementController;

	@Mock
	private CartRepository cartRepository;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(cartManagementController).build();
	}

	@Test
	public void getAllCarts() throws Exception {

		// LineItem lineItm = new LineItem(12323l, 134213.0, 1343543l, 1);
		LineItem lineItm = new LineItem();
		lineItm.setId(121222l);
		lineItm.setLine_amount(121856.0);
		lineItm.setProductId(12122l);
		lineItm.setQuantity(1);

		List<LineItem> lineItems = new ArrayList<LineItem>();
		lineItems.add(lineItm);

		List<CartDomain> cartDomain = Arrays
				.asList(new CartDomain(12423423, UUID.randomUUID(), UUID.randomUUID(), lineItems));

		Mockito.when(cartService.getAll()).thenReturn(cartDomain);
		mockMvc.perform(MockMvcRequestBuilders.get("")).andExpect(MockMvcResultMatchers.status().isOk());

	}

	@Test
	public void getById() throws Exception {
		// return cartService.getCartById(cartId);

		LineItem lineItm = new LineItem();
		lineItm.setId(121222l);
		lineItm.setLine_amount(121856.0);
		lineItm.setProductId(12122l);
		lineItm.setQuantity(1);

		List<LineItem> lineItems = new ArrayList<LineItem>();
		lineItems.add(lineItm);

		CartDomain cartDomain = new CartDomain();
		cartDomain.setCartId(13432432l);
		cartDomain.setGuestId(UUID.randomUUID().fromString("234233232432"));
		cartDomain.setUserId(UUID.randomUUID().fromString("23243r243r44423"));
		cartDomain.setItems(lineItems);

		Mockito.when(cartService.getCartById(13432432l)).thenReturn(cartDomain);
		mockMvc.perform(MockMvcRequestBuilders.get("/13432432l").accept(org.springframework.http.MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.cartId", Matchers.is(13432432l)))
				.andExpect(MockMvcResultMatchers.jsonPath("$.guestId", Matchers.is("234233232432")))
				.andExpect(MockMvcResultMatchers.jsonPath("$.userId", Matchers.is("23243r243r44423")));
		        .andExpect(MockMvcResultMatchers.jsonPath("$.line_item", Matchers.is(lineItm)));
		        Mockito.verify(cartService).getCartById(13432432l);
	}

	/*
	 * @Test public void findByIdTest() throws Exception {
	 * when(cartService.getCartById(1L)).thenThrow(new
	 * CartManagementException(ErrorCode.CMS0001, HttpStatus.NOT_FOUND,
	 * "not found"));
	 * 
	 * mockMvc.perform(get("/{cartId}", 1L)) .andExpect(status().isNotFound());
	 * 
	 * verify(cartService, times(1)).getCartById(1L); }
	 */

}
