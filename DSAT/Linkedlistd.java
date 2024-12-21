
class Node {
    int data;
    Node next;
}

class likndelist {
    Node head;

    public void insert(int val) {
        Node node = new Node();
        node.data = val;
        if (head == null) {
            head = node;
        } else {
            Node n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;

        }
    }

    public void display() {
        Node node = head;
        System.out.print("\n");
        while (node.next != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        // print at the last node data
        System.out.print(node.data);
    }

    // insert at the start position
    public void atstart(int val) {
        Node node = new Node();
        node.data = val;
        node.next = null;
        node.next = head;
        head = node;

    }

    // insert at between
    public void atbwt(int pos, int val) {

        Node node = new Node();
        node.data = val;
        node.next = null;

        Node n = head;
        if (pos == 0) {
            atstart(val);
        } else {
            for (int i = 0; i < pos - 1; i++) {
                n = n.next;
            }
            node.next = n.next;
            n.next = node;
        }

    }

    public void deleteat(int pos) {
        Node n = head;
        Node n1 = null;

        if (pos == 0) {
            head = head.next;
        } else {
            for (int i = 0; i < pos - 1; i++) {
                n = n.next;
            }
            n1 = n.next;
            n.next = n1.next;
            n1 = null;

        }
    }
}

public class Linkedlistd {

    public static void main(String[] args) {
        likndelist ls = new likndelist();
        ls.insert(12);
        ls.insert(15);
        ls.insert(45);
        ls.atstart(9);
        ls.atbwt(2, 13);
        ls.display();
        ls.deleteat(2);
        ls.display();

    }

}
