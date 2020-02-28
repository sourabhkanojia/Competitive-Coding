/*
This data structure provides the following capabilities. We are given several elements, each of which is a separate set. 
A DSU will have an operation to combine any two sets, and it will be able to tell in which set a specific element is.
*/

class disjointSet{
    int[] parent;
    int[] size;
    public disjointSet(int v){
      this.parent=new int[v];
      this.size=new int[v];
    }
    public void makeSet(){
        for(int i=0;i<parent.length;i++){
            parent[i]=i;
            size[i]=1;
        }
    }
    public int find(int v){
        if (v == parent[v]) return v;
        return parent[v]=find(parent[v]);
    }
    public void union(int a,int b){
        a=find(a);
        b=find(b);
        if(a!=b){
            if(size[a]<size[b]){
		parent[a]=b;
		size[b]+=size[a];
	    }
            else {
		parent[b]=a;
            	size[a]+=size[b];
	    }
        }
    }
}
