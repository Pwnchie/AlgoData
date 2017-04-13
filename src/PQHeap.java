
//@author lasto11
//Lars Trier Storm
//lasto11@student.sdu.dk
//Project 1 for Algorithms and datastructures

import java.util.ArrayList;

public class PQHeap implements PQ {

    //Variables for internal use in the class.

   private Element minimum;
   private PQHeap myheap;
   private ArrayList<Element> myarray;

    //Ensures that the ArrayList has the desired size of maxElms.
    //Adds one to desired length to compensate for starting at
    //array index 1 instead of 0.
    public PQHeap(int maxElms) 
    {
        ArrayList<Element> newarray = new ArrayList<>();
        newarray.ensureCapacity(maxElms+1);

        myarray = newarray;
    }

    //Extracts from the heap the element with the lowest key
    //and trims the array to fit the new size of the array.
    public Element extractMin() {
        if (myheap.myarray.size() < 1) {
            System.out.println("Heap underflow");
        } else {
            minimum = myheap.myarray.get(1);
            myheap.myarray.remove(1);
            myheap.myarray.trimToSize();
        }
        return minimum;
    }

    //Inserts specified element into list and sorts it to correct position
    //Within the heap.
    public void insert(Element e) {
        Element newInsert = e;
        myheap.myarray.add(0, newInsert);
        minHeapify(myheap.myarray, 0);
    }

    //New method for maintaining a heapstructure via substitution
    private void maintainMinHeap()
    {
        int key;
        int i;
        Element temp;

         key = myheap.myarray.get(0).key;
         if(myheap.myarray.get(1) == null)
         {
             myheap.myarray.set(1,myheap.myarray.get(0));
         }
         else
             i = 1;
             while (i < myheap.myarray.size())
             {
                 if (myheap.myarray.get( < )
                 {

                 }
             }
    }
    //Enforces heapstructure by sorting contents of and arraylist.
    private void minHeapify(ArrayList<Element> a, int i) {
        a = myheap.myarray;
        //i = i + 1
        int smallest;
        int l = leftChildOf(i);
        int r = rightChildOf(i);
        Element parent = myheap.myarray.get(parentOf(i));
        Element leftchild = myheap.myarray.get(leftChildOf(i));
        Element rightchild = myheap.myarray.get(rightChildOf(i));

        if (i <= myheap.myarray.size() - 1 && parent.key >= leftchild.key) {
            smallest = l;
        } else {
            smallest = i;
        }

        if (i <= myheap.myarray.size() - 1 && parent.key >= rightchild.key) {
            smallest = r;
        }

        if (smallest != i) {
            Element temp = myheap.myarray.get(i);
            myheap.myarray.set(i, myheap.myarray.get(smallest));
            myheap.myarray.set(smallest, temp);
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
