package ru.itis.inform;

public class BinarySearchTreeImpl  {

    private  Node root;

    private Node insertNode(Node root, int element, int level)
    {
        if (root == null) {
            root = new Node(element,level);


        } else if (element <= root.getData()) {
            root.setLeft(insertNode(root.getLeft(), element,level));
        } else {
            root.setRight(insertNode(root.getRight(), element, level));
        }

        return root;
    }
    public boolean checkTree() {
        return checkVertex(this.root);
    }



    private boolean checkVertex(Node node) {
        if (node == null)
            return true;
        Node lnode = node.getLeft();
        Node rnode = node.getRight();
        if (lnode == null && rnode == null)
        {return true;}

        boolean leftCheck = true;

        boolean rightCheck = true;

        if (lnode != null && node.getData() < lnode.getData())
            leftCheck = false;
        if (rnode != null && node.getData() > rnode.getData()) {
            rightCheck = false;
        }

        if (leftCheck && rightCheck) {
            {return checkVertex(lnode) && checkVertex(rnode);}
        }
        else
        { return false;}
    }

    public void setRoot(int elem) {
        root.setData(elem);
    }

    private void showRec(Node root, int level) {
        if (root != null) {
            showRec(root.getRight(), level + 1);

            for (int i = 0; i < level; i++) {
                System.out.print("   ");
            }

            System.out.println(root.getData());

            showRec(root.getLeft(), level + 1);
        }
    }

    public void insert(int element, int level) {
        this.root = insertNode(this.root, element, level);
    }

    public void show() {
        showRec(root, 0);
    }

    private void inOrder(Node root)
    {
        if (root != null) {
            inOrder(root.getLeft());
            System.out.print(root.getData() + " ");
            inOrder(root.getRight());
        }
    }

    public void inOrderPrint() {
        inOrder(this.root);
    }
    public int [] sum = new int [100];
    public void initializeSumArray()
    {
        for (int i=0; i<100; i++)
        {
            sum[i]=0;
        }
    }
    public int max=0;
    public void travelsarWide()
    {
        initializeSumArray();
        Queue q = new Queue();
        q.add(root);
        while (!q.isEmpty())
        {
            Node x=q.extract();
            if (x.getLevel()>max)
            {max=x.getLevel();}
            sum[x.getLevel()]+=+x.getData();
            if (x.getLeft()!=null)
            {q.add(x.getLeft());}
            if (x.getRight()!=null)
            {q.add(x.getRight());}

        }

    }
    public boolean CheckLevelSum()
    {
        boolean b=true;
        for (int i=0; i<max;i++)
        {
            if (sum[i]>sum[i+1])
            {b&=false;}
        }
        return b;

    }

}