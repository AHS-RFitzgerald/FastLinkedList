
import java.util.*;

@SuppressWarnings("unchecked")
public class FastLinkedList<AnyType extends Comparable> {
    //each node has between one and eight next references

    public static final int MAX_LEVEL = 7;

    //reference to a header node
    //the value stored in the header node is never accessed.
    private Node<AnyType> head;

    //the current highest level of all nodes in the list
    private int maxListLevel;

    /**
     * Builds an empty list with a header node
     */
    public FastLinkedList() {
        maxListLevel = 0;
        head = new Node<AnyType>(MAX_LEVEL, null);
    }

    /**
     * Each element in the list is stored in a node. The level of the node is
     * chosen randomly when the node is created.
     */
    private static class Node<AnyType> {

        public AnyType data;
        public Node<AnyType>[] next;

        public Node(int randLevel, AnyType data) {
            next = new Node[randLevel + 1];
            this.data = data;
        }
    }

    /**
     * Returns a current max level of all nodes in the list
     */
    public int getMaxLevel() {
        return maxListLevel;
    }

    /**
     * Returns a random level between 0 and MAX_LEVEL
     */
    public int randomLevel() {
        int rand = (int) (Math.log(1 - Math.random()) / Math.log(0.5));
        return Math.min(rand, MAX_LEVEL);
    }

    /**
     * Returns the length of this list The method traverses the level 0
     * references
     */
    public int length() {
        int len = 0;
        Node<AnyType> tmp = head.next[len];
        while(tmp.next != null){
            len += 1;
            tmp = head.next[len];
        }
        
        return len;
    }

    /**
     * Returns the string contents of the list The method traverses the level 0
     * references
     */
    public String toString() {
        
        String str = "";
        int len = 0;
        Node<AnyType> tmp = head.next[len];

        while(len < head.next.length){
            str += tmp;
            len ++;
            tmp = head.next[len];
        }
        
        return str;
    }

    /**
     * Returns the string contents of the list at a given level
     */
    public String toString(int level) {
        
        String str = "";
        Node<AnyType> tmp = (Node<AnyType>) head.data;
        
        
        while(level < head.next.length){
            str += tmp;
            level ++;
            tmp = head.next[level];
        }
        
        return str;
    }

    /**
     * Returns true if a given value is stored in the list, otherwise false. The
     * search begins at the topmost reference of the header
     */
    public boolean contains(AnyType toSearch) {
        
        boolean contains = false;
        Node<AnyType> tmp = (Node<AnyType>) head.data;
        int len = 0;
        
        while(len < this.length() || contains == true){
            
            if(tmp == toSearch){
                contains = true;
            }else{
                len ++;
                tmp = head.next[len];
            }
            
        }
        
        return contains;
    }

    /**
     * Returns true if a given value is stored in the list at a specified level.
     */
    public boolean contains(AnyType toSearch, int level) {
        
        if(toSearch == head.next[level]){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Inserts a given value into the list at random level In order to insert a
     * new node into the list we must maintain an array of nodes whose next
     * references must be updated.
     */
    public void insert(AnyType toInsert) {
        int randLevel = randomLevel();
        insertHelper(toInsert, randLevel);
    }
                    
    /**
     * Inserts a given value into the list at a given level The level must not
     * exceed MAX_LEVEL.
     */
    public void insert(AnyType toInsert, int level) {
        if (level >= 0 && level <= MAX_LEVEL) {
            insertHelper(toInsert, level);
        }
    }

    private void insertHelper(AnyType toInsert, int level) {
        Node<AnyType> tmp = head;
        Node<AnyType>[] nodesToUpdate = new Node[MAX_LEVEL + 1];

        //Find and store nodes for updates
        //you code goes here
        
        nodesToUpdate = tmp.next;
        
        //If the new node level is greater than any node already in the list
        //then the head node must be updated
        //Insert a new node
        
        tmp = new Node<AnyType>(level, toInsert);
        
        //you code goes here
        int len = 0;
        
        while(len < level){
            head.next[len] = nodesToUpdate[len];
            len ++;
        }
        
        head.next[level] = tmp;
        len += 2;
        
        while(len < nodesToUpdate.length){
            head.next[len] = nodesToUpdate[len - 1];
            len ++;
        }
        
        
    }

    /**
     * Deletes a node that contains the given value. In order to delete a node
     * we must maintain an array of nodes whose next references must be updated.
     */
    public void delete(AnyType toDelete) {
        Node<AnyType> tmp = head;
        Node<AnyType>[] nodesToUpdate = new Node[MAX_LEVEL + 1];
        
        //Find and store nodes for updates
        //you code goes here
        
        nodesToUpdate = tmp.next;
        
        //Remove a node from the list
        //you code goes here
        
        int count = 0;
        
        while(tmp.next[count] != toDelete){
            count ++;
        }
        
        while(count < tmp.next.length){
            head.next[count] = head.next[count + 1];
        }
        
        //After deleting the node we must check if maxListLevel must be lowered.
        //you code goes here
        
        if(maxListLevel > head.next.length - 1){
            maxListLevel -= 1;
        }
        
    }
}
