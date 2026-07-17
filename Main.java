import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Library Management System");
        System.out.println();


        boolean state = true;
        Library library = new Library(1000);

        while (state) {
            System.out.println("---- Menu ----");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Borrow Book");
            System.out.println("4. Search Book");
            System.out.println("5. Remove Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");
            System.out.println();

            System.out.println("Enter your choice (only numbers)");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("--Add Book--");
                    System.out.println("Enter Book ID");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Book Title");
                    String title = sc.nextLine();
                    System.out.println("Enter Book Author");
                    String author = sc.nextLine();
                    System.out.println("Enter Book Available (true/false");
                    boolean available = sc.nextBoolean();


                    Book book = new Book(id, title, author, available);
                    library.addBook(book);
                    System.out.println("Book added successfully");
                    System.out.println("===========");
                    break;
                case 2:
                    System.out.println("--View Books--");
                    library.showBook();
                    break;
                case 3:
                    System.out.println("--Borrow Book--");
                    System.out.println("Enter Book ID");
                    int borrowId = sc.nextInt();
                    sc.nextLine();
                    library.borrowBook(borrowId);
                    break;
                case 4:
                    sc.nextLine();
                    System.out.println("--Search Book--");
                    System.out.println("Enter Book Title");
                    String searchTitle = sc.nextLine();
                    Book search = library.searchBook(searchTitle);
                    if (search != null) {
                        System.out.println(search);
                    }
                    else System.out.println("Not Found");
                    break;
                case 5:
                    System.out.println("--Remove Book--");
                    System.out.println("Enter Book ID");
                    int removeBookId = sc.nextInt();
                    sc.nextLine();
                    library.removeBook(removeBookId);
                    break;

                case 6:
                    System.out.println("--Return Book--");
                    System.out.println("Enter Book ID");
                    int returnBookId = sc.nextInt();
                    sc.nextLine();
                    System.out.println(library.returnBook(returnBookId));
                    break;

                case 7:
                    System.out.println("Exit");
                    state = false;
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

}
