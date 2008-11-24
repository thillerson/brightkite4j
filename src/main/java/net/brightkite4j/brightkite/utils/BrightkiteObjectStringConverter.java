package net.brightkite4j.brightkite.utils;

import org.apache.commons.betwixt.expression.Context;
import org.apache.commons.betwixt.strategy.DefaultObjectStringConverter;

public class BrightkiteObjectStringConverter extends DefaultObjectStringConverter {

	private static final long serialVersionUID = 7803846260535417624L;

	@Override
	@SuppressWarnings("unchecked")
	public String objectToString(Object object, Class type, Context context) {
		return super.objectToString(object, type, context);
	}

	@Override
	@SuppressWarnings("unchecked")
	public Object stringToObject(String value, Class type, Context context) {
		String o = (String)context.getOptions().getValue("net.brightkite4j.elementSameAsParent");
		if (o != null && o.equals("true")) {
			return value;
		} else {
			return super.stringToObject(value, type, context);
		}
	}

}
