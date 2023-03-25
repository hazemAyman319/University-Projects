package com.github.MichaelJBradley.util.Menu;

import java.util.Collection;

public abstract class AbstractMenuDecorator extends Menu {

	protected Menu menu;
	
	
	/**
	 * Constructs an AbstractMenuDecorator object with its {@link Menu} reference set to {@code null}.
	 */
	public AbstractMenuDecorator() {
		menu = null;
	}
	
	/**
	 * Constructs an AbstractMenuDecorator object with its {@link Menu} reference set to menu.
	 * @param menu the Menu object to be decorated.
	 */
	public AbstractMenuDecorator(Menu menu) {
		setMenu(menu);
	}
	
	public AbstractMenuDecorator(AbstractMenuDecorator other) {
		copy(other);
	}
	
	
	//-- Accessors and Mutators --\\
	/**
	 * @return the {@link Menu} to be decorated.
	 */
	public Menu getMenu() {
		return menu;
	}
	
	/**
	 * Set the {@link Menu} to be decorated.
	 * @param menu the Menu object to be decorated.
	 * @return a reference to this object.
	 */
	public AbstractMenuDecorator setMenu(Menu menu) {
		this.menu = menu;
		return this;
	}
	
	
	//-- Decoration --\\
	@Override
	/**
	 * Concrete Menu decorator classes override this method to decorate the menu.
	 */
	public abstract String toString();
	
	
	//-- Menu Functionality --\\
	@Override
	public int size() {
		return menu.size();
	}
	
	@Override
	public Option get(int index) {
		return menu.get(index);
	}
	
	@Override
	public Option set(int index, Option element) {
		return menu.set(index, element);
	}
	
	@Override
	public boolean add(Option e) {
		return menu.add(e);
	}
	
	@Override
	public void add(int index, Option element) {
		menu.add(index, element);
	}
	
	@Override
	public boolean addAll(Collection<? extends Option> c) {
		return menu.addAll(c);
	}
	
	@Override
	public boolean addAll(int index, Collection<? extends Option> c) {
		return menu.addAll(index, c);
	}
	
	@Override
	public boolean remove(Object o) {
		return menu.remove(o);
	}
	
	@Override
	public Option remove(int index) {
		return menu.remove(index);
	}
	
	@Override
	public boolean removeAll(Collection<?> c) {
		return menu.removeAll(c);
	}
	
	@Override
	public boolean retainAll(Collection<?> c) {
		return menu.retainAll(c);
	}
	
	@Override
	public void clear() {
		menu.clear();
	}
	
	
	//-- Miscellaneous --\\
	@Override
	public Menu copy(Menu other) {
		super.copy(other);
		menu.copy(other);
		
		return this;
	}
	
	/**
	 * Copies another AbstractMenuDecorator's {@link Menu} reference to this.
	 * @param other the AbstractMenuDecorator to be copied.
	 * @return a reference to this object.
	 */
	public AbstractMenuDecorator copy(AbstractMenuDecorator other) {
		setMenu(other.getMenu());
		return this;
	}
	
	
}
