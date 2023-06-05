package Homework;

public class Praktika3_1 {

    private Node head;
    private Node tail;

    public String get(int item){
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

    public void remove(){
        if (head != null)
            head = head.next;
    }

    public void addFirst(String string){
        Node node = new Node();
        node.value = string;
        if (head != null){
            if (size() == 1) {
                tail = head;}
            node.next = head;
            head.previous = node;
        }
        head = node;

    }


    class Node {
        public String value;
        public Node next;
        public Node previous;
    }
    
    public static void main(String[] args) {
        
        Praktika3_1 pr = new Praktika3_1();
        pr.addFirst("Java1");
        pr.addFirst("Java2");
        pr.addFirst("Java3");
        pr.addFirst("Java4");
        for (int i = 0; i < pr.size(); i++) {
            System.out.println(pr.get(i));
        }
    }
}
