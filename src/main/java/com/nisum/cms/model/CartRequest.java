package com.nisum.cms.model;

import java.util.Collection;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CartRequest {

	
	private long cardId;
	private UUID userId;
	private UUID guestId;
	private Collection<LineItem> items;
}
