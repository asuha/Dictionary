import java.util.ArrayList;

public class Node {

    private Node rigth;
    private Node left;
    private Node father;
    private String key;
    private ArrayList<String> values;
    private int balance;

    public Node(String key, String value){
        this.values = new ArrayList<String>();

        addValue(value);
        setBalance(0);
        setFather(null);
        setKey(key);
        setLeft(null);
        setRigth(null);
    }

    public void addValue(String value){
        this.values.add(value);
    }

    public int getBalance(){
        return this.balance;
    }

    public Node getFather(){
        return this.father;
    }

    public String getKey(){
        return this.key;
    }

    public Node getLeft(){
        return this.left;
    }

    public Node getRigth(){
        return this.rigth;
    }

    public void setBalance(int balance){
        this.balance = balance;
    }

    public void setFather(Node father){
        this.father = father;
    }

    public void setKey(String key){
        this.key = key;
    }

    public void setLeft(Node left){
        this.left = left;
    }

    public void setRigth(Node rigth){
        this.rigth = rigth;
    }
}
