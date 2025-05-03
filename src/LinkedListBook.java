public class LinkedListBook {
    Node head;

    public void append(Book data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data.getTitle() + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void remove(Book data) {
        if (head == null) return;

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }

        // Nó não encontrado
        if (current.next == null) return;

        // Remove o nó
        current.next = current.next.next;
    }

}
