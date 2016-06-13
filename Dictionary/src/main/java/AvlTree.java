public class AVLTree {

    private Node root;


    public Node getRoot(){
        return this.root;
    }


    public boolean insert(String key, String value){
        Node insert = new Node(key, value);
        return insert(getRoot(), insert);
    }


    public void setRoot(Node root){
        this.root = root;
    }


    private int height(Node actual) {
        if (actual == null) {
            return -1;
        }

        if (actual.getLeft() == null && actual.getRight() == null)
            return 0;

        if (actual.getLeft() != null)
            return 1 + height(actual.getLeft());

        if (actual.getRight() != null)
            return 1 + height(actual.getRight());

        return 1 + Math.max(height(actual.getLeft()), height(actual.getRight()));
    }


    private void checkBalance(Node actual){
        setBalance(actual);
        int balance = actual.getBalance();

        if (balance == -2){

            if ( height(actual.getLeft().getLeft()) >= height(actual.getRight().getRight()) )
                actual = rightRotation(actual);

            else
                actual = doubleRotationLeftRigth(actual);

        } else if (balance == 2){

            if ( height(actual.getRight().getRight()) >= height(actual.getRight().getLeft()) )
                actual = leftRotation(actual);

            else
                actual = doubleRotationRigthLeft(actual);

        }

        if ( actual.getFather() != null )
            checkBalance(actual.getFather());

        else
            setRoot(actual);

    }


    private boolean insert(Node actual, Node insert){

        if (actual == null){
            actual = insert;
            return true;

        } else {

            if ( insert.getKey().compareTo(actual.getKey()) < 0 ) {

                if ( actual.getLeft() == null){
                    actual.setLeft(insert);
                    insert.setFather(actual);
                    checkBalance(actual);
                } else
                    insert(actual.getLeft(), insert);

            } else if (actual.getKey().compareTo(insert.getKey()) > 0) {

                if ( actual.getRight() == null){
                    actual.setRight(insert);
                    insert.setFather(actual);
                    checkBalance(insert);
                } else
                    insert(actual.getRight(), insert);

            }

        }

        return false;

    }


    private Node rightRotation(Node actual){

        Node leftNode = actual.getLeft();
        leftNode.setFather(actual.getFather());

        actual.setLeft(leftNode.getRight());

        if (actual.getLeft() != null)
            actual.getLeft().setFather(actual);

        leftNode.setRight(actual);
        actual.setFather(leftNode);

        if (leftNode.getFather() != null){

            if (leftNode.getFather().getRight() == actual)
                leftNode.getFather().setLeft(leftNode);

            else if ( leftNode.getFather().getLeft() == actual)
                leftNode.getFather().setLeft(leftNode);

        }

        setBalance(actual);
        setBalance(leftNode);

        return leftNode;
    }


    private Node leftRotation(Node actual){

        Node rigthNode = actual.getRight();
        rigthNode.setFather(actual.getFather());

        actual.setRight(rigthNode.getLeft());

        if (actual.getRight() != null)
            actual.getRight().setFather(actual);

        rigthNode.setLeft(actual);
        actual.setFather(rigthNode);

        if (rigthNode.getFather() != null){

            if (rigthNode.getFather().getRight() == actual)
                rigthNode.getFather().setRight(rigthNode);

            else if ( rigthNode.getFather().getLeft() == actual)
                rigthNode.getFather().setLeft(rigthNode);

        }

        setBalance(actual);
        setBalance(rigthNode);

        return rigthNode;
    }


    private Node doubleRotationLeftRigth(Node node){
        node.setLeft(leftRotation(node.getLeft()));
        return rightRotation(node);
    }


    private Node doubleRotationRigthLeft(Node node){
        node.setRight(leftRotation(node.getRight()));
        return leftRotation(node);
    }


    private void setBalance(Node node){
        node.setBalance(height(node.getLeft()) - height(node.getRight()));
    }
}
