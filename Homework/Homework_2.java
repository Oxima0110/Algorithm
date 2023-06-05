package Homework;

public class Homework_2 {

    Node head;
    Node tail;

    public Integer get(int item){
        if (item > size()){throw new ArrayIndexOutOfBoundsException();}// 1 08
        Node tmp = head;
        while (item >0){
            tmp = tmp.next;
            item--;
        }
        return tmp.value;
    }

    public int size(){
        int size = 1;
        if (head == null) return 0;
        Node tmp = head;
        while (tmp.next != null){
            tmp = tmp.next;
            size++;
        }
        return size;
    }

    public void addFirst(int value){
        Node node = new Node();
        node.value = value;
        if (head != null){
            if (size() == 1) {
                tail = head;}
            node.next = head;
            head.previous = node;
        }
        head = node;

    }

    public void revert() {
        Node currentNode = head;
        while (currentNode != null) {
            Node next = currentNode.next;
            Node previous = currentNode.previous;
            currentNode.next = previous;
            currentNode.previous = next;
            if (previous == null) {
                tail = currentNode;
            }
            if (next == null) {
                head = currentNode;
            }
            currentNode = next;
        }
    }
    
    public class Node {
        int value;
        Node next;
        Node previous;
    }

    public static void main(String[] args) {
        
        Homework_2 ls = new Homework_2();
        ls.addFirst(8);
        ls.addFirst(12);
        ls.addFirst(-1);
        ls.addFirst(25);
        System.out.println("Список:");
        for (int i = 0; i < ls.size(); i++) {
            System.out.print(ls.get(i) + " ");
        }
        ls.revert();
        System.out.println();
        System.out.println("Разворот списка:");
        for (int i = 0; i < ls.size(); i++) {
            System.out.print(ls.get(i) + " ");
        }
    }
    
}
