package ru.itis.inform;


public class RBtree {

        private Node root;
        private Node r;

        public void insert(int element) {
            insertNode(null, this.root, element);
            insert_case1(r);
        }

        private Node insertNode(Node parent, Node root, int element) {
            if (root == null) {
                root = new Node(element);
                root.setLeft(null);
                root.setRight(null);
                root.setParent(parent);
                if (parent != null) {
                    if (root.getData() <= parent.getData()) {
                        parent.setLeft(root);
                    } else {
                        parent.setRight(root);
                    }
                }
                r = root;
            } else if (element <= root.getData()) {
                root.setLeft(insertNode(root, root.getLeft(), element));
            } else {
                root.setRight(insertNode(root, root.getRight(), element));
            }
            return root;
        }


        private void insert_case1(Node n) {
            if (n.getParent() == null) {
                n.setColor('b');
                this.root = n;
            } else {
                insert_case2(n);
            }
        }

        private void insert_case2(Node n) {
            if (n.getParent().getColor() == 'b') {
                return;
            } else {
                insert_case3(n);
            }
        }

        private void insert_case3(Node n) {
            Node u = uncle(n);
            Node g;
            if ((u != null) && (u.getColor() == 'r') && (n.getParent().getColor() == 'r')) {
                n.getParent().setColor('b');
                u.setColor('b');
                g = grandparent(n);
                g.setColor('r');
                insert_case1(g);
            } else {
                insert_case4(n);
            }
        }

        private void insert_case4(Node n) {
            Node g = grandparent(n);
            if ((n == n.getParent().getRight()) && (n.getParent() == g.getLeft())) {
                rotate_left(n.getParent());
                n = n.getLeft();
            } else if ((n == n.getParent().getLeft()) && (n.getParent() == g.getRight())) {
                rotate_right(n.getParent());
                n = n.getRight();
            }
            insert_case5(n);
        }

        private void insert_case5(Node n) {
            Node g = grandparent(n);
            n.getParent().setColor('b');
            g.setColor('r');
            if ((n == n.getParent().getLeft()) && (n.getParent() == g.getLeft())) {
                rotate_right(g);
            } else {
                rotate_left(g);
            }
        }


        private Node grandparent(Node n) {
            if ((n != null) && (n.getParent() != null)) {
                return n.getParent().getParent();
            } else {
                return null;
            }
        }

        private Node uncle(Node n) {
            Node g = grandparent(n);
            if (g == null) {
                return null;
            }
            if (n.getParent() == g.getLeft()) {
                return g.getRight();
            } else {
                return g.getLeft();
            }
        }

        private void rotate_left(Node n) {
            Node pivot = n.getRight();
            pivot.setParent(n.getParent());
            if (n.getParent() != null) {
                if (n.getParent().getLeft() == n) {
                    n.getParent().setLeft(pivot);
                } else {
                    n.getParent().setRight(pivot);
                }
            } else {
                this.root = pivot;
            }

            n.setRight(pivot.getLeft());
            if (pivot.getLeft() != null) {
                pivot.getLeft().setParent(n);
            }
            n.setParent(pivot);
            pivot.setLeft(n);
        }

        private void rotate_right(Node n) {
            Node pivot = n.getLeft();
            pivot.setParent(n.getParent());
            if (n.getParent() != null) {
                if (n.getParent().getLeft() == n) {
                    n.getParent().setLeft(pivot);
                } else {
                    n.getParent().setRight(pivot);
                }
            } else {
                this.root = pivot;
            }

            n.setLeft(pivot.getRight());
            if (pivot.getRight() != null) {
                pivot.getRight().setParent(n);
            }

            n.setParent(pivot);
            pivot.setRight(n);
        }


        public void show() {
            showRec(root, 0);
        }

        private void showRec(Node root, int level) {
            if (root != null) {
                showRec(root.getRight(), level + 1);

                for (int i = 0; i < level; i++) {
                    System.out.print("--");
                }

                System.out.println(root.getData());

                showRec(root.getLeft(), level + 1);
            }
        }

}

