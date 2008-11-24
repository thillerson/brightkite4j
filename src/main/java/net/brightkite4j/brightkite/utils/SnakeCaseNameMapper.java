package net.brightkite4j.brightkite.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.betwixt.strategy.DecapitalizeNameMapper;

public class SnakeCaseNameMapper extends DecapitalizeNameMapper {

	@Override
	public String mapTypeToElementName(String name) {
		String decapped = super.mapTypeToElementName(name);
		StringBuffer newElement = new StringBuffer();
		Pattern p = Pattern.compile("([A-Z])");
		Matcher matcher = p.matcher(decapped);
		while (matcher.find()) {
			matcher.appendReplacement(newElement, "_" + matcher.group().toLowerCase());
		}
		matcher.appendTail(newElement);
		return newElement.toString();
	}

}
