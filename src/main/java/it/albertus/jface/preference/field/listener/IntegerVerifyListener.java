package it.albertus.jface.preference.field.listener;

/** Accepts only numeric inputs and trims automatically. */
public class IntegerVerifyListener extends NumberVerifyListener {

	@Override
	protected boolean isNumeric(final String string) {
		try {
			Integer.parseInt(string);
			return true;
		}
		catch (final Exception e) {
			return false;
		}
	}

}
