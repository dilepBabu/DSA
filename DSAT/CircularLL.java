class Node {
    int data;
    Node next;

}

class process {
    Node head;
    Node tail;

    public void insert(int data) {
        Node node = new Node();
        node.data = data;
        if (head == null) {
            head = node;
            tail = node;

        }
        tail.next = node;
        node.next = head;
        tail = node;
    }

    public void display() {
        Node temp = head;
        if (head != null) {
            do {
                System.out.print(temp.data + " ->");
                temp = temp.next;
            } while (temp != head);

            System.out.print("HEAD");
        }
    }

    public void delete(int data) {
        Node node = head;
        if (head == null) {
            return;
        }
        if (node.data == data) {
            head = head.next;
            tail.next = head;
        }
        do {
            Node n = node.next;
            if (n.data == data) {
                node.next = n.next;
                break;
            }
            node = node.next;

        } while (node != head);

    }
}

public class CircularLL {
    public static void main(String[] args) {
        process ps = new process();
        ps.insert(20);
        ps.insert(30);
        ps.insert(40);
        ps.display();
        ps.delete(20);
        ps.delete(40);
        ps.display();
    }

}
