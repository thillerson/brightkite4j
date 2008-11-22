package net.brightkite4j.brightkite.utils;

import java.lang.reflect.Field;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.joda.time.DateTime;

import net.sf.json.JSONException;
import net.sf.json.util.PropertySetStrategy;

public class DateTimePropertySetStrategy extends PropertySetStrategy {

	@Override
	@SuppressWarnings("unchecked")
	public void setProperty(Object bean, String key, Object value) throws JSONException {
		if (bean instanceof Map) {
			((Map) bean).put(key, value);
		} else {
			try {
				Class klass = bean.getClass();
				Field field = klass.getField(key);
				if (field.getClass().equals(DateTime.class) && value.getClass().equals(String.class)) {
					value = BrightkiteUtils.parseDateTimeFromString((String)value);
				}
				PropertyUtils.setSimpleProperty(bean, key, value);
			} catch (Exception e) {
				throw new JSONException(e);
			}
		}
	}

}
