//Name: Yaser Azfar
//ID: 1350368

//class for floating point linked list with methods to add, remove, check has, print and insert in order
class WordList{
    
    private int count; //counter to know how many nodes have been added/removed
    Node head; //head of list

    public class Node{
        private String value;
        private Node next;

        //constructor
        Node(String v){ 
            value = v; //the value of the node
            next = null; //the node after the current
        }
    }

    //add(String x) - adds to the head of the list a new node with the value of the argument x; then returns void. 
    public void add(String x){
        Node curr = new Node(x);
        //if the list isn't empty make the new node's next = to the current head and then make the head = to the new node
        if (isEmpty() == false){
            curr.next = head;
            head = curr;
        }
        else{ //if the list is empty just make the new node = the head
            head = curr;
        }
        count++; 
        return;
    }

    //has(String x) - returns a boolean value that is true if the linked list contains a node whose value is x; false otherwise. 
    public boolean has(String x){
        if (isEmpty() == true){ //if the list has no nodes then false
            return false;
        }
        Node curr = head; //so that the loop starts with the head
        //goes through the whole list and keeps going to next node, if the next node is = to the String x then return true
        for (int i = 0; i < count; i++){
            if (curr.value.equals(x)){
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    //Returns the index that the string is on, can only be used if has(x) = true
    public int hasIndex(String x){
        Node curr = head; //so that the loop starts with the head
        //goes through the whole list and keeps going to next node, if the next node is = to the String x then return true
        for (int i = 0; i < count; i++){
            if (curr.value.equals(x)){
                return i;
            }
            curr = curr.next;
        }
        return 0;
    }

    public String indexWord(int x){

        Node curr = head;
        for (int i = 0; i < count; i++){
            if (i == x){
                return curr.value;
            }
            curr = curr.next;
        }
        return "Cannot find this word";

    }


    //remove(String x) - finds the first node whose value is x and removes the node by changing the .next of the previous node 
    public void remove(String x){
        //first checks if the list actually contains String x
        if (has(x) == false){
            System.out.println("The list does not contain " + x);
            return;
        } 

        if(head.value.equals(x)){ //checking if the head is x and if it is then makes the head = to the second in list - removing the head
            head = head.next;
            count--;
            return;
        }

        Node curr = head; //so that loop starts at head
        while(curr.next != null){ //go through the whole list
            if(!curr.next.value.equals(x)){ //if it isn't x go to next
                curr = curr.next;
            }
            else{ //set the value to the next String, removing the x
                count--;
                curr.next = curr.next.next;
            }
        }
    }

    //length() - returns (as an int) a count of the number of values in the linked list. 
    public int length(){
        return count;
    }

    //isEmpty() - returns boolean true if length() would return 0; false otherwise. 
    public boolean isEmpty(){
        if (length() == 0){
            return true;
        }
        return false;
    }

    //dump() - print each node to the screen
    public void dump(){
        Node curr = head;
        for (int i = 0; i < count; i++){ //goes through whole list and prints out each value then goes to next
            System.out.println(curr.value);
            curr = curr.next;
        }
    }



    // //insert(String x) - Adds the String x to the linked list but in order from smallest to biggest
    // public void insert(String x){
    //     Node curr = head; //the first String in the list (smallest)
    //     Node newFloat = new Node(x); //the String to add
    //     if(isEmpty() == true || head.value >= x){ //if list is empty or if the head is bigger than new String then make new String = head
    //         newFloat.next = head;
    //         head = newFloat;
    //         count++;
    //     }
    //     else{
    //         curr = head;
    //         while(curr.next != null && curr.next.value < newFloat.value){ //go through whole list and add the new String where it is smaller than the next value
    //             curr = curr.next;
    //         }
    //         newFloat.next = curr.next;
    //         curr.next = newFloat;
    //         count++;
    //     }
    // }
}
