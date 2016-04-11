package arraylist;

public interface List<E> {

	/**
	 * 
	 * @param element
	 * @return
	 */
	public abstract boolean contains(E element);

	/**
	 * 
	 * @param element
	 * @return
	 */
	public abstract int indexOf(E element);

	/**
	 * 
	 * @param index
	 * @return
	 */
	public abstract E get(int index);

	/**
	 * 
	 * @param element
	 */
	public abstract void add(E element);

	/**
	 * 
	 * @return
	 */
	public abstract E remove();

	/**
	 * 
	 * @param index
	 * @return
	 */
	public abstract E remove(int index);

	/**
	 * 
	 * @return
	 */
	public abstract int size();

	/**
	 * 
	 * @return
	 */
	public abstract boolean isEmpty();

	/**
	 * 
	 * @param a
	 * @return
	 */
	public abstract E[] toArray(E[] a);

}