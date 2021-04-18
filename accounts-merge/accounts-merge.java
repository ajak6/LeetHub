class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        
        //is adj needed? let do it. - but it is not poissible we do not know all connecttions without that we canpt create it.
        
        // if every node is a node create a mapping with ther then we 
        // x- [y ] and y - > [x] 
        
        // thjen for each first make itself the parent.
        // duting adjk create parent topoint to themse;ves so that one with nop other email also have a parent.
        //what if at the end wee again do union of all parents in the values and then vount unique values.
        //oarent ks uniin t nahi karsakte because ytou will developing a  relation ebtwee non related emails
        // at the end we only want a single  
        //how to handle when some parents are already set and then that parent starts pointing to another parent.
        //we will get differenet parents from the parents set bnut actual some parents may be pointing other emails in that pranet set.
        // can we do bfs? we can do BF as well to keep visiting all nodes and add them to a siongle result. 
        
        //how will do bfgs you will not know the ykey s in which these emails shoud go from thweq ueue .
        // if you do dfs then tes we can keep putting things in the same hashmap objkect sand at the end we will have a single list for each kt..
        
        List<List<String>> result = new ArrayList<>();
        Map<String, String> nameEmail = new HashMap<>();
        Map<String, Set<String>> adj = new HashMap<>();
        
        for(int i =0 ; i < accounts.size(); i++) {
            
            List<String> account =accounts.get(i);
            String name = account.get(0);
            nameEmail.put(account.get(1), name);
            adj.putIfAbsent(account.get(1), new HashSet<>());
            
            for(int j =2; j < account.size(); j++){
                adj.computeIfAbsent(account.get(j-1), d-> new HashSet<>()).add(account.get(j));
                adj.computeIfAbsent(account.get(j), d-> new HashSet<>()).add(account.get(j-1));
                nameEmail.put(account.get(j), name);
            }
        }
        //do a traversal
        //you will have to pick an email from the grapdo a bfs and visit evrything and add in the result list.
        //once it finishes you sort that list and name as the first and put it in the result.
        // System.out.println(adj);
        
        HashSet<String> visited = new HashSet<>(); // visited when its ajd is added in the queue.
        for(Map.Entry<String, Set<String>> entry : adj.entrySet()) {
            
            List<String> newAccount = new ArrayList<>();
            String email1 = entry.getKey();
            
            if(visited.add(email1)) {
                bfs(email1, visited, adj, newAccount);   
                Collections.sort(newAccount, Comparator.reverseOrder());
                newAccount.add(nameEmail.get(email1));
                Collections.reverse(newAccount);
                result.add(newAccount);
            
            }
            
            
            
        }
        return result;
    }
    public void bfs(String key, Set<String> visited, Map<String, Set<String>> adj, List<String> account) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(key);
        visited.add(key);
        while(!queue.isEmpty()) {
            String email1 = queue.poll();
            account.add(email1);
            Set<String> emails = adj.get(email1);
            
            for(String email : emails){
                
                if(visited.add(email)){
                    queue.offer(email);
                }
            }
        }
    }
}
    
//     public List<List<String>> accountsMerge2(List<List<String>> accounts) {
        //first is the namem
        // rest are emails
        //we have n of these 
        // some emails could be common between but names will be same
        //not all same name will be grounds for groupng the account
        // if there is any link it means they are linked.
        //ll mapped transitive will group into a single account
        //result 
        // Approach1: basically each email is a link with another email in the list.
        // it is a fully connected graph. If the relation is transitive thenm only 1 connected ios enouighgt to connect pther A-> B-> C-> D
        // if we careate adj list for these connections. We can do a DFS and connect everyemail into a single list and mark them visited.\
        //then move to next item, it not visited  then start DFS from there. 
        //complexity - create the graph fro th elsit traverse every list and n list n*m
        //adj is a map of list so space complexity will be same as total emails and ames.
        //to do the DDFS we will visit every email which is again n*m
        
        
        // Union Find:
        // every email is its own parent.
        //nce the graph is created we create a union between 2 emails and 1 beome a parent
        //this parent is not connected to anoter email which will become it parent and that way will
        //have a chin to connect these emails and have a common parent at the nend
        //once we do we will have a common email but how will we group?
        //traverse the union map and for each parent we create a reverse map which puts all emails which have this guy its parent in a lis.
        // maintain another map where email is mapped to aname and awe can just pick a name and create the result.
        // we have need to sort the results at then end, unsure we can maintain sortedresults. 
        /*create a map 
        List<List<String>> result = new ArrayList<>();
        Map<String, String> nameEmail = new HashMap<>();
        Map<String, Set<String>> adj = new HashMap<>();
        HashMap<String, String> parent = new HashMap<>();
        Map<String, Integer> rank = new HashMap<>();
        for(int j =0 ; j< accounts.size(); j++) {
            List<String> account = accounts.get(j);
            String name = account.get(0);
            //single email still need to be in graph
            //create the entry in graph and then ad dmore later
            if (account.size()>1) {
                adj.putIfAbsent(account.get(1), new HashSet<>());
                parent.put(account.get(1), account.get(1));
                nameEmail.put(account.get(1), name);
                rank.put(account.get(1),1);
            }
            
            for(int i=1;i<account.size()-1; i++){
                nameEmail.put(account.get(i), name);
                nameEmail.put(account.get(i+1), name);
                adj.computeIfAbsent(account.get(i), x -> new HashSet<>()).add(account.get(i+1));
                adj.computeIfAbsent(account.get(i+1), x -> new HashSet<>()).add(account.get(i));
                //prolly repeat but can be optimized
                parent.put(account.get(i), account.get(i));
                parent.put(account.get(i+1), account.get(i+1));
                rank.put(account.get(i), 1);
                rank.put(account.get(i+1), 1);
            }
        }
        
        System.out.println(adj);
        adj.entrySet().stream().forEach(entry -> {
            String email1=entry.getKey();
            entry.getValue().stream().forEach(email2-> unionFind(rank, parent, email1, email2));
        });
        
        //group all the child with a common parent.
        System.out.println("PArent " + parent);
        //comporess parent
        Map<String, List<String>> group = parent.entrySet().stream().collect(Collectors.groupingBy(Map.Entry::getValue,
                    Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
        group.entrySet().stream().forEach(entry-> {
            // entry.getValue().add(entry.getKey());
            Collections.sort(entry.getValue());
            }
        );
        
        for(List<String> value: group.values()) {
            String name = nameEmail.get(value.get(0));
            value.add(0, name);
        }
        System.out.println(":group "+group);
        return new ArrayList<>(group.values());
    }
    
    
    public String find(String a){
        if(parent.get(a)!=a) {
            parent.put(a, parent.get(parent.get(a)));
            return find(parent.get(a));
        }
        return a;
    }
    public void unionFind(Map<String, Integer> rank, Map<String, String> parent, String a, String b) {
        while(parent.get(a)!=a) {
            parent.put(a, parent.get(parent.get(a)));
            a=parent.get(a); //path compresion is needed
        }
        while(parent.get(b)!=b) {
           parent.put(b, parent.get(parent.get(b)));
           b=parent.get(b);
        }
        if(a==b) return;
        if(rank.get(a)> rank.get(b)){
            parent.put(b, a);
        } else {
            parent.put(a,b);    
        }
    }
}
// We have many pictures in our family photographs in which my grand monther, mother wore this ornament. 
// 
*/    














