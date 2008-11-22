package net.brightkite4j.brightkite.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.util.JavaIdentifierTransformer;

public class SnakeToCamelIdentifierTransformer extends JavaIdentifierTransformer {

	@Override
	public String transformToJavaIdentifier(String stringIdentifier) {
		StringBuffer sb = new StringBuffer();
		Pattern p = Pattern.compile("_([a-z])");
		Matcher m = p.matcher(stringIdentifier);
		while (m.find()) {
			m.appendReplacement(sb, m.group().replace("_", "").toUpperCase());
		}
		m.appendTail(sb);

		return sb.toString();
	}

}
