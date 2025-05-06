import java.util.*;

public class GraphBook {
    private HashMap<Book, Set<Book>> graph = new HashMap<Book, Set<Book>>();

    public void addBook(Book book) {
        graph.putIfAbsent(book, new HashSet<>());
    }

    public void connectBooks(Book b1, Book b2) {
        graph.putIfAbsent(b1, new HashSet<>());
        graph.putIfAbsent(b2, new HashSet<>());

        graph.get(b1).add(b2);
        graph.get(b2).add(b1);
    }

    public Map<Book, Integer> dijkstra(Book origin) {
        Map<Book, Integer> distances = new HashMap<>();
        Queue<Book> queue = new LinkedList<>();

        distances.put(origin, 0);
        queue.add(origin);

        while (!queue.isEmpty()) {
            Book current = queue.poll();
            int currentDistance = distances.get(current);

            for (Book neighbor : graph.getOrDefault(current, new HashSet<>())) {
                if (!distances.containsKey(neighbor)) {
                    distances.put(neighbor, currentDistance + 1);
                    queue.add(neighbor);
                }
            }
        }

        return distances;
    }

    public void printRecommendations(Book book) {
        Map<Book, Integer> recommendations = dijkstra(book);

        System.out.println("\nRecomendações de livros com base em \"" + book.getTitle() + "\":");
        recommendations.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .filter(entry -> !entry.getKey().equals(book))
                .forEach(entry -> System.out.println("- " + entry.getKey() + " (Distância: " + entry.getValue() + ")"));
    }

    public Set<Book> getAllBooks() {
        return graph.keySet();
    }
}
