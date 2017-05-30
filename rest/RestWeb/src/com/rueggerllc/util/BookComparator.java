package com.rueggerllc.util;

import java.util.Comparator;

import com.rueggerllc.beans.Book;

public class BookComparator  implements Comparator<Book> {
	
	public int compare(Book book1, Book book2) {
		Integer id1 = Integer.valueOf(book1.getId());
		Integer id2 = Integer.valueOf(book2.getId());
		
		return -1 * (id1.compareTo(id2));
		
	}
	
	

}
