package assign03;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author Luan Xing, Junlin Su
 * @version February 10, 2021
 */
public class SimplePriorityQueue<E> implements PriorityQueue<E> {

	private E[] queue;

	private int size;

	private Comparator<? super E> cmp;

	@SuppressWarnings("unchecked")
	public SimplePriorityQueue() {
		queue = (E[]) new Object[16];
		this.size = 0;
	}

	@SuppressWarnings("unchecked")
	public SimplePriorityQueue(Comparator<? super E> cmp) {
		queue = (E[]) new Object[16];
		this.size = 0;
		this.cmp = cmp;
	}

	@SuppressWarnings("unchecked")
	private void buildBigArray() {
		E[] newArray = (E[]) new Object[queue.length * 2];
		for(int i =0;i<queue.length ;i++) {
			newArray[i]=queue[i];
		}
		queue =newArray;
	}

	/**
	 * Retrieves, but does not remove, the minimum element in this priority queue.
	 * 
	 * @return the minimum element
	 * @throws NoSuchElementException if the priority queue is empty
	 */
	@Override
	public E findMin() throws NoSuchElementException {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		return queue[size - 1];
	}

	/**
	 * Retrieves and removes the minimum element in this priority queue.
	 * 
	 * @return the minimum element
	 * @throws NoSuchElementException if the priority queue is empty
	 */
	@Override
	public E deleteMin() throws NoSuchElementException {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		E smallest = queue[size - 1];
		queue[size - 1]=null;
		size--;
		return smallest;
	}

	/**
	 * Inserts the specified element into this priority queue.
	 * 
	 * @param item - the element to insert
	 */
	@Override
	public void insert(E item) {
		if(size==queue.length ) {
			buildBigArray();
		}
		int index= binarySearch(item);
		if(this.size ==0) {
			queue[0] =item;
			size++;
		}else {
			if(index == 0){
				for(int i = size; i > 0; i--) {
					queue[i] = queue[i - 1];
				}
					queue[0] = item;
					size++;
			}else {
				for(int i = size; i > index; i--) {
					queue[i] = queue[i - 1];
				}
					queue[index] = item;
					size++;
			}
		}

	}

	@SuppressWarnings("unchecked")
	public int binarySearch(E insert) {
		int index =0;
		if(this.cmp == null) {
			int lhs = 0;
			int rhs = this.size - 1;
			while (lhs <= rhs) {
				int mid = (lhs + rhs) / 2;
				if (((Comparable<? super E>) queue[mid]).compareTo(insert) == 0) {
					return mid;
				} else if (((Comparable<? super E>) queue[mid]).compareTo(insert) < 0) {
					rhs = mid - 1;
					
				} else {
					lhs = mid + 1;
					
				}
				index =lhs;
		}
			return index;
		}else if(this.cmp!=null) {
			int lhs =0;
			int rhs =this.size -1;
			while (lhs <= rhs) {
				int mid = (lhs + rhs) / 2;
				if (this.cmp.compare(queue[mid],(E)insert)== 0) {
					return mid;
				} else if (this.cmp.compare(queue[mid],(E)insert) < 0) {
					rhs = mid - 1;
					
				} else {
					lhs = mid + 1;
					
				}
				index =lhs;
		}
		}
		return index;
	
	}

	/**
	 * Inserts the specified elements into this priority queue.
	 * 
	 * @param coll - the collection of elements to insert
	 */
	@Override
	public void insertAll(Collection<? extends E> coll) {
		Iterator<? extends E> iterator = coll.iterator();
		while (iterator.hasNext()) {
			E obj = iterator.next();
			insert(obj);
		}
	}

	/**
	 * @return the number of elements in this priority queue
	 */
	@Override
	public int size() {

		return size;
	}

	@Override
	public boolean isEmpty() {
		if (this.size == 0) {
			return true;
		}
		return false;
	}

	@Override
	public void clear() {
		size = 0;

	}

}
