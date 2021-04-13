
class Directory {
    String rootPath; //path until parent directory
    //children can be files and directry
    HashMap<String,Directory> children = new HashMap<>();
    HashMap<String, File> files = new HashMap<>();
    String name;
    public Directory(String name){
        this.name=name;
    }
    String getName(){
        return name;
    }
}

class File{
    
    String rootPath;
    StringBuilder contents;
    String name;
     public File(String name){
        this.name=name;
         contents= new StringBuilder();
    }
    String getName(){
        return name;
    }
}

class FileSystem {
    //what do we need to access
    //query-> path - which will be as tring.
    // results are -> 
    // null - not created
    // Directory and Files.
    // you call name on them and return a list
    // Map<String , System> map;
    Directory mainDir;
    public FileSystem() {
        // map= new HashMap<>();
        mainDir = new Directory("whatever");
        Directory rootDir = new Directory("/");
        mainDir.children.put("/",rootDir);
            
    }
    //key will path or name?
        //if we keep just name them same files in diff diretory will be a problem
        //if we keep path then lookup is easy but when listing we will return the full path not just only names which isrequestsed.//Lets create a node which will hpld the path, name -> how will we query this path then
    //or we create another map of path to just names? or we can extract names from the path by doing splits?
    
    public List<String> ls(String path) {
        List<String> result = new ArrayList<>();
        if(path.isEmpty()) return result;
        Directory root = mainDir.children.get("/");
        
        String sub [] = path.split("/");
        /*
        Case1 it is a path to directoy: in this case we will list all directories in this directory
        we list all files in this directory
        Case 2 it can be a path to file: only return the file name
        */
        for(String s: sub){
            if(s.isBlank()) continue;
            
            Directory rootNew =root.children.get(s);    
            //it is possibily a file address or the dir hsa no such directoy.
            if(rootNew==null){
                if(root.files.containsKey(s)){
                    result.add(s);
                    return result;
                }
                break;
            }else{
                root=rootNew;
            }
        }
        //path is a level up and we should list all directories and files
        if(root!=null){
            result.addAll(root.children.keySet());    
            result.addAll(root.files.keySet());
        }
        Collections.sort(result);
        return result;
      
    }
    //directory stored with name and object
    public void mkdir(String path) {
        
        String paths [] = path.split("/");
        Directory root = mainDir.children.get("/");
        
        for(String sub: paths){
            if(sub.isBlank()) continue;
            Directory next = root.children.get(sub);
            if(next==null){
                next = new Directory(sub);
                root.children.put(sub, next);
            }
            root = next;
        }   
    }
    
    public void addContentToFile(String filePath, String content) {
        String paths [] = filePath.split("/");
        Directory root = mainDir.children.get("/");
        
        for(int i =0;i < paths.length-1; i++){
            String sub = paths[i];
            if(sub.isBlank()) continue;
            Directory next = root.children.get(sub);
            if(next==null){
                //expection
                System.out.println("excpion in file path "+ filePath);
            }
            root = next;
        }
        String fileName = paths[paths.length-1];
        File f = null;
        if(root.files.containsKey(fileName)){
             f = root.files.get(fileName);
        }else{
            f=new File(fileName);
            root.files.put(fileName, f);
        }
        f.contents.append(content);
    }
    
    public String readContentFromFile(String filePath) {
        String paths [] = filePath.split("/");
        Directory root = mainDir.children.get("/");
        
        for(int i=0; i < paths.length-1; i++) {
            
            String sub  = paths[i];
            if(sub.isBlank()) continue;
            root=root.children.get(sub);
            if(root==null){
                System.out.println("path noth present "+ filePath );
            }
        }
        String fileName = paths[paths.length-1];
        File f = root.files.get(fileName);
        return f.contents.toString();
    }
}


// public List<String> ls(String path) {
//         Directory root = mainDir.children.get("/");
//         System.out.println("ls for "+path);
//         System.out.println("String root children "+ root.children);
//         //walk until the directory for this path.
//         String [] subdir = path.split("/");
//         StringBuilder b = new StringBuilder("/");
//         Directory curr=null;
//         File files=null;
//         for(String s: subdir) {
//             if(s.isEmpty()) continue;
//             b.append(s);
//             System.out.println("searcghhing "+ b.toString());
//             files = root.files.get(b.toString());
//             root = root.children.get(b.toString());
//             if(root==null) break;
//             b.append("/");
//         }
        
//         List<String> result = new ArrayList<>();
//         if(root!=null && !root.children.isEmpty()){
            
//         System.out.println(":root "+ root);
//         System.out.println(":root children "+ root.children);
//         System.out.println(":root children values "+ root.children.values());
//             result.addAll(root.children.values().stream().map(x-> x.name).collect(Collectors.toList()));
            
//         }
//         if (files!=null) {
//             result.add(files.name);
//         }
        
//         // List<String> result = root.children.values().stream().map(x-> x.name).collect(Collectors.toList());
        
//         return result;
//     }
    
//     public void mkdir(String path) {
//         //if path exissts?
//         Directory rootDir = mainDir.children.get("/");
//         // if(map.containsKey(path)) return;
//         //root will always be there
        
//         String [] subdir = path.split("/");
//         StringBuilder pathBuilder = new StringBuilder("/");
//         String parentPath =pathBuilder.toString();
//         Directory parentDir = rootDir;
//         Directory curr = null;
//         //e.g. /path/to/dir
//         for(String sub: subdir) {
//             if(sub.isEmpty()) continue; //since path startsat "/", 0th element will be empty.
            
//             pathBuilder.append(sub);
//             String pathUntilCurr = pathBuilder.toString();
//             if(parentDir.children.containsKey(pathUntilCurr)) {
//                 curr=parentDir.children.get(pathUntilCurr);
                
//             } else {
//                 curr = new Directory(sub);
//                 curr.rootPath = parentPath;
//                 //store absolute path without the trailing slash
//                 parentDir.children.put(pathUntilCurr, curr);
//             }
            
//            pathBuilder.append("/");
//            parentPath=pathBuilder.toString();
//            parentDir=curr;
//         }
//     }
    
   
    
//     public void addContentToFile(String filePath, String content) {
//         //walk to parent folder
//         // get the 
        
//         Directory root =  mainDir.children.get("/");
//         String sub []= filePath.split("/");
//         //leave last thing as file name and find the parent directory.
//         StringBuilder parent=new StringBuilder("/");
//         String fileName = sub[sub.length-1];
//         System.out.println(Arrays.toString(sub));
//         for(int i=0;i < sub.length-1; i++) {
//             if(sub[i].isEmpty()) continue;
//             parent.append(sub[i]);
//             root = root.children.get(parent.toString());
//             parent.append("/");
//         }
        
//         File file = root.files.get(parent.substring(0, parent.length()-1));
//         if (file == null) {
//             file = new File(fileName);
//             root.files.put(parent.substring(0, parent.length()-1), file);
//         }
//         System.out.println(" writing file "+ file);
//         file.contents.append(content);
//     }
    
//     public String readContentFromFile(String filePath) {
//         Directory root =  mainDir.children.get("/");
//         String sub [] = filePath.split("/");
//         //leave last thing as file name and find the parent directory.
//         StringBuilder parent = new StringBuilder("/");
//         String fileName = sub[sub.length-1];
//         for(int i=0;i < sub.length-1; i++) {
//             if(sub[i].isEmpty()) continue;
//             parent.append(sub[i]);
//             root = root.children.get(parent.toString());
//             parent.append("/");
//         }
        
//         File file = root.files.get(parent.substring(0, parent.length()-1));
//         // System.out.println(" reading file "+ file);   
//         if (file==null) {
//             return "";
//         } else {
//             return file.contents.toString();
//         }
//     }

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */