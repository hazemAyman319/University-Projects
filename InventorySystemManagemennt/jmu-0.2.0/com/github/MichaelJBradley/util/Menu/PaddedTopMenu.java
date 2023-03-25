package com.github.MichaelJBradley.util.Menu;

public class PaddedTopMenu extends PaddedMenu {

	
	public PaddedTopMenu() {
		super();
	}
	
	public PaddedTopMenu(Menu menu, int pads) {
		super(menu, pads);
	}
	
	
	//-- Decoration --\\
	@Override
	/**
	 * Print newlines before the given Menu.
	 * @return a String representing the menu with {@link #pads} number of newlines added before it.
	 */
	public String toString() {
		StringBuilder ret = new StringBuilder();
		
		for (int i = 0; i < pads; i++) {
			ret.append("\n");
		}
		ret.append(menu.toString());
		
		return ret.toString();
	}
}