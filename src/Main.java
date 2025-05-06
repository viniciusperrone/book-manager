import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        TreeBooks library = new TreeBooks();
        QueueBooks collectedBooks = new QueueBooks();
        StackNavigationSystem navigation = new StackNavigationSystem();
        GraphBook bookGraph = new GraphBook();

        library.insert(new Book("Dom Quixote de La Mancha", "Miguel de Cervantes", 1665, "Romance", 1033));
        library.insert(new Book("Metamorfose", "Franz Kafka", 1915, "Literatura", 96));
        library.insert(new Book("Ensaio Sobre a Cegueira", "José Saramago", 1995, "Romance", 312));
        library.insert(new Book("Crime e Castigo", "Fiódor Dostoiévsky", 1886, "Romance", 592));
        library.insert(new Book("Nineteen Eighty-Four", "George Orwell", 1949, "Ficção científica", 368));
        library.insert(new Book("Por Quem os Sinos Dobram", "Ernest Hemingway", 1940, "Romance", 672));
        library.insert(new Book("O Sol é Para Todos", "Harper Lee", 1960, "Romance", 349));
        library.insert(new Book("Os Miseráveis", "Victor Hugo", 1862, "Romance", 1511));
        library.insert(new Book("A História de uma Serva", "Margaret Atwood", 1895, "Romance", 352));
        library.insert(new Book("Romeu E Julieta", "William Shakespeare", 1597, "Romance", 256));

        for (Book book : library.listBooks()) {
            bookGraph.addBook(book);
        }

        bookGraph.connectBooks(library.getBookByTitle("Dom Quixote de La Mancha"), library.getBookByTitle("Ensaio Sobre a Cegueira"));
        bookGraph.connectBooks(library.getBookByTitle("Ensaio Sobre a Cegueira"), library.getBookByTitle("Crime e Castigo"));
        bookGraph.connectBooks(library.getBookByTitle("Crime e Castigo"), library.getBookByTitle("Metamorfose"));
        bookGraph.connectBooks(library.getBookByTitle("Nineteen Eighty-Four"), library.getBookByTitle("A História de uma Serva"));

        String continuosLoop = String.valueOf('S');

        while (continuosLoop.equals("S")) {
            UserInterface prompt = new UserInterface();
            ArrayList<Book> bookList = library.listBooks();

            prompt.chooseOption();

            switch (prompt.getOption()) {
                case 1: {
                    int i = 1;
                    for (Book book : bookList) {
                        System.out.println(i + ". " + book);
                        i++;
                     }

                    System.out.println("\n");

                    navigation.stackItem("Acessou a lista de livros.");

                    break;
                }

                case 2: {
                    int indexBook = prompt.chooseIndexBook("Informe o índex do livro para fazer o acervo:");

                    if (indexBook < 0 || indexBook > bookList.size()) {
                        System.out.println("Livro não encontrado.");

                        return;
                    }
                    Book book = bookList.get(indexBook - 1);

                    collectedBooks.enqueue(book);

                    navigation.stackItem("Adicionou o livro " + book.getTitle() + " ao acervo");

                    System.out.println("Livro adicionado ao acervo.");

                    collectedBooks.printQueueBooks();

                    break;
                }

                case 3: {
                    navigation.printStack();

                    break;
                }

                case 4: {
                    int i = 1;
                    for (Book book : bookList) {
                        System.out.println(i + ". " + book);
                        i++;
                    }

                    int indexBook = prompt.chooseIndexBook("Informe o índex do livro para fazer a recomendação:");

                    Book selectedBook = bookList.get(indexBook - 1);

                    if (selectedBook != null) {
                        bookGraph.printRecommendations(selectedBook);
                        navigation.stackItem("Acessou recomendações a partir de " + selectedBook.getTitle());
                    } else {
                        System.out.println("Livro inválido.");
                    }

                    break;
                }

                case 5: {
                    continuosLoop = "N";

                    break;
                }

                default: {
                    prompt.printInvalidOption();

                    break;
                }
            }

            if (prompt.getOption() != 4) {
                continuosLoop = prompt.askContinuousLoop();
            }

        }
    }
}