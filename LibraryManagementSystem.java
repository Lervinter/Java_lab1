import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private String isbn;
    private int year;

    
    public Book(String title, String author, String isbn, int year) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
    }

  
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", year=" + year +
                '}';
    }
}

class Library {
    private ArrayList<Book> books = new ArrayList<>();

 
    public void addBook(Book book) {
        books.add(book);
    }

 
    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

 
    public void searchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println(book);
                return;
            }
        }
        System.out.println("Book not found.");
    }

   
    public void deleteBookByIsbn(String isbn) {
        books.removeIf(book -> book.getIsbn().equals(isbn));
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

       
        library.addBook(new Book("Java: The Complete Reference", "Herbert Schildt", "978-1260440224", 2021));
        library.addBook(new Book("Clean Code: A Handbook of Agile Software Craftsmanship", "Robert C. Martin", "978-0132350884", 2008));
        library.addBook(new Book("Design Patterns: Elements of Reusable Object-Oriented Software", "Erich Gamma", "978-0201633610", 1994));

        while (true) {
            System.out.println("\n1. Add Book\n2. Display Books\n3. Search by Title\n4. Delete by ISBN\n5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Enter year: ");
                    int year = scanner.nextInt();

                    library.addBook(new Book(title, author, isbn, year));
                    break;
                case 2:
                    library.displayBooks();
                    break;
                case 3:
                    System.out.print("Enter title to search: ");
                    String searchTitle = scanner.nextLine();
                    library.searchByTitle(searchTitle);
                    break;
                case 4:
                    System.out.print("Enter ISBN to delete: ");
                    String deleteIsbn = scanner.nextLine();
                    library.deleteBookByIsbn(deleteIsbn);
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}