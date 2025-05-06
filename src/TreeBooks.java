import java.util.ArrayList;

class Node {
    Book book;
    Node left;
    Node right;

    public Node(Book book) {
        this.book = book;
        this.left = null;
        this.right = null;
    }
}

public class TreeBooks {
    Node root;

    public TreeBooks() {
        this.root = null;
    }

    // Adicionar
    public void insert(Book book) {
        this.root = insertRecursive(this.root, book);
    }

    private Node insertRecursive(Node current, Book book) {
        if(current == null) {
            return new Node(book);
        }

        if (current.book.getYearPublication() < book.getYearPublication()) {
            current.left = insertRecursive(current.left, book);
        } else if (current.book.getYearPublication() > book.getYearPublication()) {
            current.right = insertRecursive(current.right, book);
        }

        return current;
    }

    public ArrayList<Book> listBooks() {
        ArrayList<Book> books = new ArrayList<>();
        inorderTraversal(this.root, books);
        return books;
    }

    private void inorderTraversal(Node node, ArrayList<Book> books) {
        if (node != null) {
            inorderTraversal(node.left, books);
            books.add(node.book);
            inorderTraversal(node.right, books);
        }
    }
}
