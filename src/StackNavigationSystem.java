import java.util.LinkedList;

public class StackNavigationSystem {
    private LinkedList<String> collection;

    public StackNavigationSystem() {
        this.collection = new LinkedList<String>();
    }

    public void stackItem(String item) {
        this.collection.addLast(item);
    }

    public String unstackItem() {
        return this.collection.removeLast();
    }

    public void printStack() {
        for (int i = 0; i < this.collection.size(); i++) {
            String item = this.collection.get(i);

            System.out.println(i + 1 + ". " + item);
        }
    }

}
