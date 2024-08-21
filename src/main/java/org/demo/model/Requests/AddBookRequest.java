package org.demo.model.Requests;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AddBookRequest{
	private List<CollectionOfIsbnsItem> collectionOfIsbns;
	private String userId;
}