package com.jilani.designpatterns.factorymethodpattern;

public class ShapeFactory {

	static Shape getShape(String shapeType) {

		if (shapeType == null || shapeType.isEmpty())
			return null;

		if (shapeType.toUpperCase().equals("CIRCLE"))
			return new Circle();
		else if (shapeType.toUpperCase().equals("RECTANGLE"))
			return new Rectangle();
		else if (shapeType.toUpperCase().equals("SQUARE"))
			return new Square();

		return null;
	}

}
