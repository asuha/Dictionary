import java.util.ArrayList;
//Árvore AVL
public class AVLTree {

    //Nó raiz
    private Node root;

    //Insere nó com palavra chave e traduções e retorna o nó inserido
    public Node insert(String key, ArrayList<String> value){
        Node insert = new Node(key, value);
        //Faz a chamada do método recursivo e privado de inserção
        insert(getRoot(), insert);

        return insert;
    }

    //Busca nó pela palavra chave e retorna lista com valores da árvore se os mesmos existirem
    //Caso a palavra não exista na árvore uma lista vazia será retornada
    public ArrayList<String> searchNode(String key){
        //Faz a chamada do método recursivo de busca
        return searchNode(getRoot(), key);
    }

    //Busca recursivamente pelo nó na árvore
    private ArrayList<String> searchNode(Node initialNode, String key){
        //Se o valor não for encontrado ou a chave passada for nula é retornado uma lista vazia
        if ( initialNode == null || key == null )
            return new ArrayList<String>();
        //Verifica se o nó atual é o nó buscado
        if (initialNode.getKey().equals(key))
            return initialNode.getValues();
        //Verifica se a chave do nó buscado é menor que a do nó atual
        else if ( initialNode.getKey().compareToIgnoreCase( key ) > 0 )
            //Chamada recursiva para verifica se o nó da esquerda é o nó buscado
            return searchNode( initialNode.getLeft(), key );

        //Chamada recursiva para verificar se o nó da direita é o nó buscado
        return searchNode( initialNode.getRight(), key );

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

        if (actual.getBalance() == -2){

            if (actual.getRight().getBalance() < 0)
                leftRotation(actual);

            else
                doubleRotationLeft(actual);

        } else if (actual.getBalance() == 2){

            if (actual.getLeft().getBalance() > 0)
                rightRotation(actual);

            else
                doubleRotationRight(actual);

        }

        if ( actual.getFather() != null )
            checkBalance(actual.getFather());

        else
            setRoot(actual);

    }


    private void insert(Node actual, Node insert){

        if (actual == null){
             setRoot(insert);

        } else {

            if ( insert.getKey().compareTo(actual.getKey()) < 0 ) {

                if ( actual.getLeft() == null){
                    actual.setLeft(insert);
                    insert.setFather(actual);
                    checkBalance(actual);
                } else
                    insert(actual.getLeft(), insert);

            } else if (insert.getKey().compareTo(actual.getKey()) > 0) {

                if ( actual.getRight() == null){
                    actual.setRight(insert);
                    insert.setFather(actual);
                    checkBalance(insert);
                } else
                    insert(actual.getRight(), insert);

            }

        }

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

        Node rightNode = actual.getRight();
        rightNode.setFather(actual.getFather());

        actual.setRight(rightNode.getLeft());

        if (actual.getRight() != null)
            actual.getRight().setFather(actual);

        rightNode.setLeft(actual);
        actual.setFather(rightNode);

        if (rightNode.getFather() != null){

            if (rightNode.getFather().getRight() == actual)
                rightNode.getFather().setRight(rightNode);

            else if ( rightNode.getFather().getLeft() == actual)
                rightNode.getFather().setLeft(rightNode);

        }

        setBalance(actual);
        setBalance(rightNode);

        return rightNode;
    }


    private Node doubleRotationRight(Node node){
        node.setLeft(leftRotation(node.getLeft()));
        return rightRotation(node);
    }


    private Node doubleRotationLeft(Node node){
        node.setRight(leftRotation(node.getRight()));
        return leftRotation(node);
    }


    private void setBalance(Node node){
        node.setBalance(height(node.getLeft()) - height(node.getRight()));
     }


    public Node getRoot(){
        return this.root;
    }


    protected void setRoot(Node root){
        this.root = root;
    }
}
