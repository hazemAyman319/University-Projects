package com.github.MichaelJBradley.util.Menu;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

public class OptionIterator implements ListIterator <Option> {

	List<Option> options;
	int current;
	
	public OptionIterator() {
		this(null, -1);
	}
	
	/**
	 * Creates an OptionIterator object with elements from c, starting at the first element.
	 * @param c the elements to add.
	 */
	public OptionIterator(Collection<Option> c) {
		this(c, -1);
	}
	
	/**
	 * Creates an OptionIterator object with a reference to a Menu, starting at the first element.
	 * @param menu the Menu to reference.
	 */
	public OptionIterator(Menu menu) {
		this(menu, -1);
	}
	
	/**
	 * Creates an OptionIterator object with elements from c.
	 * @param c the elements to add.
	 * @param index the index at which to start iterating from.
	 */
	public OptionIterator(Collection<Option> c, int index) {
		setList(c);
		current = index;
	}
	
	/**
	 * Creates an OptionIterator object with a reference to a Menu.
	 * @param menu the Menu to reference.
	 * @param index the index at which to start iterating from.
	 */
	public OptionIterator(Menu menu, int index) {
		setList(menu);
		current = index;
	}
	
	//-- List Iterator --\\
	@Override
	public boolean hasNext() {
		if (current + 1 >= options.size()) {
			return false;
		}
		
		return options.get(current + 1) != null;
	}

	@Override
	public Option next() {
		return options.get(++current);
	}

	@Override
	public boolean hasPrevious() {
		if (current - 1 < 0) {
			return false;
		}
		
		return options.get(current - 1) != null;
	}

	@Override
	public Option previous() {
		return options.get(--current);
	}

	@Override
	public int nextIndex() {
		return current + 1;
	}

	@Override
	public int previousIndex() {
		return current - 1;
	}
	
	/**
	 * Does nothing.
	 */
	@Override
	public void remove() {
	}

	/**
	 * Does nothing.
	 */
	@Override
	public void set(Option e) {
	}

	/**
	 * Does nothing.
	 */
	@Override
	public void add(Option e) {
	}

	//-- Menu --\\
	/**
	 * Sets the List reference to an ImmutableMenu object containing the options in c.
	 * @param c the options to set.
	 * @return a reference to this object.
	 */
	public OptionIterator setList(Collection<Option> c) {
		options = new ImmutableMenu(c);
		return this;
	}
	
	/**
	 * Sets the List reference to menu.
	 * @param menu the Menu to be set.
	 * @return a reference to this object.
	 */
	public OptionIterator setList(Menu menu) {
		this.options = menu;
		return this;
	}
	
	public List<Option> getList() {
		return options;
	}
	
	//-- Current --\\
	public int getCurrent() {
		return current;
	}
	
	
}
