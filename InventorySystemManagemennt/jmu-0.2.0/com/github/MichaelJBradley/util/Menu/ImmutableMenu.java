package com.github.MichaelJBradley.util.Menu;

import java.util.Collection;

public class ImmutableMenu extends Menu {

	//-- Instance Members --\\
	private Option[] options;
	
	
	//-- Constructors --\\
	/**
	 * Creates an ImmutableMenu. Does not allocate the {@link Options Option} array.
	 */
	public ImmutableMenu() {
		super();
	}
	
	/**
	 * Creates an ImmutableMenu with given {@link Options Option}.
	 * @param c a Collection of Options to be set.
	 */
	public ImmutableMenu(Collection<Option> c) {
		this(c.size()); //Allocate options to size for toArray(T[])
		addAll(c);
	}
	
	/**
	 * Creates an ImmutableMenu with given {@link Options Option}.
	 * @param options an array of Options to be set.
	 */
	public ImmutableMenu(Option[] options) {
		this();
		addAll(options);
	}
	
	/**
	 * Creates an ImmutableMenu with an {@link Option} array of length size.
	 * @param size the length of the Option array.
	 */
	public ImmutableMenu(int size) {
		this();
		initOptions(size);
	}
	
	/**
	 * Creates an ImmutableMenu from the data of another {@link Menu}.
	 * @param other the Menu from which the data is copied.
	 */
	public ImmutableMenu(Menu other) {
		this(other.size()); //Allocate options to size for toArray(T[])
		copy(other);
	}

	
	//-- Options --\\
	@Override
	public Option get(int index) {
		return options[index];
	}

	@Override
	public Option set(int index, Option element) {
		Option ret = get(index);
		options[index] = element; 
		return ret;
	}
	
	/**
	 * Sets options array to elements.
	 * @param elements the array of {@link Options Option} to set.
	 * @return the Options previously associated with this ImmutableMenu
	 */
	public Option[] addAll(Option[] elements) {
		Option[] ret = options;
		options = elements;
		return ret;
	}
	
	/**
	 * Initializes an {@link Option} array with the elements of c.
	 * @param c a collection of Options to be set.
	 * @return {@code true} if the Option array was initialized, {@code false} otherwise.
	 */
	@Override
	public boolean addAll(Collection<? extends Option> c) {
		options = c.toArray(options);
		return true;
	}
	
	/**
	 * Initializes {@link Options Option} array to length size.
	 * @param size the length of the array.
	 * @return a reference to this object.
	 */
	public ImmutableMenu initOptions(int size) {
		options = new Option[size];
		return this;
	}
	
	@Override
	public int size() {
		return options.length;
	}

	
	//-- Miscellaneous --\\
	/**
	 * Copies another Menu's data into its own.
	 * Assumes the {@link Option} array has been initialized.
	 */
	@Override
	public Menu copy(Menu other) {
		addAll(other);
		return super.copy(other);
	}
	
	
	//-- Unused --\\
	@Override
	public boolean add(Option e) {
		return false;
	}

	@Override
	public boolean remove(Object o) {
		return false;
	}
	
	@Override
	public boolean addAll(int index, Collection<? extends Option> c) {
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return false;
	}

	@Override
	public void add(int index, Option element) {
	}

	@Override
	public Option remove(int index) {
		return null;
	}

	@Override
	public void clear() {
	}
}
