import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(Sytem.in);
        StringBuilder sb=new StringBuilder();
        int n=sc.nextInt();   // No. of vertex
        int m=sc.nextInt();   // No. of edges

        LinkedList<Edge> edge=new LinkedList<>();

        for(int i=0;i<m;i++){
            int u=sc.nextInt()-1;  
            int v=sc.nextInt()-1;
            int w=sc.nextInt();  // Weight of edge u-v;
            edge.add(new Edge(u,v,w));
        }

        // Sort edges on the basis of it's weight
        Collections.sort(edge, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.w-o2.w;
            }
        });

        disjointSet set=new disjointSet(n);
        int count=0,totalWeight=0;
        while(count<n-1){
            Edge e=edge.removeFirst();
            int u=e.u,v=e.v,w=e.w;

            int a=set.find(u);
            int b=set.find(v);
            if(a!=b){
                set.union(a,b);
                count++;
                totalWeight+=e.w;
            }
        }
        System.out.println("Weight of Minimum Spanning Tree - "+totalWeight);
        // You can also store edges of MST
    }
}

class Edge{
    int u,v,w;
    public Edge(int u,int v,int w){
        this.u=u;
        this.v=v;
        this.w=w;
    }
}

//Disjoint Set Union class
class disjointSet{
    int[] parent;
    int[] size;
    public disjointSet(int v){
        this.parent=new int[v];
        this.size=new int[v];
        makeSet();
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
        if(size[a]<size[b]){
                parent[a]=b;
                size[b]+=size[a];
        }
        else {
            parent[b] = a;
            size[a] += size[b];
        }
    }
}
