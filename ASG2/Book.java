public class Book{
    String title;
    String ISBN;
    Author author;
    String desc;

    public Book(String title, String ISBN, Author author){
        this.title = title;
        this.ISBN = ISBN;
        this.author = author;
        this.desc = author.desc;

    }
}