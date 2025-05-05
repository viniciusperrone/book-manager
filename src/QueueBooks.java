import java.util.LinkedList;

public class QueueBooks {
    private LinkedList<Book> collection = new LinkedList<Book>();

    public void enqueue(Book book) {
        this.collection.addLast(book);
    }

    public Book dequeue() {
        return this.collection.removeFirst();
    }

    public void printQueueBooks() {
        for (int i = 0; i < this.collection.size(); i++) {
            Book targetBook = this.collection.get(i);

            System.out.println(i + 1 + ". " + targetBook.getTitle());
        }
    }

    public boolean isEmpty () {
        return this.collection.isEmpty();
    }
}
