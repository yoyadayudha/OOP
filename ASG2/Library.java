import java.util.*;

public class Library{
    ArrayList<Book> books = new ArrayList<Book>();

    public Library(){
        this.books = new ArrayList<>();
    }
    public void addBook(Book book){
        books.add(book);
        System.out.println("Book added to library: " + book.title);
        
    }

    public void borrowBook(Borrower borrower, Book book){
        if(books.contains(book)){
            books.remove(book);
            borrower.borrowedBooks.add(book);
            System.out.println(borrower.name + " borrowed: " + book.title);
        }
    }

    public void returnBook(Borrower borrower, Book book){
        books.add(book);
        borrower.borrowedBooks.remove(book);
        System.out.println(borrower.name + " returned: " + book.title); 
    }

    public void displayLibraryBooks(){
        System.out.println("Books in Library:");
        for(Book book : books){
            System.out.println("Title: " + book.title);
            System.out.println("ISBN: " + book.ISBN);
            System.out.println("Author: " + book.author.name);
            System.out.println("Biography: " + book.desc);
            System.out.println("-----------------------------");
        }
    }
}   