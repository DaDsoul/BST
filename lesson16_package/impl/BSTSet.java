package lesson16_package.impl;


import lesson16_package.adt.Set;

/**
 * Created by talgat on 08.03.18.
 */
public class BSTSet<T extends Comparable> implements Set<T>{

    public TreeNode<T> root;
    private int size;

    public BSTSet() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public void add(T value) {
        if (size == 0){
            root = new TreeNode(value);
            size++;
        } else {
            addHelper(root, value);
        }
    }

    public void addHelper(TreeNode<T> node, T value){

        if (node.getValue().compareTo(value) < 0){
            if (node.getRight() == null){
                node.setRight(new TreeNode<>(value));
                size++;
            } else {
                addHelper(node.getRight(), value);
            }
        } else if (node.getValue().compareTo(value) > 0){
            if (node.getLeft() == null){
                node.setLeft(new TreeNode<>(value));
                size++;
            } else {
                addHelper(node.getLeft(), value);
            }
        }
    }

    @Override
    public boolean contains(T value) {

        return containsHelper(root, value);
    }

    @Override
    public boolean remove(T value) {

        return removeHelper(root, root, false, value);

    }

    private boolean removeHelper(TreeNode<T> node, TreeNode<T> preNode, boolean isRight,T value){

        if (node == null){
            return false;
        }

        if (value.equals(node.getValue())){
            if (node.getLeft() == null && node.getRight() == null){
                if (size == 1){
                    root = null;
                } else {
                    if (isRight){
                        preNode.setRight(null);
                    } else {
                        preNode.setLeft(null);
                    }
                }
            } else if (node.getLeft() == null && node.getRight() != null){
                if (node == root){
                    root = node.getRight();
                } else {
                    if(isRight){
                        preNode.setRight(node.getRight());
                    } else {
                        preNode.setLeft(node.getRight());
                    }
                }

            } else if (node.getLeft() != null && node.getRight() == null){
                if (node == root){
                    root = node.getLeft();
                } else {
                    if(isRight){
                        preNode.setRight(node.getLeft());
                    } else {
                        preNode.setLeft(node.getLeft());
                    }
                }
            } else {

                TreeNode<T> minimumLeaf = minimumLeafFinder(node.getLeft(), node);

                if (node == root){
                    node.setValue(minimumLeaf.getValue());
                }else {
                    if(isRight){
                        preNode.setRight(minimumLeaf);
                    } else {
                        preNode.setLeft(minimumLeaf);
                    }
                }
            }

            size --;

            return  true;
        } else {

            return removeHelper(node.getRight(), node, true, value) || removeHelper(node.getLeft(), node, false, value);
        }
    }

    private TreeNode<T> minimumLeafFinder(TreeNode<T> node, TreeNode<T> prevNode){

        if (node.getLeft() == null){
            if (node == root){
                root = node.getRight();
            }
            prevNode.setLeft(null);
            return node;
        }

        return minimumLeafFinder(node.getLeft(), node);
    }

    @Override
    public T removeAny() throws Exception {
        TreeNode<T> deletedNode = new TreeNode(null);
        if(size == 0){
            throw new Exception("The Set is Empty Bro!");
        } else {
            deletedNode = minimumLeafFinder(root,root);
        }

        return deletedNode.getValue();
    }



    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void clear() {
        this.root = null;
        size = 0;
    }

    private boolean containsHelper(TreeNode<T> node, T value){
        if (node == null){
            return false;
        }

        return value.equals(node.getValue()) || containsHelper(node.getRight(), value) || containsHelper(node.getLeft(), value);
    }

    public String toString(){
        return toStringHelper(root);
    }

    private String toStringHelper(TreeNode<T> node){
        if (node == null){
            return " ";
        }

        return toStringHelper(node.getLeft()) +
                node.getValue() +
                toStringHelper(node.getRight());
    }
}
