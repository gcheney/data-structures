package com.glendoncheney.stacks;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This class demonstrates creating a stack
 * by using two queues
 * @author glen
 *
 * @param <E>
 */
public class QueuedStack<E> implements Stack<E> {

	Queue<E> main = new LinkedList<E>();
    Queue<E> storage = new LinkedList<E>();

    
    @Override
    public E pop() {
        if (main.peek() == null) {
            throw new StackEmptyException("The stack is empty,"
            		+ " nothing to return");
        } 
        else {
            E pop = main.remove();
            return pop;
        }
    }

    @Override
    public E push(E element) {
        if (main.isEmpty()) {
            main.add(element);
        } 
        else {
            while (!main.isEmpty()) {
                storage.add(main.remove());
            }
            
            main.add(element);
            
            while (!storage.isEmpty()) {
                main.add(storage.remove());
            }
        }       
        
        return element;
    }


	@Override
	public boolean isEmpty() {
		return main.isEmpty();
	}


	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public E peek() {
		return main.peek();
	}

	@Override
	public int size() {
		return main.size();
	}

}
