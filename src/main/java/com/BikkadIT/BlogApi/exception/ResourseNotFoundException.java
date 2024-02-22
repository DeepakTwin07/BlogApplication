package com.BikkadIT.BlogApi.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResourseNotFoundException extends RuntimeException {

	String resourceName;
	String FieldName;
	long fieldValue;
	
	public ResourseNotFoundException(String resourceName, String fieldName, long fieldValue) {
		super(String.format("%s not found with %s : %s", resourceName, fieldName, fieldValue));
		this.resourceName = resourceName;
		this.FieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	
}
