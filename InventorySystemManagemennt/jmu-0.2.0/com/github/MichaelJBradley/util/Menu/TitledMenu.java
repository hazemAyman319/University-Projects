package com.github.MichaelJBradley.util.Menu;

public class TitledMenu extends AbstractMenuDecorator {
	
	private String title;
	
	/**
	 * Constructs a TitledMenu decorator object with its {@link Menu} reference set to {@code null}
	 * and its title set to an empty String.
	 */
	public TitledMenu() {
		super();
		title = "";
	}
	
	/**
	 * Constructs a TitledMenu decorator object with its {@link Menu} and title set to menu and title
	 * respectively.
	 * @param menu the Menu object to be decorated.
	 * @param title a String representing the title of the Menu.
	 */
	public TitledMenu(Menu menu, String title) {
		super(menu);
		setTitle(title);
	}
	
	public TitledMenu(AbstractMenuDecorator other) {
		copy(other);
	}
	
	
	//-- Accessors and Mutators --\\
	/**
	 * @return a String representing the title of this Menu.
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * @param title a String representing the title of this Menu.
	 * @return a reference to this object.
	 */
	public TitledMenu setTitle(String title) {
		this.title = title;
		return this;
	}
	
	
	//-- Decoration --\\
	@Override
	/**
	 * Adds a title with an underline above the {@link Menu}.
	 * @return a String representing the Menu with a title.
	 */
	public String toString() {
		StringBuilder ret = new StringBuilder(title + "\n");
		for (int i = 0; i < title.length(); i++) { 
			ret.append('-');
		}
		ret.append("\n");
		ret.append(menu);
		
		return ret.toString();
	}
	
	
	//-- Miscellaneous --\\
	@Override
	public AbstractMenuDecorator copy(AbstractMenuDecorator other) {
		super.copy(other);
		if (other instanceof TitledMenu) {
			setTitle(((TitledMenu)other).getTitle());
		}
		
		return this;
	}
}
