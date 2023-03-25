package com.github.MichaelJBradley.util.Menu;

import java.util.ArrayList;
import java.util.Collection;

/**
 * An abstract Option Factory class that defines the functionality of all inheriting Option Factories.<br>
 * Option Factories have the ability to create single Options from a String or a Collection of Options from an
 * array of Strings.<br>
 * This class contains a Collection to store Options so that they can be added as needed and returned together.
 *  
 * @author Michael Bradley
 *
 */
public abstract class AbstractOptionFactory {
	
	protected ArrayList<Option> optList;
	
	public AbstractOptionFactory() {
		optList = new ArrayList<Option>();
	}
	
	public AbstractOptionFactory(AbstractOptionFactory other) {
		this();
		copy(other);
	}
	
	
	//-- Option List --\\
	/**
	 * @return a Collection of options that were added to this list.
	 */
	public Collection<Option> getOptList() {
		return optList;
	}

	/**
	 * Clear the current Option list.
	 * @return a reference to this object.
	 */
	public AbstractOptionFactory clearOptList() {
		optList.clear();
		return this;
	}
	
	/**
	 * Add an Option to the current Option list.
	 * @param option a String representing the option's text. 
	 * @return a reference to this object.
	 */
	public abstract AbstractOptionFactory add(String other);
	
	
	//-- Create Options --\\
	/**
	 * Create an Option with a specified option text.
	 * @param option a String representing the option's text.
	 * @return the created Option.
	 */
	public abstract Option create(String other);
	
	/**
	 * Create a Collection of Options from specified options texts.
	 * @param options an array of Strings representing each option's text.
	 * @return the created collection of Options.
	 */
	public abstract Collection<Option> createList(String[] option);
	
	
	//-- Miscellaneous --\\
	@Override
	public String toString() {
		if (optList.size() == 0) {
			return "Option list is empty";
		}
		
		StringBuilder ret = new StringBuilder();
		
		for (int i = 0; i < optList.size(); i++) {
			ret.append((i + 1) + ". " + optList.get(i) + "\n");
		}
		
		return ret.toString();
	}
	
	/**
	 * Copy another AbstractOptionFactory's Option List into this.
	 * @param other the OptionFactory to be copied.
	 * @return a reference to this object.
	 */
	public AbstractOptionFactory copy(AbstractOptionFactory other) {
		clearOptList();
		optList.addAll(other.getOptList());
		
		return this;
	}
}
