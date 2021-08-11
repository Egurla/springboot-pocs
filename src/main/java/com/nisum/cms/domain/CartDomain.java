package com.nisum.cms.domain;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nisum.cms.model.LineItem;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "cart")
public class CartDomain {

	public CartDomain(int i, UUID randomUUID, UUID randomUUID2, List<LineItem> lineItems) {
		// TODO Auto-generated constructor stub
	}
	@JsonProperty("_id")
	private String id;
	
	private long cartId;
	private UUID userId;
	private UUID guestId;
	private Collection<LineItem> items;

	
}
