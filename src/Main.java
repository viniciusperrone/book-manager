//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LinkedListBook library = new LinkedListBook();

        library.append(new Book("Clean Code", "Robert C. Martin", 2004));
        library.append(new Book("Clean Architecture", "Robert C. Martin", 2005));
        library.append(new Book("Baghavad Geeta", "Krishna", 1999));

        library.printList();
    }
}