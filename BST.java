package p5;

public class BST {
    public static void main(String[] args) {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<Integer, String>();
        bst.insert(33, "A");
        bst.insert(12, "B");
        bst.insert(85, "C");
        bst.insert(27, "D");
        bst.insert(54, "E");
        bst.insert(13, "F");
        bst.insert(24, "G");
        bst.insert(3, "H");
        bst.insert(15, "I");
        bst.insert(22, "J");
        bst.insert(40, "K");
        bst.insert(56, "L");
        bst.insert(77, "M");
        bst.insert(73, "N");
        bst.insert(10, "O");
        System.out.print("Levelorder: ");
        bst.levelOrder();
        System.out.println();
        System.out.println("33 => " + bst.search(33));
        System.out.println("Min: " + bst.min());
        System.out.println("Max: " + bst.max());
        System.out.println("Delete 73 => " + bst.search(73));
        bst.delete(73);
        System.out.print("Levelorder: ");
        bst.levelOrder();
        System.out.println();

        System.out.println("Delete 56 => " + bst.search(56));
        bst.delete(56);
        System.out.print("Levelorder: ");
        bst.levelOrder();
        System.out.println();
        
        System.out.println("Delete 33 => " + bst.search(33));
        bst.delete(33);
        System.out.print("Levelorder: ");
        bst.levelOrder();
        System.out.println();
    }
}
