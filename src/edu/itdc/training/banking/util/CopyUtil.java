package edu.itdc.training.banking.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CopyUtil {
	
	@SuppressWarnings("unchecked")
	public static <T> T clone(T object) {
		T copy = null;
		try {
			Class<?> clazz = object.getClass();
			copy = (T) clazz.newInstance();

			Field fields[] = getAllFields(clazz);
			for (Field field : fields) {
				field.setAccessible(true); // make private field accessible
				int modifiers = field.getModifiers();
				if (!Modifier.isStatic(modifiers)) {
					field.set(copy, field.get(object));
				}
			}
		} catch (IllegalAccessException | InstantiationException ex) {
		}
		return copy;
	}

	public static Field[] getAllFields(Class<?> clazz) {
		List<Field> fields = new ArrayList<Field>();
		fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
		
		if (clazz.getSuperclass() != null) {
			fields.addAll(Arrays.asList(getAllFields(clazz.getSuperclass())));
		}
		return fields.toArray(new Field[] {});
	}
}
