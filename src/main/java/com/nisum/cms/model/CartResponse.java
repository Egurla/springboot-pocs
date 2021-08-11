package com.nisum.cms.model;

import java.util.Collection;
import java.util.UUID;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class CartResponse {

	
	private long cardId;
	private UUID userId;
		private UUID guestId;
	
	private Collection<LineItem> items;
}
