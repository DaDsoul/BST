package lesson16_package.test;

import lesson16_package.adt.Set;
import lesson16_package.impl.Soldeir;
import lesson16_package.impl.TreeNode;
import lesson16_package.impl.BSTSet;

public class Main {

    public static int heightHelper(TreeNode<Integer> node){
        int sizeLeft = 1;
        int sizeRigth = 1;

        if (node == null){
            return 0;
        }

        sizeLeft = sizeLeft + heightHelper(node.getLeft());
        sizeRigth = sizeRigth + heightHelper(node.getRight());

        if (sizeLeft >= sizeRigth){
            return sizeLeft;
        }else {
            return sizeRigth;
        }

    }

    public static int height(TreeNode<Integer> node) {
        int elem = heightHelper(node);
       return elem - 1;
    }

    public static void main(String[] args) {

        BSTSet<Integer> tree = new BSTSet<>();

        tree.add(38);
        tree.add(23);
        tree.add(29);
        tree.add(34);
        tree.add(35);
        tree.add(36);
        tree.add(37);
        tree.add(11);
        tree.add(13);
        tree.add(70);
        tree.add(66);
        tree.add(100);
        tree.add(110);



        System.out.println(height(tree.root));
//
//        //Some lecture examples
//        TreeNode<Integer> someNode = new TreeNode(23);
//
//        someNode.setRight(new TreeNode(25));
//        someNode.setLeft(new TreeNode(12));
//
//        someNode.getLeft().setLeft(null);
//        someNode.getLeft().setRight(new TreeNode(15));
//
//        printTree(someNode);
//
//       // Test cases for lesson 16
//        Set<Integer> randomBinaryTree = new BSTSet();
//
//        randomBinaryTree.add(12);
//        randomBinaryTree.add(21);
//        randomBinaryTree.add(112);
//        randomBinaryTree.add(212);
//        randomBinaryTree.add(12);
//
//        System.out.println(randomBinaryTree.toString());
//        System.out.println(randomBinaryTree.getSize());
//
//        randomBinaryTree.add(14);
//        randomBinaryTree.add(-6);
//        randomBinaryTree.add(5);
//
//        System.out.println();
//        System.out.println(randomBinaryTree.toString());
//        System.out.println(randomBinaryTree.getSize());
//
//        System.out.println(randomBinaryTree.contains(12));
//        System.out.println(randomBinaryTree.contains(7));
//        System.out.println(randomBinaryTree.contains(2));
//        System.out.println(randomBinaryTree.contains(-8));
//        System.out.println(randomBinaryTree.contains(5));
//
//        System.out.println();
//        System.out.println(randomBinaryTree.toString());
//        System.out.println(randomBinaryTree.getSize());
//
//        randomBinaryTree.clear();
//        System.out.println(randomBinaryTree.getSize());
//        System.out.println(randomBinaryTree.toString());
//
//        randomBinaryTree.add(55);
//        randomBinaryTree.add(24);
//        randomBinaryTree.add(78);
//        randomBinaryTree.add(51);
//
//        System.out.println(randomBinaryTree.toString());
//        System.out.println(randomBinaryTree.getSize());
//
//        Set<Soldeir> soldeirSet = new BSTSet();
//
//        Soldeir adam = new Soldeir("Adam", 12);
//        Soldeir adam1 = new Soldeir("Badam", 13);
//        Soldeir adam2 = new Soldeir("Cadam", 10);
//        Soldeir adam3 = new Soldeir("Jadam", 10);
//
//        soldeirSet.add(adam);
//        soldeirSet.add(adam1);
//        soldeirSet.add(adam2);
//
//        System.out.println(soldeirSet);
//
//        System.out.println(soldeirSet.contains(adam));
//        soldeirSet.add(adam1);
//
//        System.out.println(soldeirSet);
//        System.out.println(soldeirSet.getSize());
//
//        System.out.println(soldeirSet.contains(adam3));


    }

    public static void printTree(TreeNode<Integer> node){
        //Pre-order trivarsal example
        if (node == null){
            return;
        }

        System.out.println(node.getValue() + " ");
                    printTree(node.getLeft());
                    printTree(node.getRight());
    }
}
