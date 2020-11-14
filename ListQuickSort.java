
public class ListQuickSort {
	
	public int partition (int array[], int Left, int Right) {
		
		int pivot = array[Right];
		int index = Left;
		int i;
		for(i = Left; i <= Right - 1; i++) {
			
			if(array[i] <= pivot) {
				swap(array[index],array[i]);
				index++;
				
			}
		}
		swap(array[index], array[Right]);
		return (index);
		
	}

	private void swap(int i, int j) {// just for ride off the swap error 
		// TODO Auto-generated method stub
		
	}

	private void quickSort(int A[],int Left, int Right) {
		
		if(Left >= Right) {
			//return;
			
		int p = partition(A, Left, Right); 
		quickSort(A, Left, p -1);
		quickSort(A, p + 1, Right);
			
		}
	}
	
	public static class QuickSort_Doubly_LinkedList{// using quickSort to sort the linked list.
		Node head;
		
		private class Node {
			private int data;
			private Node next;
			private Node prev;
			
			Node(int d){
				data = d;
				next = null;
				prev = null;
				
			}
		}
		
		private Node lastNode(Node node) {// find the last node of the linked list
			while(node.next!=null){
				node = node.next;
			}
			return node;

		}
		
		private Node partition(Node L, Node H) {
			
			int pivot = H.data;// set pivot as H element 
			
			Node index = L.prev;// similar to i = L-1 for array implementation
			
			for(Node i = L; i != H; i=i.next) {// it a similar for loop(int i = L; i <= h-1; j++)
				
				if(i.data <= pivot) {
					
					//index++;
					
					// it is similar to index ++ for the array
					index = (index== null)? L : index.next;
					int temp = index.data;
					index.data = i.data;
					i.data = temp;
				}
			}
			index = (index==null) ? L : index.next;// it it is similar to index++
			int temp = index.data;
			index.data = H.data;
			H.data = temp;
			return index;
			
		}
		 public void QuickSort1(Node L,Node H) {// a recursive implementation of QuickSort for the linkedList
			 
			if(H!=null && L!=H && L!=H.next){
				Node temp = partition(L,H);
				QuickSort1(L,temp.prev);
				QuickSort1(temp.next,H);
				 
		    } 
		}
		 
		 public void quickSort(Node node) {// the main function to sort a linked list.
			                              // it mainly calls QuickSort
			 Node head = lastNode(node); // find the last node
			 
			 QuickSort1(node,head); // call the recursive QuickSort
		 }
		 
		 
		 public void printList(Node head) { // a function to print contents of array
			 while(head!=null) {
				 System.out.print(head.data+" ");
				 head = head.next;
			 }
		 }
		 
		 public void push(int newData) { // if head is null, head = newNode
			 Node newNode = new Node(newData);
			 
			 if(head==null) {
				 head = newNode;
				 return;
			 }
			 newNode.next = head; // it link the old list off the new node
			 
			 head.prev = newNode; // change prey node to newNode
			 
			 newNode.prev = null; // so we are adding at the beginning so prev 
			                      // is always null.
			 head = newNode;  // move head to point to the new node
		 }
		 
		 public static void main(String[] args){ 
			 QuickSort_Doubly_LinkedList list = new QuickSort_Doubly_LinkedList();   
	           
	         list.push(55); 
	         list.push(26); 
	         list.push(37); 
	         list.push(19); 
	         list.push(38);
	            
	         System.out.println("List before sorting "); 
	         list.printList(list.head); 
	         System.out.println("\nList after sorting"); 
	         list.quickSort(list.head); 
	         list.printList(list.head); 
	          
	    } 
		 
		 
	}
	
	

}
