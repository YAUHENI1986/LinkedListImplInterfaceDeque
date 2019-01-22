package by.itacademy.levaniuk.entity;

public class Book {
	
	private String nameBook;
	private String autor;
	private int yearPublishing;
	
	public Book() {}
	
	public Book(String nameBook, String autor, int yearPublishing) {
		this.nameBook = nameBook;
		this.autor = autor;
		this.yearPublishing = yearPublishing;
	}

	public String getNameBook() {
		return nameBook;
	}

	public String getAutor() {
		return autor;
	}

	public int getYearPublishing() {
		return yearPublishing;
	}

	@Override
	public String toString() {
		return "Book [nameBook=" + nameBook + ", autor=" + autor + ", yearPublishing=" + yearPublishing + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + ((nameBook == null) ? 0 : nameBook.hashCode());
		result = prime * result + yearPublishing;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (nameBook == null) {
			if (other.nameBook != null)
				return false;
		} else if (!nameBook.equals(other.nameBook))
			return false;
		if (yearPublishing != other.yearPublishing)
			return false;
		return true;
	}	
	
}