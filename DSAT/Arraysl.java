import java.util.Scanner;

class dyanamicarray {
    private int arr[];
    private int size;
    private int capacity;

    dyanamicarray() {
        size = 0;
        arr = new int[16];
        capacity = 16;
    }

    public void add(int val) {
        if (capacity == size)
            expandarray();
        arr[size++] = val;

    }

    private void expandarray() {
        capacity *= 2;
        arr = java.util.Arrays.copyOf(arr, capacity);

    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public void instatpos(int pos, int val) {
        if (size == capacity) {
            expandarray();
        }
        for (int i = size - 1; i >= pos; i--) {
            arr[i + 1] = arr[i];
        }
        arr[pos] = val;
        size++;

    }

    public void deleatpos(int pos) {
        for (int i = pos + 1; i < size; i++) {
            arr[i - 1] = arr[i];

        }
        size--;
        if (capacity > 16 && capacity > 3 * size)
            strink();

    }

    private void strink()

    {
        capacity /= 2;
        arr = java.util.Arrays.copyOf(arr, capacity);
    }

}

public class Arraysl {
    public static void main(String[] ars) {
        int val, pos;
        dyanamicarray list = new dyanamicarray();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("--------list---------");
            System.out.println("1.insert element in array at end\n");
            System.out.println("2.Display the list\n");
            System.out.println("3.insert data at specific position\n");
            System.out.println("4.Delete data at specific position\n");
            System.out.println("5.exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("enter the data");
                    val = sc.nextInt();
                    list.add(val);
                    break;
                case 2:
                    list.display();
                    break;
                case 3:
                    System.out.println("enter the position ");
                    pos = sc.nextInt();
                    if (pos < 0)
                        break;
                    System.out.println("enter the data");
                    val = sc.nextInt();
                    list.instatpos(pos, val);
                    break;
                case 4:
                    System.out.println("enter the position ");
                    pos = sc.nextInt();
                    if (pos < 0)
                        break;
                    list.deleatpos(pos);
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("invalid choice");

            }
        }
    }

}
