package com.github.MichaelJBradley.util.Menu;

public class Option {

	//-- Instance Members --\\
	private String text;
	
	
	//-- Constructors --\\
	public Option() {
		text = new String();
	}
	
	public Option(String text) {
		setText(text);
	}
	
	public Option(Option other) {
		copy(other);
	}
	
	
	//-- Input --\\
	/**
	 * A method used to define the functionality of an option.
	 * @return a reference to this object.
	 */
	public Option choose() {
		//option functionality goes here
		return this;
	}
	
	//-- Output --\\
	/**
	 * This method is the same as calling {@link Option#getText()}.
	 * @return the option's text. 
	 */
	@Override
	public String toString() {
		return text;
	}
	
	
	//-- Text --\\
	public String getText() {
		return text;
	}
	
	/**
	 * Sets the Option's text.
	 * @param text a String with the text to be set.
	 * @return a reference to this object.
	 */
	public Option setText(String text) {
		this.text = text;
		return this;
	}
	
	
	//-- Miscellaneous --\\
	/**
	 * Duplicates another Option by copying all data from other to this one.
	 * @param other the Option to be copied.
	 * @return a reference to this object.
	 */
	public Option copy(Option other) {
		setText(other.getText());
		return this;
	}
}
