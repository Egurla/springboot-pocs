package com.nisum.cms.service.dto;

import java.util.Collection;
import java.util.UUID;

import com.nisum.cms.model.LineItem;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CartRequestDto {

	private long cardId;

	private UUID userId;
	private UUID guestId;
	private Collection<LineItem> items;

}
