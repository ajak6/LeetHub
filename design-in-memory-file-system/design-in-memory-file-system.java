class File {
    boolean isFile;
    Map<String, File> nameWithFileObjects = new HashMap<>();
    StringBuilder contents  = new StringBuilder();
    String name;
    public File() {    
    }
    
    public File(String name ) {
        contents = new StringBuilder();
        nameWithFileObjects = new HashMap<>();
        isFile=false;
        this.name= name;
    }
}

class FileSystem {
    File root;
    public FileSystem() {
        root = new File();        
    }
    
    public List<String> ls(String path) {
        String [] paths = path.split("/");
        List<String> result = new ArrayList<>();
        File end = traversePath(paths);
        if(end.isFile){
            result.add(end.name);
            return result;   
        }
        result.addAll(end.nameWithFileObjects.keySet());
        Collections.sort(result);
        return result;
            
    }
    
    public void mkdir(String path) {
        String [] paths = path.split("/");
        traverseCreate(paths);
    }
    
    public void addContentToFile(String filePath, String content) {
        File file = traverseCreate(filePath.split("/"));
        file.isFile = true;
        file.contents.append(content);
    }
    
    public String readContentFromFile(String filePath) {
        File file = traversePath(filePath.split("/"));
        return file.contents.toString();
    }
    
    private File traverseCreate(String [] paths){
        File node = root;
        for(int i = 1 ; i < paths.length; i++){
            node.nameWithFileObjects.putIfAbsent(paths[i], new File(paths[i]));
            node = node.nameWithFileObjects.get(paths[i]);
        }
        return node;
        
    }
    private File traversePath(String[] paths){
        File node = root;
        for(int i=1; i < paths.length; i++) {
            node = node.nameWithFileObjects.get(paths[i]);
            if(node==null){
                return  null; //dooes not exist.
            }
        }
        return node;
    }
}


/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */