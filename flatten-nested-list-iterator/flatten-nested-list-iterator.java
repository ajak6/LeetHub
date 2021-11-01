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
    Deque<List<NestedInteger>> stack;
    Deque<Integer> indexStack;
    List<NestedInteger> nested;
    NestedInteger current;
    int curr;
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new ArrayDeque<>();
        indexStack= new ArrayDeque<>();
        nested = nestedList;
        current = null;
        curr=0;
        // hasNext();
    }
    

    @Override
    public Integer next() {
        hasNext();
        int res = current.getInteger();
        curr++;
        current=null;
        return res;
    }

    @Override
    public boolean hasNext() {
        //should iterate and end up at a integer
        //look in stack top
        //maintain current pointer and current list
      //rrent liust can be empty
        //current list ended
        //current list contains another list
        //cjurrent list is a integer
        // if(current==null)return false;
        
        while ((current==null || !current.isInteger())) {
            while(curr == nested.size() && !stack.isEmpty()) {
                curr = indexStack.poll();
                nested = stack.poll();
            }
            if(curr==nested.size() && stack.isEmpty()) {
                return false;
            }
            current =  nested.get(curr);
            if(current.isInteger()) return true;

            stack.push(nested);
            indexStack.push(curr + 1);
            nested = current.getList();
            curr = 0;
        }
        return false;
        
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */