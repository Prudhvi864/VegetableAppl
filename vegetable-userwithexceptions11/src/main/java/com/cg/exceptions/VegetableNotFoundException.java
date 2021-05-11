package com.cg.exceptions;

import net.bytebuddy.implementation.bind.annotation.Super;

public class VegetableNotFoundException extends RuntimeException{
	 public VegetableNotFoundException(String message) {
		super(message);
	}
	 public VegetableNotFoundException() {
			
		}

}
