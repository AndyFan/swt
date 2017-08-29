package it.albertus.jface.preference;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import it.albertus.util.Localized;
import it.albertus.util.MapUtils;

public class LocalizedLabelsAndValues implements LabelsAndValues {

	private final Map<Localized, String> entries;

	public LocalizedLabelsAndValues() {
		entries = new LinkedHashMap<Localized, String>();
	}

	public LocalizedLabelsAndValues(final int expectedSize) {
		entries = MapUtils.<Localized, String> newLinkedHashMapWithExpectedSize(expectedSize);
	}

	public LocalizedLabelsAndValues(final Localized name, final Object value) {
		this(1);
		put(name, value);
	}

	public void put(final Localized name, final Object value) {
		entries.put(name, String.valueOf(value));
	}

	@Override
	public String[][] toArray() {
		final String[][] options = new String[entries.size()][2];
		int index = 0;
		for (final Entry<Localized, String> entry : entries.entrySet()) {
			options[index][0] = entry.getKey().getString();
			options[index][1] = entry.getValue();
			index++;
		}
		return options;
	}

	@Override
	public String toString() {
		return entries.toString();
	}

}
