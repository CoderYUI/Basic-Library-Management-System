public class Library {

    private Book[] books;
    private int count;

    public Library(int size){
        books = new Book[size];
        count = 0;
    }

    public void addBook(Book book){
        if(count>= books.length) {
            System.out.println("There is no more books in the library");
            return;
        }

        books[count] = book;
        count++;
        System.out.println("Book" + book.getId() +" Added Successfullly");
    }

    public void showBook(){
        System.out.println("==== Books ====");

        for(int i = 0; i<count; i++){
            System.out.println("ID: " + books[i].getId() );
            System.out.println("Title: " + books[i].getTitle() );
            System.out.println("Author: " + books[i].getAuthor() );
            System.out.println("Available: " + (books[i].isAvailable() ? "Yes" : "No") );
            System.out.println("------------");
        }
    }

    public Book searchBook(int id){
        for(int i = 0; i<count; i++){
            if(books[i].getId() == id) return books[i];
        }

        return null;
    }

    public Book searchBook(String title){
        for(int i = 0; i<count; i++){
            if(books[i].getTitle().equals(title)) return books[i];
        }
        return null;
    }

    public boolean borrowBook(int id){

        Book book =  searchBook(id);

        if(book == null) {
            System.out.println("Book not Found");
            return false;
        }
        else if (book.isAvailable()) {
            book.setAvailable(false);
            System.out.println("Book Borrowed Successfully");
            return true;
        }
        else {
            System.out.println("Book is already borrowed");
            return false;
        }
    }

    public boolean returnBook(int id){
        Book book = searchBook(id);

        if(book == null) {
            System.out.println("Book not found");
            return false;
        }
        else if(book.isAvailable()) {
            System.out.println("Book never borrowed");
            return false;
        }
        else {
            book.setAvailable(true);
            System.out.println("Book Returned Successfully");
            return true;
        }
    }

    public boolean removeBook(int id){
        Book book = searchBook(id);
        if(book == null) {
            System.out.println("Book not found");
            return false;
        }
        else {
            count = count - 1;
            book.setId(0);
            book.setAvailable(null);
            book.setAuthor(null);
            book.setTitle(null);
            System.out.println("Book removed Successfully");
            return true;
        }
    }

}
