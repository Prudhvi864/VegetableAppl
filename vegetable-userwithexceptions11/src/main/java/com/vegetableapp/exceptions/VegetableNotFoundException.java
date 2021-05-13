package com.vegetableapp.exceptions;

import net.bytebuddy.implementation.bind.annotation.Super;

public class VegetableNotFoundException extends RuntimeException {
	public VegetableNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public VegetableNotFoundException() {
		// TODO Auto-generated constructor stub
	}

}
