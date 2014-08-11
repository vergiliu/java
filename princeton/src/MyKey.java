//test for user define type as key

public class MyKey implements Comparable{
    private String key;

    public MyKey(String aKey) {
        this.key = aKey;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null) return false;
        // alternative using instanceof
        if (o.getClass() != this.getClass()) return false;
        MyKey that = (MyKey) o;
        if (that.key.equals(this.key)) return false;
        return true;
    }

    @Override
    public int compareTo(Object o) {
        if (this.equals(o)) return 0;
        else return 1;
    }
}
