// Dijkstra's algorithm -  Fixes a single node as the "source" node and finds shortest paths from the source 
//                         to all other nodes in the graph.

// You can use Dijkstra's algorithm in both directed and undirected graphs.
// This code is for undirected graph.(Remove line 21 making it for directed graph)

import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb=new StringBuilder();
        int n=sc.nextInt(),m=sc.nextInt();                  // n is number of vertex and m is number of edges in graph.
        LinkedList<Point>[] ll=new LinkedList[n];
        for(int i=0;i<n;i++)ll[i]=new LinkedList<>();
        for(int i=0;i<m;i++){
            int u=sc.nextInt()-1,v=sc.nextInt()-1,w=sc.nextInt();
            ll[u].add(new Point(v,w));
            ll[v].add(new Point(u,w));
        }
        boolean[] vis=new boolean[n];
        int[] parent=new int[n];
        int[] dist=new int[n];
        Arrays.fill(parent,-1);
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<Point> pq=new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.y-o2.y;
            }
        });
        dist[0]=0;
        pq.add(new Point(0,0));
        while(!pq.isEmpty()){
            Point p=pq.poll();
            if(!vis[p.x]){
                vis[p.x]=true;
                for(Point node:ll[p.x]){
                    if(!vis[node.x]){
                        if(dist[node.x]>dist[p.x]+node.y){
                            dist[node.x]=dist[p.x]+node.y;
                            parent[node.x]=p.x;
                            pq.add(new Point(node.x,dist[node.x]));
                        }
                    }
                }
            }
        }
        System.out.println("Shortest Path from source 0 to all other vertex");
        for(int i=1;i<n;i++){
            System.out.println(i+" -> "+dist[i]);
        }
    }
}
