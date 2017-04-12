
//@author lasto11
//Lars Trier Storm
//lasto11@student.sdu.dk
//Project 1 for Algorithms and datastructures

import java.util.ArrayList;

public class PQHeap implements PQ {

    //Variables for internal use in the class.
   private ArrayList<Element> myheap = new ArrayList<>();
   private Element minimum;

    //Ensures that the ArrayList has the desired size of maxElms.
    //Adds one to desired length to compensate for starting at
    //array index 1 instead of 0.
    public PQHeap(int maxElms) 
    {
        myheap.ensureCapacity(maxElms+1);
    }
    //Extracts from the heap the element with the lowest key
    //and trims the array to fit the new size of the array.
    public Element extractMin() {
        if (myheap.size() < 1) {
            System.out.println("Heap underflow");
        } else {
            minimum = myheap.get(0);
            myheap.remove(0);
            myheap.trimToSize();
        }
        return minimum;
    }

    //Inserts specified element into list and sorts it to correct position
    //Within the heap.
    public void insert(Element e) {
        Element newInsert = e;
        myheap.add(1, newInsert);
        minHeapify(myheap, 1);
    }
    
    //Enforces heapstructure by sorting contents of and arraylist.
    private void minHeapify(ArrayList<Element> a, int i) {
        a = myheap;
        //i = i + 1
        int smallest;
        int l = leftChildOf(i);
        int r = rightChildOf(i);
        Element parent = myheap.get(parentOf(i));
        Element leftchild = myheap.get(leftChildOf(i));
        Element rightchild = myheap.get(rightChildOf(i));

        if (i <= myheap.size() - 1 && parent.key >= leftchild.key) {
            smallest = l;
        } else {
            smallest = i;
        }

        if (i <= myheap.size() - 1 && parent.key >= rightchild.key) {
            smallest = r;
        }

        if (smallest != i) {
            Element temp = myheap.get(i);
            myheap.set(i, myheap.get(smallest));
            myheap.set(smallest, temp);
            minHeapify(myheap, smallest);
        }

    }
    
    //Returns the index of the parent of i
    private int parentOf(int i) {
        int parent = i / 2;
        return parent;
    }

    //Returns the index of the left child of i
    private int leftChildOf(int i) {
        int leftchild = 2 * i;
        return leftchild;
    }

    //Returns the index of the right child of i
    private int rightChildOf(int i) {
        int rightchild = 2 * i + 1;
        return rightchild;
    }
}
