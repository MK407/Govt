package com.doublylinkedlist;

import java.util.Scanner;

//Class for Doubly Linked List
public class DLL {
 Node head; // head of list

 /* Doubly Linked list Node*/
 class Node {
     int data;
     Node prev;
     Node next;

     // Constructor to create a new node
     // next and prev is by default initialized as null
     Node(int d) { data = d; }
 }

 // Adding a node at the front of the list
 public void push(int new_data)
 {
     /* 1. allocate node
     * 2. put in the data */
     Node new_Node = new Node(new_data);

     /* 3. Make next of new node as head and previous as NULL */
     new_Node.next = head;
     new_Node.prev = null;

     /* 4. change prev of head node to new node */
     if (head != null)
         head.prev = new_Node;

     /* 5. move the head to point to the new node */
     head = new_Node;
 }

 /* Given a node as prev_node, insert
 a new node after the given node */
 public void InsertAfter(Node prev_Node, int new_data)
 {

     /*1. check if the given prev_node is NULL */
     if (prev_Node == null) {
         System.out.println("The given previous node cannot be NULL ");
         return;
     }

     /* 2. allocate node
     * 3. put in the data */
     Node new_node = new Node(new_data);

     /* 4. Make next of new node as next of prev_node */
     new_node.next = prev_Node.next;

     /* 5. Make the next of prev_node as new_node */
     prev_Node.next = new_node;

     /* 6. Make prev_node as previous of new_node */
     new_node.prev = prev_Node;

     /* 7. Change previous of new_node's next node */
     if (new_node.next != null)
         new_node.next.prev = new_node;
 }

 // Add a node at the end of the list
 void append(int new_data)
 {
     /* 1. allocate node
     * 2. put in the data */
     Node new_node = new Node(new_data);

     Node last = head; /* used in step 5*/

     /* 3. This new node is going to be the last node, so
     * make next of it as NULL*/
     new_node.next = null;

     /* 4. If the Linked List is empty, then make the new
     * node as head */
     if (head == null) {
         new_node.prev = null;
         head = new_node;
         return;
     }

     /* 5. Else traverse till the last node */
     while (last.next != null)
         last = last.next;

     /* 6. Change the next of last node */
     last.next = new_node;

     /* 7. Make last node as previous of new node */
     new_node.prev = last;
 }
 
 void deleteNode(Node del)
 {

     // Base case
     if (head == null || del == null) {
         return;
     }

     // If node to be deleted is head node
     if (head == del) {
         head = del.next;
     }

     // Change next only if node to be deleted
     // is NOT the last node
     if (del.next != null) {
         del.next.prev = del.prev;
     }

     // Change prev only if node to be deleted
     // is NOT the first node
     if (del.prev != null) {
         del.prev.next = del.next;
     }

     // Finally, free the memory occupied by del
     return;
 }
 public void deleteNodeValue(int value) {
	 int loc = search(head,value);
	 System.out.println(loc);
	 Node del = head;
	 for(int i=0;i<loc-1;i++) {
		 del = del.next;
	 } 
	 if(del==null) {
		 System.out.println("Can't delete data");
	 }
	 deleteNode(del);
 }
 static int search(Node head_ref, int x)
 {
    
   // Stores head Node
   Node temp = head_ref;
    
   // Stores position of the integer
   // in the doubly linked list
   int pos = 0;
    
   // Traverse the doubly linked list
   while (temp.data != x
              && temp.next != null)
   {
     // Update pos
     pos++;
      
     // Update temp
     temp = temp.next;
   }
    
   // If the integer not present
   // in the doubly linked list
   if (temp.data != x)
     return -1;
   // If the integer present in
   // the doubly linked list
   return (pos + 1);
 }


 // This function prints contents of
 // linked list starting from the given node
 public void printlist(Node node)
 {
     Node last = null;
     System.out.println("Traversal in forward Direction");
     while (node != null) {
         System.out.print(node.data + " ");
         last = node;
         node = node.next;
     }
     System.out.println();
     System.out.println("Traversal in reverse direction");
     while (last != null) {
         System.out.print(last.data + " ");
         last = last.prev;
     }
 }

 public void printlistinForward(Node node)
 {
     Node last = null;
     System.out.println("\nTraversal in forward Direction");
     while (node != null) {
         System.out.print(node.data + " ");
         last = node;
         node = node.next;
     }
     while (last != null) {
         last = last.prev;
     }
 }
 public void printlistinReverse(Node node)
 {
     Node last = null;
     while (node != null) {
         last = node;
         node = node.next;
     }
     System.out.println("\nTraversal in reverse direction");
     while (last != null) {
         System.out.print(last.data + " ");
         last = last.prev;
     }
     
 }
 
 /* Driver program to test above functions*/
 public static void main(String[] args)
 {
     /* Start with the empty list */
     DLL dll = new DLL();
     
     Scanner input = new Scanner(System.in); 
     
     int choice =0;
     int value;
     while(choice != 6)   
     {  
         System.out.println("\n\n*********Main Menu*********\n");  
         System.out.println("\nChoose one option from the following list ...\n");  
         System.out.println("\n===============================================\n");  
         System.out.println("\n1.Insert in begining\n2.Insert at last\n3.Delete the key\n4.Search for an element\n5.Show\n6.Exit\n");  
         System.out.println("\nEnter your choice?\n");         
         choice = input.nextInt(); 
         if(choice==1) {
        	 System.out.println("Enter the value to insert in the beginning");
        	 value = input.nextInt();
        	 dll.push(value);
        	 System.out.println("Data is inserted");
         }
         else if(choice==2) {
        	 System.out.println("Enter the value to insert in the end");
        	 value = input.nextInt();
        	 dll.append(value);
        	 System.out.println("Data is inserted");
         }
//         else if(choice==3) {
//        	 System.out.println("Enter the value to insert");
//        	 value = input.nextInt();
//        	 System.out.println("Enter the random location:: start from 0");
//        	 int loc = input.nextInt();
//        	 
//        	 boolean yes = llist.insertAtRandom(loc, value);
//        	 if(yes) {
//        		 System.out.println("Data is inserted");
//        	 }
//        	 
//         }
         else if(choice==3) {
        	 System.out.println("Enter the value to delete");
        	 value = input.nextInt();
        	 dll.deleteNodeValue(value);
        	 System.out.println("Data is deleted");
         }
         else if(choice==4) {
        	 System.out.println("Enter the value to search");
        	 value = input.nextInt();
        	 if (search(dll.head, value)!=0)
               System.out.println("Yes data is available");
           else
               System.out.println("No data is not available");
         }
         else if(choice==5) {
        	 System.out.println("Which direction do you want to print the data?");
        	 System.out.println("1.Forward \n2.Tranversal\n3. Both");
        	 int dir = input.nextInt();
        	 if(dir==1) {
        		 dll.printlistinForward(dll.head);
        	 }else if(dir==2) {
        		 dll.printlistinReverse(dll.head);
        	 }else if(dir==3) {
        		 dll.printlist(dll.head);
        	 }else {
        		 System.out.println("Please enter the right choice!");
        	 }
         }
         else if(choice==6) {
        	 System.exit(0);
         }
         else {
        	 System.out.println("Please enter valid choice.."); 
         }
     }
 }
}

