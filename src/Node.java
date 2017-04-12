/**
 * Created by lasto11
 */
public class Node
{
    Node leftchild;
    Node rightchild;
    int key;
    boolean checked;

    public Node(int i)
    {
        key = i;
        leftchild = null;
        rightchild = null;
        checked = false;
    }

    public void checkOffNode(Node i)
    {
        i.checked = true;
    }

    public void resetNode(Node i)
    {
        i.checked = false;
    }
}
