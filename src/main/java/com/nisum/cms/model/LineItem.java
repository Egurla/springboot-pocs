package com.nisum.cms.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LineItem {
	
	/*
	 * public LineItem(long l, double d, long m, int i) { // TODO Auto-generated
	 * constructor stub }
	 */
	private Long id;
	//private Long cartid;
	private Double line_amount;
	private Long productId;
	private Integer quantity;
}
