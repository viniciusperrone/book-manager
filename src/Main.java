import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Book> library = new LinkedList<Book>();
        QueueBooks collectedBooks = new QueueBooks();

        library.add(new Book("Dom Quixote de La Mancha", "Miguel de Cervantes", 1665));
        library.add(new Book("Metamorfose", "Franz Kafka", 1915));
        library.add(new Book("Ensaio Sobre a Cegueira", "José Saramago", 1995));
        library.add(new Book("Crime e Castigo", "Fiódor Dostoiévsky", 1886));
        library.add(new Book("Nineteen Eighty-Four", "George Orwell", 1949));
        library.add(new Book("Por Quem os Sinos Dobram", "Ernest Hemingway", 1940));
        library.add(new Book("O Sol é Para Todos", "Harper Lee", 1960));
        library.add(new Book("Os Miseráveis", "Victor Hugo", 1862));
        library.add(new Book("A História de uma Serva", "Margaret Atwood", 1895));
        library.add(new Book("Romeu E Julieta", "William Shakespeare", 1597));

        String continuosLoop = String.valueOf('S');

        while (continuosLoop.equals("S")) {
            UserInterface prompt = new UserInterface();

            prompt.chooseOption();

            switch (prompt.getOption()) {
                case 1: {
                    int i = 1;
                    for (Book book : library) {
                        System.out.println(i + ". " + book);
                        i++;
                     }

                    System.out.println("\n");

                    break;
                }

                case 2: {
                    int indexBook = prompt.chooseIndexBook();

                    if (indexBook < 0 || indexBook > library.size()) {
                        System.out.println("Livro não encontrado.");

                        return;
                    }
                    Book book = library.get(indexBook - 1);

                    collectedBooks.enqueue(book);

                    System.out.println("Livro adicionado ao acervo.");

                    collectedBooks.printQueueBooks();

                    break;
                }

                case 3: {

                    break;
                }
                case 4: {
                    continuosLoop = "N";

                    break;
                }

                default: {
                    prompt.printInvalidOption();

                    break;
                }
            }

            if (prompt.getOption() != 4) {
                continuosLoop = prompt.askContinuosLoop();
            }

        }
    }
}