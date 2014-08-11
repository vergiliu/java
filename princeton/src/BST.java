
public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private int count;
        private Key key;
        private Value value;
        private Node left, right;
        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    public int rank(Key key) {
        return rank(key, root);
    }

    private int rank(Key key, Node node) {
        if (node == null) return 0;
        int direction = key.compareTo(node.key);
        if (direction < 0 ) return rank(key, node.left);
        else if (direction > 0) return 1 + size(node.left) +rank(key, node.right);
        else return size(node.left);
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) return 0;
        return node.count;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) return new Node(key, value);
        int direction = key.compareTo(node.key);
        if (direction < 0) node.left = put(node.left, key, value);
        else if (direction > 0) node.right = put(node.right, key, value);
        else node.value = value;
        node.count = 1 + size(node.left) + size(node.right);
        return node;
    }

    public Value get(Key key) {
        Node n = root;
        while (n != null) {
            int direction = key.compareTo(n.key);
            if (direction < 0) n = n.left;
            else if (direction > 0) n = n.right;
            else return n.value;
        }
        return null;
    }

    public void delete(Key key) {
        //TODO
    }

    public Iterable<Key> iterator() {
        Queue<Key> myQueue = new Queue<Key>();
        inOrderTraversal(root, myQueue);
        return myQueue;
    }

    private void inOrderTraversal(Node node, Queue<Key> queue) {
        if (queue == null) return;
        inOrderTraversal(node.left, queue);
        queue.enqueue(node.key);
        inOrderTraversal(node.right, queue);
    }

    public static void main(String[] args) {
        BST b = new BST();
        b.put("ana", 1);
    }
}
