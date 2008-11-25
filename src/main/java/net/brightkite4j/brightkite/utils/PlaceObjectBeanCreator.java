package net.brightkite4j.brightkite.utils;

import net.brightkite4j.brightkite.models.PlaceObject;

import org.apache.commons.betwixt.io.read.BeanCreationChain;
import org.apache.commons.betwixt.io.read.ChainedBeanCreator;
import org.apache.commons.betwixt.io.read.ElementMapping;
import org.apache.commons.betwixt.io.read.ReadContext;

public class PlaceObjectBeanCreator implements ChainedBeanCreator {

	public Object create(ElementMapping mapping, ReadContext context, BeanCreationChain chain) {
		if (PlaceObject.class.equals(mapping.getType())) {
			System.out.println("creating a place objet");
		}
		return chain.create(mapping, context);
	}

}
