package by.itacademy.levaniuk;

import by.itacademy.levaniuk.entity.Book;

public class MainAppLinkedList {

	public static void main(String[] args) {
				
		BookLinkedList<Book> j = new BookLinkedList<Book>();
		System.out.println(j.isEmpty());
		j.addFirst(new Book());
		j.addLast(new Book());
		j.offerFirst(new Book());
		j.offerLast(new Book(null, null, 1));
		j.add(new Book("LastBook", "Pupkin", 1));
		
		System.out.println("This firstNode" + j.getFirst());
		System.out.println("This lastNode" + j.getLast());
		
		
		Object[] jj = j.toArray();
		System.out.println(jj[jj.length-1]);
		System.out.println(j.isEmpty());

		System.out.println();
	}

}
