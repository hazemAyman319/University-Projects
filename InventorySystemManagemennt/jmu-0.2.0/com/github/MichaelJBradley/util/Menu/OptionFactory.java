package com.github.MichaelJBradley.util.Menu;

import java.util.ArrayList;
import java.util.Collection;

/**
 * A concrete Option Factory class that that extends {@link AbstractOptionFactory}.<br>
 * This class creates basic {@link Option Options} that only contain their option text.
 * 
 * @author Michael Bradley
 *
 */
public class OptionFactory extends AbstractOptionFactory {
	
	public OptionFactory() {
		super();
	}
	
	public OptionFactory(OptionFactory other) {
		super(other);
	}
	
	//-- Option List --\\	
	@Override
	/**
	 * Add an {@link Option} to the current Option list.
	 * @param option a String representing the option's text. 
	 * @return a reference to this object.
	 */
	public AbstractOptionFactory add(String option) {
		optList.add(create(option));
		return this;
	}
	
	
	//-- Create Options --\\
	@Override
	/**
	 * Create an {@link Option} with a specified option text.
	 * @param option a String representing the option's text.
	 * @return the created Option.
	 */
	public Option create(String option) {
		return new Option(option);
	}

	
	@Override
	/**
	 * Create a Collection of {@link Option Options} from specified options texts.
	 * @param options an array of Strings representing each option's text.
	 * @return the created collection of Options.
	 */
	public Collection<Option> createList(String[] options) {
		ArrayList<Option> list = new ArrayList<Option>(options.length);
		for (int i = 0; i < options.length; i++) {
			list.add(create(options[i]));
		}
		
		return list;
	}
}
