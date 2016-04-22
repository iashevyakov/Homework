package ru.itis.inform;


public class RBtree {

    private Node root;

    public void rotateLeft(Node x)
    {
        Node y = x.getRight();
        x.setRight(y.getLeft());
        if (y.getLeft() != null)
        y.getLeft().setParent(x); /* Setup parent of b */
        y.setParent(x.getParent());
        if (x.getKey() == x.getParent().getLeft().getKey()) /* x is left subtree */
        x.getParent().setLeft(y);
        else
        x.getParent().setRight(y);
        y.setLeft(x);
        x.setParent(y);

    }
    public void rotateRight(Node x)
    {
        Node y = x.getLeft();
        x.setLeft( y.getRight()); /* Subtree c */
        if (y.getRight() != null)
        y.getRight().setParent(x); /* Setup parent of c */
        y.setParent( x.getParent());
        if (x.getKey() == x.getParent().getLeft().getKey())  /* x is left subtree */
        x.getParent().setLeft(y);
        else
        x.getParent().setRight(y);
        y.setRight(x);
        x.setParent(y);
    }

    public void insert_case1(Node n)
    {
        if (n.getParent() == null) {
            n.setColor(false);

        }
        else
            insert_case2(n);
    }

   public void insert_case2(Node n)
    {
        if (n.getParent().getColor() == false)
            return; /* Tree is still valid */
        else
            insert_case3(n);
    }

    public void insert_case3(Node n)
    {
        Node u = uncle(n), g;

        if ((u != null) && (u.getColor() == true) && (n.getParent().getColor() == true)) {
            n.getParent().setColor(false);
            u.setColor(false);
            g = grandparent(n);
            g.setColor(true);
            insert_case1(g);
        } else {
            insert_case4(n);
        }
    }

    public void  insert_case4( Node n)
    {
        Node g = grandparent(n);

        if ((n.getKey() == n.getParent().getRight().getKey()) && (n.getParent().getKey() == g.getLeft().getKey())) {
        rotateLeft(n .getParent());

		/*
		 * rotate_left может быть выполнен следующим образом, учитывая что уже есть *g =  grandparent(n)
		 *
		 * struct node *saved_p=g->left, *saved_left_n=n->left;
		 * g->left=n;
		 * n->left=saved_p;
		 * saved_p->right=saved_left_n;
		 *
		 */

        n =new  Node(n.getLeft().getKey(),n.getLeft().getValue());
    } else if ((n.getKey() == n.getParent().getLeft().getKey()) && (n.getParent() == g.getRight())) {
        rotateRight(n.getParent());

		/*
		 * rotate_right может быть выполнен следующим образом, учитывая что уже есть *g =  grandparent(n)
		 *
		 * struct node *saved_p=g->right, *saved_right_n=n->right;
		 * g->right=n;
		 * n->right=saved_p;
		 * saved_p->left=saved_right_n;
		 *
		 */

        n = new  Node(n.getRight().getKey(),n.getRight().getValue());
    }
        insert_case5(n);
    }

    public void insert_case5(Node n)
    {
        Node g = grandparent(n);

        n.getParent().setColor(false);
        g.setColor(true);
        if ((n.getKey() == n.getParent().getLeft().getKey()) && (n.getParent().getKey() == g.getLeft().getKey())) {
        rotateRight(g);
    } else { /* (n == n->parent->right) && (n->parent == g->right) */
        rotateLeft(g);
    }
    }

   public Node  grandparent(Node n)
    {
        if ((n != null) && (n.getParent() != null))
            return n.getParent().getParent();
        else
            return null;
    }


   public Node uncle (Node n)
    {
        Node g = grandparent(n);
        if (g == null)
            return null; // No grandparent means no uncle
        if (n.getParent().getKey() == g.getLeft().getKey())
            return g.getRight();
        else
            return g.getLeft();
    }
    private Node insertNode(Node root, int element, String value)
    {
        if (root == null) {
            root = new Node(element,value);


        } else if (element <= root.getKey()) {
            root.setLeft(insertNode(root.getLeft(), element,value));
        } else {
            root.setRight(insertNode(root.getRight(), element, value));
        }

        return root;
    }

    public void insert(int element, String value) {
        insertNode(this.root, element, value);
        Node n = new Node (element,value);
        insert_case1(n);
    }
    private void showRec(Node root, int level) {
        if (root != null) {
            showRec(root.getRight(), level + 1);

            for (int i = 0; i < level; i++) {
                System.out.print("   ");
            }

            System.out.println(root.getKey());

            showRec(root.getLeft(), level + 1);
        }
    }

    public void show() {
        showRec(root, 0);
    }



}
