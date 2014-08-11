
public class BST<Key extends Comparable<Key>, Value> {

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(Key key, Value value) {
        //TODO
    }

    public Value get(Key key) {
        return null;
    }

    public void delete(Key key) {
        //TODO
    }

    public Iterable<Key> iterator() {
        //TODO
        return null;
    }
}
