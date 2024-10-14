import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Node {
    char data;
    Node next;
    Node prev;

    public Node(final char data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class MyLinkedList {
    Node head; // 초기 위치
    Node curr; // 현재 위치

    public MyLinkedList() {
        this.head = null;
        this.curr = null;
    }

    public void add(char data) {
        if (curr == null) {
            curr = new Node(data);
            head = curr;
        } else {
            Node newNode = new Node(data);
            curr.next = newNode;
            newNode.prev = curr;
            newNode.next = null;
            curr = newNode;
        }
    }

    public void left() {
        if (curr.prev == null) {
            return;
        }
        if (curr.prev.prev == null) {
            Node prev = curr.prev;
            Node next = curr.next;
            next.prev = prev;

            prev.prev = curr;
            prev.next = curr.next;

            curr.prev = null;
            curr.next = prev;

            head = curr;
            return;
        }
        if (curr.next == null) {
            Node prev = curr.prev;
            Node twoPrev = prev.prev;
            twoPrev.next = curr;

            prev.prev = curr;
            prev.next = null;

            curr.prev = twoPrev;
            curr.next = prev;
            return;
        }
        Node prev = curr.prev;
        Node twoPrev = prev.prev;
        Node next = curr.next;
        next.prev = prev;

        twoPrev.next = curr;

        prev.prev = curr;
        prev.next = curr.next;

        curr.prev = twoPrev;
        curr.next = prev;
    }

    public void right() {
        if (curr.next == null) {
            return;
        }
        if (curr.next.next == null) {
            Node prev = curr.prev;
            Node next = curr.next;

            prev.next = next;

            next.prev = prev;
            next.next = curr;

            curr.prev = next;
            curr.next = null;
            return;
        }
        if (curr.prev == null) {
            Node next = curr.next;
            Node twoNext = next.next;

            next.prev = null;
            next.next = curr;
            head = next;

            twoNext.prev = curr;

            curr.prev = next;
            curr.next = twoNext;
            return;
        }
        Node prev = curr.prev;
        Node next = curr.next;
        Node twoNext = next.next;

        prev.next = next;

        next.prev = prev;
        next.next = curr;

        twoNext.prev = curr;

        curr.prev = next;
        curr.next = twoNext;
    }

    public void removeLeft() {
        if (curr.prev == null) {
            return;
        }
        if (curr.prev.prev == null) {
            curr.prev = null;
            head = curr;
            return;
        }
        Node twoPrev = curr.prev.prev;
        twoPrev.next = curr;
        curr.prev = twoPrev;
    }

    public void addLeft(char data) {
        if (curr.prev == null) {
            Node newNode = new Node(data);
            newNode.prev = null;
            newNode.next = curr;
            curr.prev = newNode;
            head = newNode;
            return;
        }
        Node newNode = new Node(data);
        Node prev = curr.prev;

        prev.next = newNode;
        newNode.prev = prev;
        newNode.next = curr;
        curr.prev = newNode;
    }
}

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(java.lang.System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(java.lang.System.out));

    public static void main(String[] args) throws Exception {
        String string = br.readLine();

        MyLinkedList linkedList = new MyLinkedList();

        for (int i = 0; i < string.length(); i++) {
            linkedList.add(string.charAt(i));
        }
        linkedList.add('*');

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] strings = br.readLine().split(" ");

            String order = strings[0];
            if (order.equals("L")) {
                linkedList.left();
            } else if (order.equals("D")) {
                linkedList.right();
            } else if (order.equals("B")) {
                linkedList.removeLeft();
            } else if (order.equals("P")) {
                String character = strings[1];
                linkedList.addLeft(character.charAt(0));
            }
        }
        Node tmp = linkedList.head;
        while (tmp.next != null) {
            if (tmp.data != '*') {
                bw.write(tmp.data + "");
            }
            tmp = tmp.next;
        }
        if (tmp.data != '*') {
            bw.write(tmp.data + "");
        }
        bw.flush();
    }
}
