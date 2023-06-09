package Homework;

public class Praktika3 {
    private Node head;
    //private Node tail;

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

    public void add(String str){
        Node node = new Node();
        node.value = str;
        if (head != null){
            node.next = head;
        }
        head = node;

    }

    class Node{
        public String value;
        public Node next;
        public Node previous;
    }

    public static void main(String[] args) {
        Praktika3 praktika3 = new Praktika3();
        praktika3.add("Java1");
        praktika3.add("Java2");
        praktika3.add("Java3");
        praktika3.add("Java4");

        System.out.println(praktika3.size());

        praktika3.remove();
        System.out.println(praktika3.size());
        System.out.println(praktika3.get(praktika3.size()-2));

    }
}
