import java.util.Hashtable;

public class LRUCache {

    Hashtable<Integer,Node> cache ;
    int capacity;
    int count;
    Node head;
    Node tail;
    LRUCache(int capacity){
        this.cache = new Hashtable<>();
        this.capacity= capacity;
        this.count=0;
         this.head = new Node();
         tail = new Node();
        head.next=tail;
        tail.prev=head;
    }

    private void addNode(Node node){
        node.next=head.next;
        head.next.prev=node;
        node.prev=head;
        head.next=node;


    }

    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next=next;
        next.prev=prev;
    }

    private Node evictNode(){
        Node node = tail.prev;
        removeNode(node);
        return node;
    }

    public void put(int key, int value){
        if(cache.containsKey(key)){
            //if found in cache;
            Node node = cache.get(key);
            node.value=value;
            removeNode(node);
            addNode(node);
            return ;
        }
        Node newNode = new Node(key,value);
        cache.put(key,newNode);
        addNode(newNode);
        count++;
        if(count>capacity){
            //evict the node
            Node removeNode = evictNode();
            cache.remove(removeNode.key);
            count--;
        }

    }

    public int get(int key){
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            removeNode(node);
            addNode(node);
            return cache.get(key).value;

        }
        return -1;

    }


    public class Node{
        int key ;
        int value ;
        Node next;
        Node prev;
        Node(){

        }
        Node(int key , int value){
            this.key=key;
            this.value=value;
        }
    }


    public static void main(String[] args) {

        LRUCache lruCache = new LRUCache(2);
        System.out.println();
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        System.out.println(lruCache.get(2));
         lruCache.put(4,4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));

    }
}
