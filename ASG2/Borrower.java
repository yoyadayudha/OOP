import java.util.*;

public class Borrower{
    String name;
    ArrayList<Book> borrowedBooks = new ArrayList<>();

public Borrower(String name){
    this.name = name;
    this.borrowedBooks = new ArrayList<>();
}

public void displayBorrowedBooks(){
    System.out.println(name + "'s Borrowed Books:");
    for(Book book : borrowedBooks){
        System.out.println("Title: " + book.title);
        System.out.println("ISBN: " + book.ISBN);
        System.out.println("Author: " + book.author.name);
        System.out.println("Biography: " + book.desc);
        System.out.println("-----------------------------");
    }
}
    
}