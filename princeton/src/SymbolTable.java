
public class SymbolTable<Key, Value> {
    public SymbolTable() {
        //TODO
        // assume Key are Comparable
        //use immutable for Key - String, Integer, Double, File
    }

    public void put(Key key, Value value) {
        //TODO
        //overrides value is same key is present
    }

    public Value get(Key key) {
        //TODO
        return null; //if key not present
    }

    public void delete(Key key) {
        //TODO
    }

    public boolean contains(Key key) {
        return (get(key) != null);
    }

    public boolean isEmpty() {
        //TODO
        return true;
    }

    public int size() {
        //TODO
        return 0;
    }

    public Iterable<Key> keys() {
        //TODO
        return null;
    }
}
