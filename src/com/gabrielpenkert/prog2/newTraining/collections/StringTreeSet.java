package com.gabrielpenkert.prog2.newTraining.collections;

public class StringTreeSet {

    private rl.prog2.ss23.training.collections.StringTreeSetNode root;

    public boolean add(String key) {
        rl.prog2.ss23.training.collections.StringTreeSetNode newNode = new rl.prog2.ss23.training.collections.StringTreeSetNode(key);
        if (root == null) {
            root = newNode;
            return true;
        } else {
            return add(newNode, root);
        }
    }

    private boolean add(rl.prog2.ss23.training.collections.StringTreeSetNode newNode, rl.prog2.ss23.training.collections.StringTreeSetNode curr) {
        int compResult = newNode.getKey().compareTo(curr.getKey());
        if (compResult < 0) {
            if (curr.getLeft() == null) {
                curr.setLeft(newNode);
                return true;
            } else {
                return add(newNode, curr.getLeft());
            }
        } else if (compResult > 0) {
            if (curr.getRight() == null) {
                curr.setRight(newNode);
                return true;
            } else {
                return add(newNode, curr.getRight());
            }
        } else {
            return false;
        }
    }

    public boolean contains(String key) {
        rl.prog2.ss23.training.collections.StringTreeSetNode curr = root;
        while (curr != null) {
            int compResult = key.compareTo(curr.getKey());
            if (compResult < 0)
                curr = curr.getLeft();
            else if (compResult > 0)
                curr = curr.getRight();
            else
                return true;
        }
        return false;
    }

    public int size() {
        return size(root);
    }

    private int size(rl.prog2.ss23.training.collections.StringTreeSetNode curr) {
        if (curr == null)
            return 0;
        else {
            return 1 + size(curr.getLeft()) + size(curr.getRight());
        }
    }

    public static void main(String[] args) {
        StringTreeSet set = new StringTreeSet();
        set.add("Charly");
        set.add("Alpha");
        set.add("Xray");
        set.add("Bravo");
        System.out.println(set.contains("Bravo")); // true
        System.out.println(set.contains("B")); // false
        System.out.println(set.size()); // 4
    }
}
