package com.github.MichaelJBradley.util.Menu;

import java.util.ArrayList;
import java.util.Collection;

public class MutableMenu extends Menu {

	//-- Instance Members --\\
	private ArrayList<Option> options;
	
	
	//-- Constructors --\\
	/**
	 * Creates a MutableMenu object. Initializes {@link Option Options} list.
	 */
	public MutableMenu() {
		super();
		options = new ArrayList<Option>();
	}
	
	/**
	 * Creates a MutableMenu object. Equivalent to calling: 
	 * <br>
	 * {@code MutableMenu x = MutableMenu();}
	 * <br>
	 * {@code x.addAll(c);}
	 * @param c a {@link Collection} of Option objects to initialize the menu with.
	 */
	public MutableMenu(Collection<? extends Option> c) {
		this();
		options.addAll(c);
	}
	
	/**
	 * Creates a MutableMenu object from a Menu object. That is, it creates a MutableMenu object with the same
	 * options and choice as other.
	 * @param other a {@link Menu} object from which to create this MutableMenu.
	 */
	public MutableMenu(Menu other) {
		this();
		copy(other);
	}
	
	
	//-- List Methods --\\
	@Override
	public int size() {
		return options.size();
	}
	
	@Override
	public Option get(int index) {
		return options.get(index);
	}
	
	@Override
	public Option set(int index, Option element) {
		return options.set(index, element);
	}

	@Override
	public boolean add(Option e) {
		return options.add(e);
	}
	
	@Override
	public void add(int index, Option element) {
		options.add(index, element);
	}
	
	@Override
	public boolean addAll(Collection<? extends Option> c) {
		return options.addAll(c);
	}
	
	@Override
	public boolean addAll(int index, Collection<? extends Option> c) {
		return options.addAll(index, c);
	}

	@Override
	public boolean remove(Object o) {
		return options.remove(o);
	}
	
	@Override
	public Option remove(int index) {
		return options.remove(index);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return options.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return options.retainAll(c);
	}

	@Override
	public void clear() {
		options.clear();
	}
	
	//-- Miscellaneous --\\
	@Override
	public Menu copy(Menu other) {
		super.copy(other);
		clear();
		addAll(other);
		
		return this;
	}
	
	
	
}
