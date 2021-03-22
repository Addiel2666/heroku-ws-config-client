package com.heroku.create.config.dto;

import java.io.Serializable;

import com.netflix.discovery.provider.Serializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Serializer
public class ObjectReturnDecrypt implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9164768876372693444L;
	private String claveResponse;
	
}
