import java.util.Arrays;

/**
 * Created by lasto11
 */


public class DictBinTree implements Dict
{
    private int treesize;
    private Node root;
    private int key;
    private Node[] orderedarray;
    private int activeindex;
    private int checked;

    DictBinTree()
    {
        treesize = 0;
        Node root = null;
        activeindex = 0;
    }

    @Override
    public void insert(int i)
    {
        key = i;
        //Creates a new node object with key value i.
       Node newnode = new Node(key);
       //Assigns root as the active node.
       Node activenode = root;
       //While the active node is not null, compare newnode key value, with activenode keyvalue
        // and move active node accordingly.
       while (activenode != null)
       if (newnode.key < activenode.key)
       {
           activenode = activenode.leftchild;
       }
       else
       {
           activenode = activenode.rightchild;
       }

       //if activenode reaches a nullvalue it will assume its place and terminate.
       if(activenode == null)
       {
           activenode = newnode;

           //increments the size of the tree
           treesize = treesize + 1;
           return;
       }


    }

    @Override
    public int[] orderedTraversal() {
        Node activenode = root;
        orderedarray = new Node[treesize];
        int checked = 0;
        int[] strippedarray;
        int i;

        //Controls whether or not all the nodes have been checked
        while (checked < treesize)
            //Checks whether the current node is null or checked
            while (activenode.checked = false && activenode != null)
                //Checks  if  the children of the activenode are null or checked and
                //moves around them down the tree if possible, if not, it checks off the
                //the active node.
                if (activenode.leftchild == null || activenode.leftchild.checked == true) {
                    if (activenode.rightchild == null || activenode.rightchild.checked == true) {
                        activenode.checkOffNode(activenode);
                        orderedarray[activeindex] = activenode;
                        activenode.checkOffNode(activenode);
                        checked++;
                        activeindex++;
                        activenode = root;
                    } else
                        activenode = activenode.rightchild;
                } else
                    activenode = activenode.leftchild;

        //Bubblesorts array by keyvalue
        bubbleSort(orderedarray);

        //Det fremgår af opgaven at ordered traversal skal returnere en kopi af træets elementer.
        //i sorteret orden, dette er inkompatibelt med int return value.
        //Grundet fremgangsmåde i TestProjectPartII antager eleven at det ønskede er et
        //array af integers bestående af int keyvalues og retter derfor til int format.

        //initializes an array to hold the stripped off integer key values.
        strippedarray = new int[treesize];

        //creates the array of integers required by TestProjectPartII
        for(i = 0; i < treesize; i++)
        {
            strippedarray[i] = orderedarray[i].key;
        }

        return strippedarray;
    }

    private void bubbleSort(Node[] x)
    {
        boolean swapped = true;
        int j = 0;
        Node tmp;
        while (swapped)
        {
            swapped = false;
            j++;
            for (int i = 0; i < treesize - j; i++)
            {
                if ( orderedarray[i].key > orderedarray[i+1].key )
                {
                    tmp = orderedarray[i];
                    orderedarray[i] = orderedarray[i+1];
                    orderedarray[i+1] = tmp;
                    swapped = true;
                }
            }
        }
    }

    @Override
    public boolean search(int k)
    {
        //Starts the search at the root of the tree
        Node activenode = root;
        // Runs the commands until it reaches a branch that is null, which terminate the search.
        //With a false boolean
        while (activenode!=null)
        {
         //if the active node matches the search parameter, the search terminatesand
            // returns a true boolean.
            if(activenode.key==k)
            {
                return true;
            }
            //If the search parameter is smaller than the active node, it moves active node to
            //to left child.
            else if(activenode.key>k)
            {
                activenode = activenode.leftchild;
            }
            // Otherwise it moves active node to the right child.
            else
            {
                activenode = activenode.rightchild;
            }

        }
        //If it terminates on a null value, the search parameter could not be found in the tree.
        return false;
    }

}
