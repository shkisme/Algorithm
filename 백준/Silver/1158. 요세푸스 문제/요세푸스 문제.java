import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(java.lang.System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(java.lang.System.out));

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class MyLinkedList {
        Node head;
        Node curr;

        public MyLinkedList() {
            this.curr = null;
            this.head = null;
        }

        public void add(int data) {
            if (curr == null) { // 처음일때
                curr = new Node(data);
                head = curr;
            } else {
                while (curr.next != null) {
                    curr = curr.next;
                }
                Node newNode = new Node(data);
                curr.next = newNode;
                curr = newNode;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        String[] strings = br.readLine().split(" ");
        int n = Integer.parseInt(strings[0]);
        int k = Integer.parseInt(strings[1]);
        if (k == 1) {
            bw.write("<");
            for (int i = 1; i < n; i++) {
                bw.write(i + ", ");
            }
            bw.write(n + ">");
            bw.flush();
            return;
        }

        MyLinkedList list = new MyLinkedList();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        list.curr.next = list.head;

        Node tmp = list.head;
        int cnt = 2;

        bw.write("<");
        while (tmp.data != tmp.next.data) {
            if (cnt == k) {
                bw.write(tmp.next.data + ", ");
                tmp.next = tmp.next.next;
                cnt = 1;
            } else {
                tmp = tmp.next;
                cnt++;
            }
        }
        bw.write(tmp.data + ">");
        bw.flush();
    }
}
