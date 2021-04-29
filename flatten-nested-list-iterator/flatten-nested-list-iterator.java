/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    
    List<Integer> flat = new ArrayList<>();
    public NestedIterator(List<NestedInteger> nestedList) {
        recurse(nestedList, 0, flat);
    }
    
    public void recurse(List<NestedInteger> list , int i, List<Integer> result){
        
        for(;i<list.size(); i++){
            NestedInteger n = list.get(i);
            if(n.isInteger()){
                result.add(n.getInteger());
            }else{
                recurse(n.getList(), 0, result);
            }
        }
    }
    int start =0;
    @Override
    public Integer next() {
        return flat.get(start++);
    }

    @Override
    public boolean hasNext() {
        return start < flat.size();
        // iteratoro until you find a specific integer so that we don't return 
        // True when it is empty
        
        
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */