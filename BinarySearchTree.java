package p5;

public class BinarySearchTree<K extends Comparable<? super K>, V>
        extends BinaryTree<K, V>
        implements Tree<K, V> {
    private BTNode<K, V> root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(K key, V data) {
        root = insertNode(root, key, data);
    }

    public void delete(K key) {
        root = deleteNode(root, key);
    }

    public V search(K key) {
        V info = null;
        info = getData(find(root, key));
        return info;
    }

    public K max() {
        K kunci = null;
        kunci = getKey(findMax(root));
        return kunci;
    }

    public K min() {
        K kunci = null;
        kunci = getKey(findMin(root));
        return kunci;
    }

    private BTNode<K, V> insertNode(BTNode<K, V> node, K k, V data) {
        // Jika tree masih kosong (belum ada node sama sekali), atau
        // T sebelumnnya adalah child node
        // Buat node baru yang akan dilink-kan ke child node sebelumnya
        if (node == null) {
            // buat node baru
            BTNode<K, V> newNode = new BTNode<K, V>(k, data);
            return newNode;
        }
        // key dari node baru lebih kecil dari key child node sebelumnya
        // go to the left node (subtree)
        // node baru akan dilink ke left link
        else if (k.compareTo(node.getKey()) < 0) {
            node.setLlink(insertNode(node.getLlink(), k, data));
            return node;
        }
        // key dari node baru lebih besar dari ata sama dengan
        // key child node sebelumnya
        // go to the right node (subtree)
        // node baru akan dilink ke right link
        else {
            node.setRlink(insertNode(node.getRlink(), k, data));
            return node;
        }
    }

    private BTNode<K, V> deleteNode(BTNode<K, V> node, K k) {
        if (node == null)
            return node;
        // jika key yang akan dihapus lebih kecil dari key node saat ini
        // maka telusuri ke subtree kiri
        else if (k.compareTo(node.getKey()) < 0) {
            node.setLlink(deleteNode(node.getLlink(), k));
            return node;
        }
        // jika key yang akan dihapus lebih besar dari key node saat ini
        // maka telusuri ke subtree kanan
        else if (k.compareTo(node.getKey()) > 0) {
            node.setRlink(deleteNode(node.getRlink(), k));
            return node;
        }
        // jika key yang akan dihapus sama dengan key node saat ini
        else {
            // kasus 1: node yang akan dihapus tidak memiliki child node (leaf)
            if (node.getLlink() == null && node.getRlink() == null) {
                return null;
            }
            // kasus 2: node yang akan dihapus hanya memiliki satu child node
            else if (node.getLlink() == null) {
                return node.getRlink();
            } else if (node.getRlink() == null) {
                return node.getLlink();
            }
            // kasus 3: node yang akan dihapus memiliki dua child node
            else {
                // cari key terkecil pada subtree kanan (successor)
                BTNode<K, V> successor = findMin(node.getRlink());
                // ganti key dan data pada node yang akan dihapus dengan key dan data successor
                node.setKey(successor.getKey());
                node.setData(successor.getData());
                // hapus successor pada subtree kanan
                node.setRlink(deleteNode(node.getRlink(), successor.getKey()));
                return node;
            }
        }
    }

    private BTNode<K, V> find(BTNode<K, V> node, K k) {
        // node adalah subtree (root dari subtree)
        // jika key ditemukan pada node saat ini, kembalikan node
        if (node == null || node.getKey() == k)
            return node;
        // jika bukan dan k lebih besar telusuri ke subtree kanan
        else if (node.getKey().compareTo(k) < 0) {
            return find(node.getRlink(), k);
        }
        // jika bukan dan k lebih kecil telusuri ke subtree kiri
        else
            return find(node.getLlink(), k);
    }

    private BTNode<K, V> findMin(BTNode<K, V> node) {
        if (node == null)
            return null;
        else if (node.getLlink() == null)
            return node;
        else
            return findMin(node.getLlink());
    }

    private BTNode<K, V> findMax(BTNode<K, V> node) {
        if (node == null)
            return null;
        else if (node.getRlink() == null)
            return node;
        else
            return findMax(node.getRlink());
    }

    public void inOrder() {
        printInOrder(root);
    }

    public void preOrder() {
        printPreOrder(root);
    }

    public void postOrder() {
        printPostOrder(root);
    }

    public void levelOrder() {
        printLevelOrder(root);
    }

    public K getKey(BTNode<K, V> node) {
        return node.getKey();
    }

    public V getData(BTNode<K, V> node) {
        return node.getData();
    }
}
