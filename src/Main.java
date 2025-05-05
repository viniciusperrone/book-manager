import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        LinkedList Personalizada
//        LinkedListBook library = new LinkedListBook();
//
//        library.append(new Book("Clean Code", "Robert C. Martin", 2004));
//        library.append(new Book("Clean Architecture", "Robert C. Martin", 2005));
//        library.append(new Book("Baghavad Geeta", "Krishna", 1999));
//
//        library.printList();

        List<Book> library = new LinkedList<>();

        library.add(new Book("Clean Code", "Robert C. Martin", 2004));
        library.add(new Book("Clean Architecture", "Robert C. Martin", 2005));
        library.add(new Book("Baghavad Geeta", "Krishna", 1999));

        System.out.println("Lista de livros:");
        int i = 1;
        for (Book book : library) {
            System.out.println(i + ". " + book);
            i++;
        }
    }
}