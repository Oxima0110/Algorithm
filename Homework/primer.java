package Homework;

public class primer {
    public static void main(String[] args) {
        //Node node = new Node();
        // System.out.println(node.hashCode()%16);
        primer primer = new primer();
        for (int i = 0; i < 40; i++) {
            primer.put( i +1, i);
        }

        System.out.println(primer.size());

        // for (Node item : primer.massiv) {
        // System.out.println(item);
        // }
    }

    Node head;
    Node[] massiv = new Node[16];


    // int size() количество элементов
    public Integer size(){
        int len_massiv = massiv.length;
        int result = 0;
        for (int index = 0; index < len_massiv; index++) {
            if (massiv[index] != null) {
                Node tempNode = massiv[index];
            while (tempNode != null) {
                result = result + 1;
                tempNode = tempNode.next;
                }
            }
        }
            return result;
        }
        
    
        //Object remove(Integer key) удалить элемент с соответствующем ключём
    public Object remove(Integer key) {
        int index = key.hashCode()%16;
        if (massiv[index] != null) {
            Node tempNode = massiv[index];
            if (tempNode.key == key && tempNode.next == null) {
                massiv[index] = null;
                return tempNode.value;
            }
            if (tempNode.key == key && tempNode.next != null) {
                massiv[index] = tempNode.next;
                return tempNode.value;
            }
            while (tempNode.next != null){
                if (tempNode.next.key == key){
                    Integer tmp = tempNode.next.value;
                    tempNode.next = tempNode.next.next;
                    return tmp;
                }
                tempNode = tempNode.next;
            }
        }
        return null;
    }

    public Object replays(Integer key, Integer v) {
        int index = key.hashCode()%16;
        if (massiv[index] != null) {
            Node tempNode = massiv[index];
            while (tempNode != null) {
                if (tempNode.key == key) {
                    Integer x = tempNode.value;
                    tempNode.value = v;
                    return x;
                }
                tempNode = tempNode.next;
            }
        }
        return null;
    }

    public Object get(Integer key) {
        int index = key.hashCode()%16;
        if (massiv[index] != null) {
            Node tempNode = massiv[index];
            while (tempNode != null) {
                if (tempNode.key == key) {
                    return tempNode.value;
                }
                tempNode = tempNode.next;
            }
        }
        return null;
    }

    public Object put(int v, int k) {
        Node temp = new Node();
        temp.value = v;
        temp.key = k;
        temp.hash = temp.key.hashCode() % 16;
        if (massiv[temp.hash] != null) {
            Node tempNode = massiv[temp.hash];
            while (tempNode != null) {
                if (tempNode.key == k) {
                    //System.out.println("False");
                    return tempNode.value;
                }
                tempNode = tempNode.next;
            }
            temp.next = massiv[temp.hash];
        }
        massiv[temp.hash] = temp;
        //System.out.println("True");
        return null;
    }
}

class Node {
    Integer value, key;
    int hash;
    Node next;
}