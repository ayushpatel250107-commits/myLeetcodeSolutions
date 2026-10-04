import java.util.TreeSet;

class SmallestInfiniteSet {
    private int curr;
    private TreeSet<Integer> addedBack;

    public SmallestInfiniteSet() {
        this.curr = 1;
        this.addedBack = new TreeSet<>();
    }
    
    public int popSmallest() {
        if (!addedBack.isEmpty()) {
            int smallest = addedBack.first();
            addedBack.remove(smallest);
            return smallest;
        }
        int smallest = curr;
        curr++;
        return smallest;
    }
    
    public void addBack(int num) {
        if (num < curr && !addedBack.contains(num)) {
            addedBack.add(num);
        }
    }
}
