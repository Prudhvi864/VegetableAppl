package com.cg.exceptions;

import net.bytebuddy.implementation.bind.annotation.Super;

public class VegetableNameNotFoundException extends RuntimeException{
	 public VegetableNameNotFoundException(String message) {
		super(message);
	}
	 public VegetableNameNotFoundException() {
			
		}

}
