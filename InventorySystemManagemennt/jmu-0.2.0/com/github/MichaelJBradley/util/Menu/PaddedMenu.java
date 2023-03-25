package com.github.MichaelJBradley.util.Menu;

public abstract class PaddedMenu extends AbstractMenuDecorator {

	protected int pads;
	
	public PaddedMenu() {
		super();
		setPads(0);
	}
	
	public PaddedMenu(Menu menu, int pads) {
		super(menu);
		setPads(pads);
	}
	
	
	//-- Accessors and Mutators --\\
	/**
	 * @return the number of newlines to print around the Menu.
	 */
	public int getPads() {
		return pads;
	}
	
	/**
	 * Set the number of newlines to print around the Menu.
	 * @param pads the number of newlines to print.
	 * @return a reference to this object.
	 */
	public PaddedMenu setPads(int pads) {
		this.pads = pads;
		return this;
	}
	
	
	//-- Miscellaneous --\\
	@Override
	/**
	 * Copy members from another {@link AbstractMenuDecorator decorated menu} to this one.
	 * If the decorated menu is a Padded menu it copies the pads.
	 * @param other the AbstractMenuDecorator to be copied.
	 * @return a reference to this object.
	 */
	public AbstractMenuDecorator copy(AbstractMenuDecorator other) {
		super.copy(other);
		if (other instanceof PaddedMenu) {
			setPads(((PaddedMenu) other).getPads());
		}
		return this;
	}
}
