package com.github.MichaelJBradley.util.Menu;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public abstract class Menu implements List<Option> {

	//-- Static Members --\\
	protected static Scanner STDIN = new Scanner(System.in);

	//-- Instance Members --\\
	protected int choice;


	//-- Constructors --\\
	public Menu() {
		setChoice(-1);
	}


	//-- Output --\\
	/**
	 * @return a String consisting of a numbered list of Options
	 */
	@Override
	public String toString() {
		StringBuilder ret = new StringBuilder();
		Iterator<Option> iter = iterator();
		int optNum = 1;
		
		while (iter.hasNext()) {
			ret.append(optNum++ + ". " + iter.next() + "\n");
		}
		

		return ret.toString();
	}

	/**
	 * Prints the Menu to the standard output.
	 * @return a reference to this object.
	 */
	public Menu display() {
		System.out.println(toString());
		return this;
	}

	//-- Input --\\
	/**
	 * Prompts user to enter an int from standard input. Handles invalid inputs by prompting user again.
	 * @return a user entered int.
	 */
	public static int getInputRaw() {
		boolean valid;
		int input = -1;
		do {
			valid = true;
			System.out.print("Enter: ");
			try {
				input = STDIN.nextInt();
			} catch (InputMismatchException e) {
				STDIN.nextLine();
				valid = false;
			}
		} while (!valid);
		
		return input;
	}

	/**
 	 * Prompts user to enter an option number. 
 	 * Sets choice to user inputed value. 
 	 * Prompts user until a valid option is entered.
	 * @return a reference to this object.
	 */
	public Menu getInput() {
		int c;
		do {
			c = getInputRaw();
		} while (!isValid(c));
		
		setChoice(c);
		
		return this;
	}
	
	/**
	 * A choice is valid if:
	 * <br>
	 * - the size of the Menu is 0
	 * <br>
	 * - it is greater than or equal to 1 (the first choice) and less than or equal to size (the last choice) 
	 * @param choice the int to be validated.
	 * @return true if conditions are met
	 */
	public boolean isValid(int choice) {
		return size() == 0 || (1 <= choice && choice <= size());
	}
	
	//-- Choice --\\
	public int getChoice() {
		return choice;
	}
	
	public Menu setChoice(int c) {
		choice = c;
		return this;
	}
	
	
	//-- Options --\\
	/**
	 * A convenience function that essentially calls {@code Menu.get(Menu.getChoice() - 1)}
	 * @return the most recent {@link Option} chosen by the user.
	 */
	public Option getChosen() {
		return get(choice - 1);
	}
	
	/**
	 * @param o the object to test.
	 * @return false if o is null, not of type Option, or could not be found in the Menu.
	 */
	@Override
	public boolean contains(Object o) {
		return indexOf(o) != -1;
	}
	
	/**
	 * @param c the collection to be tested.
	 * @return true if and only if all elements in c are in this Menu.
	 */
	@Override
	public boolean containsAll(Collection<?> c) {
		for (Object o : c) {
			if (!contains(o)) {
				return false;
			}
		}
		
		return true;
	}
	
	@Override
	public int indexOf(Object o) {
		if (!validateOption(o)) {
			return -1;
		}
		 
		ListIterator<Option> iter = listIterator();
		int index;
		
		while (iter.hasNext()) {
			index = iter.nextIndex();
			if (iter.next().equals(o)) {
				return index;
			}
		}
		
		return -1;
	}
	
	@Override
	public int lastIndexOf(Object o) {
		if (!validateOption(o)) {
			return -1;
		}
		
		ListIterator<Option> iter = listIterator(size());
		int index;
		
		while (iter.hasPrevious()) {
			index = iter.previousIndex();
			if (iter.previous().equals(o)) {
				return index;
			}
		}
		
		return -1;
	}
	
	@Override
	public boolean isEmpty() {
		return size() == 0;
	}
	
	@Override
	public Iterator<Option> iterator() {
		return listIterator();
	} 
	
	@Override
	public ListIterator<Option> listIterator() {
		return new OptionIterator(this);
	}
	
	@Override
	public ListIterator<Option> listIterator(int index) {
		return new OptionIterator(this, index);
	}
	
	@Override
	public List<Option> subList(int fromIndex, int toIndex) {
		ArrayList<Option> ret = new ArrayList<Option>();
		
		for (int i = fromIndex; i <= toIndex; i++) {
			ret.add(get(i));
		}
		
		return ret;
	}
	
	@Override
	public Object[] toArray() {
		Object[] ret = new Object[size()];
		
		for (int i = 0; i < ret.length; i++) {
			ret[i] = new Option(get(i));
		}
		
		return ret;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public <T> T[] toArray(T[] a) {
		int size = size();
		T[] ret = a.length >= size ? a : (T[])Array.newInstance(a.getClass().getComponentType(), size);
		
		ListIterator<Option> iter = listIterator();
		
		for (int i = 0; i < ret.length; i++) {
			if (!iter.hasNext()) { 					//no more elements
				if (ret != a) { 						//ret has been reallocated
					return Arrays.copyOf(ret, i); 	//List had less elements than expected so return truncated array
				}
													//ret still references a
				ret[i] = null;						//a is larger so terminate with null
				return ret;
			}
			ret[i] = (T)iter.next();
		}
		
		//hopefully never happens
		if (iter.hasNext()) {						//List had more elements than expected
			System.err.println("Menu.toArray(T[]): Iterator and size are mismatched. Fix this.");
			ret = finishToArray(ret, iter.nextIndex());
		}
		
		return ret;
	}
	
	@SuppressWarnings("unchecked")
	private <T> T[] finishToArray(T[] a, int index) {
		ListIterator<Option> iter = listIterator(index);
		int elementsLeft = 0;
		int i = 0;
		
		//count elements left
		while (iter.hasNext()) {
			elementsLeft++;
			iter.next();
		}
		
		//resize to exactly how many are left
		a = Arrays.copyOf(a, a.length + elementsLeft);
		
		//copy remaining elements
		iter = listIterator(index);
		while (iter.hasNext()) {
			a[i++] = (T)iter.next();
		}
		
		return a;
	}
	
	//-- Miscellaneous --\\
	/**
	 * Copies another Menu's data into its own.
	 * @param other the Menu to be copied.
	 * @return a reference to this object.
	 */
	 public Menu copy(Menu other) {
		 setChoice(other.getChoice());
		 return this;
	 }
	
	/**
	 * @param obj the object to be compared.
	 * @return true if and only if obj is an instance of type Menu, both Menus have the same number of options,
	 * and {@link Menu#containsAll(Collection)} returns true.
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Menu)) {
			return false;
		}
		
		Menu other = (Menu)obj;
		
		if (other.size() != size()) {
			return false;
		}
		
		return other.containsAll(this);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	/**
	 * Checks that o is a valid Option object.
	 * @param o the Object to test.
	 * @return true if and only if o is not null and is an instance of Option.
	 */
	public static boolean validateOption(Object o) {
		if (o == null) {
			return false;
		}
		
		if (!(o instanceof Option)) {
			return false;
		}
		
		return true;
	}
}
