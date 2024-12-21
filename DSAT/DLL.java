
class DNode {
    int data;
    DNode next;
    DNode prev;
}

class Dlinked {
    DNode head;

    public void insert(int data) {
        DNode node = new DNode();
        node.data = data;
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        head = node;
    }

    public void display() {
        DNode node = head;// temp pointer it cant modify the head if we change in default head

        while (node != null) {
            System.out.print(node.data + " ->");

            node = node.next;
        }
        System.out.print("end\n");
    }

    public void revdisplay() {
        DNode node = head;
        while (node.next != null) {
            node = node.next;
        }

        while (node != null) {
            System.out.print(node.data + " ->");
            node = node.prev;

        }
        System.out.print("end\n");

    }

    public void startpos(int data) {
        DNode node = head;
        DNode newnode = new DNode();
        newnode.data = data;
        newnode.next = head;
        newnode.prev = null;
        if (head != null) {
            head.prev = newnode; // Link old head back to new node
        }

        head = newnode;

    }

    public void atbwt(int pos, int data) {
        DNode bwt = new DNode();
        bwt.data = data;

        DNode temp = head;
        if (pos == 0) {
            startpos(data);
        } else {
            for (int i = 0; i < pos - 1; i++) {
                temp = temp.next;

            }
            bwt.next = temp.next;
            bwt.prev = temp;
            if (temp.next != null) {
                temp.next.prev = bwt;
            }
            temp.next = bwt;

        }
    }

    public void delete(int pos) {
        // Case 1: If the list is empty
        if (head == null) {
            System.out.println("The list is empty.");

        }

        DNode temp = head;

        // Case 2: Deleting the head node (pos == 0)
        if (pos == 0) {
            head = head.next; // Move the head to the next node
            if (head != null) {
                head.prev = null; // Set the prev pointer of the new head to null
            }

        }

        // Case 3: Traverse to the node before the one to be deleted
        for (int i = 0; i < pos - 1; i++) {
            temp = temp.next; // Move to the node just before the one to delete
        }

        // If the position is out of bounds (i.e., the node does not exist)
        if (temp.next == null) {
            System.out.println("Position out of bounds.");

        }

        // Node to be deleted is temp.next
        DNode nodeToDelete = temp.next;

        // Case 4: Unlink the node from the list
        temp.next = nodeToDelete.next; // Link the previous node to the next node
        if (nodeToDelete.next != null) {
            nodeToDelete.next.prev = temp; // Link the next node's prev pointer to the previous node
        }

        // Set the node to null (in Java, this is handled by garbage collection)
        nodeToDelete = null;
    }

    public class DLL {
        public static void main(String args[]) {
            Dlinked d = new Dlinked();
            d.insert(20);
            d.insert(30);
            d.insert(40);
            d.display();
            d.revdisplay();
            d.startpos(10);
            d.display();
            d.atbwt(2, 25);
            d.display();
            d.atbwt(0, 9);
            d.display();
            d.delete(2);
            d.display();

        }

    }
}
