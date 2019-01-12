package mars;

import mars.*;
import mars.util.*;
import mars.venus.editors.jeditsyntax.*;
import java.io.*;
import java.util.*;
import java.util.prefs.*;
import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;

public enum Setting {
	PREF_VERSION(0);

	public static final int VERSION = 1;
	public static final String FILENAME = "Settings";

	private final Object defaultValue;
	private Object value;
	
	private List<SettingChangedListener> listeners;

	Setting(Object defaultValue) {
		value = this.defaultValue = defaultValue;
		try {
			fromString(Globals.getPropertyEntry(FILENAME, name()));
		} catch (Exception ignored) {}

		listeners = new ArrayList<>();
	}

	public void addListener(SettingChangedListener listener) {
		listeners.add(listener);
	}

	public void removeListener(SettingChangedListener listener) {
		listeners.remove(listener);
	}

	public <T> T getDefaultValue() {
		if (value == null)
			return null;
		
		try {
			return (T) defaultValue;
		} catch (ClassCastException e) {
			throw new TypeMismatchException(this);
		}
	}

	public <T> T getValue() {
		if (value == null)
			return null;
		
		try {
			return (T) value;
		} catch (ClassCastException e) {
			throw new TypeMismatchException(this);
		}
	}

	public <T> void setValue(T newValue) {
		if (defaultValue.getClass().isAssignableFrom(value.getClass())) {
			value = newValue;

			for (SettingChangedListener listener : listeners)
				listener.onSettingChanged(this);			
		}
	}

	private void fromString(String valueString) {
		if (defaultValue instanceof Boolean) 
			value = Boolean.valueOf(valueString);
		else if (defaultValue instanceof Integer)
			value = Integer.valueOf(valueString);
		else if (defaultValue instanceof String)
			value = valueString;

		throw new TypeMismatchException(this);
	}

	@Override
	public String toString() {
		return value + "";
	}

	public static void get() {
		Preferences preferences = Preferences.userNodeForPackage(Setting.class);
		for (Setting setting : values()) {
			setting.fromString(preferences.get(setting.name(), setting.toString()));
		}
	}

	public static void put() {
		Preferences preferences = Preferences.userNodeForPackage(Setting.class);
		try {
			for (Setting setting : values())
				preferences.put(setting.name(), setting.getValue());
			
			preferences.flush();
		} catch (SecurityException se) {
		} catch (BackingStoreException bse) {
		}
	}

	public interface SettingChangedListener {
		void onSettingChanged(Setting setting);
	}

	public static class TypeMismatchException extends RuntimeException {

		public TypeMismatchException(Setting setting) {
			this(setting, null);
		}

		public TypeMismatchException(Setting setting, Class type) {
			super("Wrong type used for \"" + setting.name() + "\": expected " 
					+ setting.defaultValue.getClass().getName()
					+ (type != null ? ", got " + type.getName() : ""));
		}
		
	}
}
