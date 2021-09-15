class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        //start from a node store that you are visiting it.
        //if you hit the same node again return its statge
        //recursive for other nodes.
        // there are two states. - visiting and visited
        //if you are visiting a node and again hit it it means it has a cuycle
        //if yoy have visited that node then store the state for it.
        State[] states = new State[graph.length];
        List<Integer> res = new ArrayList<>();
        for(int i=0; i < graph.length ; i++) { 
            
            if(safe(i, graph, states)){
                res.add(i);
            }
        }
        return res;
        
    }
    public boolean safe(int start, int [][] graph, State[] states){
        if(states[start]!=null){
            return states[start]==State.VISITED;//if it is visiting it means it has a cycle.
        }
        states[start]= State.VISITING;
        
        int [] neighbors = graph[start];
        for(int nn: neighbors){
            if(!safe(nn, graph, states)) return false;
        }
        states[start]=State.VISITED;
        return true;
    }
    enum State {
        VISITING,
        VISITED
    }
}