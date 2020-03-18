// Topological Sort - Topological Ordering of a directed graph is a linear ordering of its vertices such that for 
//                    every directed edge uv from vertex u to vertex v, u comes before v in the ordering.

// A Topological Ordering is possible if and only if the graph has no directed cycles.

import java.awt.*;
import java.io.*;
import java.util.*;

public class TopologicalSort {
    static LinkedList<Integer>[] adj;
    static boolean[] vis;
    static Stack<Integer> stack;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        adj=new LinkedList[6];
        vis=new boolean[6];
        for(int i=0;i<6;i++)adj[i]=new LinkedList<>();
        stack=new Stack<>();
        adj[5].add(0);
        adj[4].add(0);
        adj[4].add(1);
        adj[2].add(3);
        adj[3].add(1);
 
        for(int i=0;i<6;i++){
            if(!vis[i])dfs(i);
        }
        System.out.println("Following is a Topological Sort of the given graph");
        while(!stack.isEmpty()){
            int temp=stack.pop();
            System.out.print(temp+" ");
        }
    }
    static void dfs(int v){
        vis[v]=true;
        for(int u:adj[v]){
            if(!vis[u])dfs(u);
        }
        stack.add(v);
    }
}
