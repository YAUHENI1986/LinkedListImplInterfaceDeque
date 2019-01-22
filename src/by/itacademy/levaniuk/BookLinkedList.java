package by.itacademy.levaniuk;

import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

import by.itacademy.levaniuk.exception.BookListNotSuportedOperation;

public class BookLinkedList<E> implements Deque<E>{
			
	private Node<E> firstNode;
	private Node<E> lastNode;
	private int size = 0;
	
	public BookLinkedList() {
		firstNode = null;
		lastNode = null;
	}
	
	private static class Node<E>{
		E element;
		Node<E> linkNextElement;
		Node<E> linkPrevElement;
		
		Node(E element, Node<E> linkNextElement, Node<E> linkPrevElement) {
			this.element = element;
			this.linkNextElement = linkNextElement;
			this.linkPrevElement = linkPrevElement;
		}

		public E getElement() {
			return element;
		}

		public void setElement(E element) {
			this.element = element;
		}

		public Node<E> getLinkNextElement() {
			return linkNextElement;
		}

		public void setLinkNextElement(Node<E> linkNextElement) {
			this.linkNextElement = linkNextElement;
		}

		public Node<E> getLinkPrevElement() {
			return linkPrevElement;
		}

		public void setLinkPrevElement(Node<E> linkPrevElement) {
			this.linkPrevElement = linkPrevElement;
		}		
	}

	@Override
	public boolean isEmpty() {
		boolean check = false;
		if (firstNode == null && lastNode == null && size == 0) {
			check = true;
		}
		return check;
	}

	@Override
	public Object[] toArray() {
		int i = size;
		Object[] array = new Object[i];
		Node<E> item = firstNode;
		for(int counter = 0; counter < i; counter++) {
			array[counter] = item.getElement();
			item = item.getLinkNextElement();
		}			
		return array;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object[] toArray(Object[] a) {
		throw new BookListNotSuportedOperation();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean containsAll(Collection c) {
		throw new BookListNotSuportedOperation();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean removeAll(Collection c) {
		throw new BookListNotSuportedOperation();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean retainAll(Collection c) {
		throw new BookListNotSuportedOperation();
	}

	@Override
	public void clear() {
		firstNode = null;
		lastNode = null;
		size = 0;
	}

	@Override
	public void addFirst(E e) {		
		if(isEmpty()) {
			Node<E> item = new Node<E>(e, lastNode, firstNode);
			firstNode = lastNode= item;
			size++;
		} else {
			Node<E> next = firstNode;				
			firstNode = new Node<E>(e, next, null);
			next.setLinkPrevElement(firstNode);
			size++;
		}					
	}

	@Override
	public void addLast(E e) {
		if(isEmpty()) {
			Node<E> item = new Node<E>(e, lastNode, firstNode);
			firstNode = lastNode= item;
			size++;
		} else {
			Node<E> previous = lastNode;
			lastNode = new Node<E>(e, null, previous);
			previous.setLinkNextElement(lastNode);
			size++;
		}						
	}

	@Override
	public boolean offerFirst(E e) {
		addFirst(e);
		return true;
	}

	@Override
	public boolean offerLast(E e) {
		addLast(e);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E removeFirst() {
		Object e = null;
		if(firstNode == null && lastNode == null && size == 0) {
			throw new NoSuchElementException();
		} else {
			if(size == 1) {
				e = firstNode.getElement();
				clear();
			} else {
				e = firstNode.getElement();
				Node<E> next = firstNode;
				next.setElement(firstNode.getLinkNextElement().getElement());
				next.setLinkNextElement(firstNode.getLinkNextElement().getLinkNextElement());
				firstNode = next;
				size--;
				if(size == 1) {
					firstNode = lastNode;
				}
			}			
		}
		return (E) e;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E removeLast() {Object e = null;
		if(firstNode == null && lastNode == null && size == 0) {
			throw new NoSuchElementException();
		} else {
			if(size == 1) {
				e = lastNode.getElement();
				clear();
			} else {
				e = lastNode.getElement();
				Node<E> previous = lastNode;
				previous.setElement(lastNode.getLinkPrevElement().getElement());
				previous.setLinkPrevElement(lastNode.getLinkPrevElement().getLinkPrevElement());
				lastNode = previous;
				size--;
				if(size == 1) {
					firstNode = lastNode;
				}
			}			
		}
		return (E) e;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E pollFirst() {
		Object e = null;
		if(firstNode == null && lastNode == null && size == 0) {
			e = null;
		} else {
			if(size == 1) {
				e = firstNode.getElement();
				clear();
			} else {
				e = firstNode.getElement();
				Node<E> next = firstNode;
				next.setElement(firstNode.getLinkNextElement().getElement());
				next.setLinkNextElement(firstNode.getLinkNextElement().getLinkNextElement());
				firstNode = next;
				size--;
				if(size == 1) {
					firstNode = lastNode;
				}
			}			
		}
		return (E) e;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E pollLast() {
		Object e = null;
		if(firstNode == null && lastNode == null && size == 0) {
			e = null;
		} else {
			if(size == 1) {
				e = lastNode.getElement();
				clear();
			} else {
				e = lastNode.getElement();
				Node<E> previous = lastNode;
				previous.setElement(lastNode.getLinkPrevElement().getElement());
				previous.setLinkPrevElement(lastNode.getLinkPrevElement().getLinkPrevElement());
				lastNode = previous;
				size--;
				if(size == 1) {
					firstNode = lastNode;
				}
			}			
		}
		return (E) e;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E getFirst() {
		Object e = null;
		if(firstNode == null && lastNode == null && size == 0) {
			throw new NoSuchElementException();
		} else {
			e = firstNode.getElement();						
		}
		return (E) e;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E getLast() {
		Object e = null;
		if(firstNode == null && lastNode == null && size == 0) {
			throw new NoSuchElementException();
		} else {
			e = lastNode.getElement();						
		}
		return (E) e;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E peekFirst() {
		Object e = null;
		if(firstNode == null && lastNode == null && size == 0) {
			e = null;
		} else {
			e = firstNode.getElement();						
		}
		return (E) e;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E peekLast() {
		Object e = null;
		if(firstNode == null && lastNode == null && size == 0) {
			e = null;
		} else {
			e = lastNode.getElement();						
		}
		return (E) e;
	}

	@Override
	public boolean removeFirstOccurrence(Object o) {
		if(firstNode!=null && lastNode!=null && size!=0) {
			Node<E> item = firstNode;
			for(int i = 0; i<size; i++) {
				if(o.equals(item.getElement())) {
					if(size == 1) {
						clear();
						return true;
					}
					if(i == 0) {
						if(size == 2) {
							firstNode = lastNode;
							size--;
							return true;
						}						
						Node<E> newFistNode = new Node<E>(item.getLinkNextElement().getElement(), item.getLinkNextElement().getLinkNextElement(), null);
						firstNode.getLinkNextElement().getLinkNextElement().setLinkPrevElement(newFistNode);
						firstNode = newFistNode;
						size--;
						return true;
					}
					if(i == size-1) {
						if(size == 2) {
							lastNode = firstNode;
							size--;
							return true;
						}
						Node<E> newLastNode = new Node<E>(item.getLinkPrevElement().getElement(), null, item.getLinkPrevElement().getLinkPrevElement());
						lastNode.getLinkPrevElement().getLinkPrevElement().setLinkNextElement(newLastNode);
						lastNode = newLastNode;
						size--;
						return true;
					}
					item.getLinkNextElement().setLinkPrevElement(item.getLinkPrevElement());
					item.getLinkPrevElement().setLinkNextElement(item.getLinkNextElement());
					size--;
					return true;
				}				
				item = item.getLinkNextElement();
			}
		}		
		return false;
	}		

	@Override
	public boolean removeLastOccurrence(Object o) {
		if(firstNode!=null && lastNode!=null && size!=0) {
			Node<E> item = firstNode;
			int counterItem = 0;
			for(int i = 0; i<size; i++) {
				if(o.equals(item.getElement())) {
					counterItem = i;
				}
				item = item.getLinkNextElement();
			}
			item = firstNode;
			for(int i = 0; i<size; i++) {
				if(o.equals(item.getElement()) && i == counterItem) {
					if(size == 1) {
						clear();
						return true;
					}
					if(i == 0) {
						if(size == 2) {
							firstNode = lastNode;
							size--;
							return true;
						}						
						Node<E> newFistNode = new Node<E>(item.getLinkNextElement().getElement(), item.getLinkNextElement().getLinkNextElement(), null);
						firstNode.getLinkNextElement().getLinkNextElement().setLinkPrevElement(newFistNode);
						firstNode = newFistNode;
						size--;
						return true;
					}
					if(i == size-1) {
						if(size == 2) {
							lastNode = firstNode;
							size--;
							return true;
						}
						Node<E> newLastNode = new Node<E>(item.getLinkPrevElement().getElement(), null, item.getLinkPrevElement().getLinkPrevElement());
						lastNode.getLinkPrevElement().getLinkPrevElement().setLinkNextElement(newLastNode);
						lastNode = newLastNode;
						size--;
						return true;
					}
					item.getLinkNextElement().setLinkPrevElement(item.getLinkPrevElement());
					item.getLinkPrevElement().setLinkNextElement(item.getLinkNextElement());
					size--;
					return true;					
				}
				item = item.getLinkNextElement();
			}
		}
		return false;
	}

	@Override
	public boolean add(E e) {
		addLast(e);		
		return true;
	}

	@Override
	public boolean offer(E e) {
		boolean check = false;
		check = offerLast(e);
		return check;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E remove() {
		Object e = removeFirst();
		return (E) e;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E poll() {
		Object e = pollFirst();
		return (E) e;
	}

	@Override
	public E element() {
		throw new BookListNotSuportedOperation();
	}

	@SuppressWarnings("unchecked")
	@Override
	public E peek() {
		Object e = peekFirst();
		return (E) e;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean addAll(Collection c) {
		throw new BookListNotSuportedOperation();
	}

	@Override
	public void push(E e) {
		addFirst(e);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public E pop() {
		Object e = removeFirst();
		return (E) e;
	}

	@Override
	public boolean remove(Object o) {
		removeFirstOccurrence(o);
	    return false;
	}

	@Override
	public boolean contains(Object o) {
		if(firstNode!=null && lastNode!=null && size!=0) {
			Node<E> item = firstNode;
			for(int i = 0; i<size; i++) {
				if(o.equals(item.getElement())) {
					return true;
				}				
				item = item.getLinkNextElement();
			}
		}
		return false;
	}

	@Override
	public int size() {
		return size;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Iterator iterator() {
		throw new BookListNotSuportedOperation();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Iterator descendingIterator() {
		throw new BookListNotSuportedOperation();
	}

}