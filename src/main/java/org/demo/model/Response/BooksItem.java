package org.demo.model.Response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BooksItem{
	private String website;
	private int pages;
	private String subTitle;
	private String author;
	private String isbn;
	private String publisher;
	private String description;
	private String title;
	private String publishDate;
}