package com.jilani.designpatterns.factorymethodpattern;

public class FactoryMethodClient {

	public static void main(String[] args) {
		
		Shape shape = ShapeFactory.getShape("CIRCLE");
		shape.draw();
		System.out.println();

		shape = ShapeFactory.getShape("RECTANGLE");
		shape.draw();
		System.out.println();

		shape = ShapeFactory.getShape("SQUARE");
		shape.draw();
		System.out.println();
	}

}
