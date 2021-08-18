class BrowserHistory {

    
    
    int tail =0;
    int current =0;
    HashMap<Integer, String> history;
    public BrowserHistory(String homepage) {
        history = new HashMap<>();
        visit(homepage);
    }
    
    public void visit(String url) {
        current++;
        history.put(current, url);
        
        tail=current;
    }
    
    public String back(int steps) {
        int index =  Math.max(current-steps,1);
        
        current = index;
        return history.get(index);
    }
    
    public String forward(int steps) {
        int ind = Math.min(current+steps, tail);
        current=ind;
        return history.get(ind);
            
        
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */