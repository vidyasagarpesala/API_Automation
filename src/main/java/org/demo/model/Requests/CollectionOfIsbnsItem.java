package org.demo.model.Requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CollectionOfIsbnsItem{
	private String isbn;
}