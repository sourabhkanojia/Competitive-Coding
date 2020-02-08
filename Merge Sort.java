//Merge Sort

import java.util.*;
import java.io*;

public class Main {
    public static void main(String[] args) {
        int[] a={11,4,7,8,,1,3,13};
        mergeSort(a,0,a.length-1);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
    public static void mergeSort(int[] a,int s,int e){
        if(s>=e)return;
        //Divide
        int mid=s+(e-s)/2;
        //Recursion
        mergeSort(a,s,mid);
        mergeSort(a,mid+1,e);
        //Merge
        merge(a,s,e);
    }
    public static void merge(int[] a,int s,int e){
        int mid=s+(e-s)/2;
        int i=s,j=mid+1;
        int[] temp=new int[e-s+1];
        int k=0;
        while(i<=mid && j<=e){
            if(a[i]<=a[j])temp[k++]=a[i++];
            else temp[k++]=a[j++];
        }
        while(i<=mid)temp[k++]=a[i++];
        while(j<=e)temp[k++]=a[j++];
        i=s;
        for(k=0;k<temp.length;k++)a[i++]=temp[k];
    }
}
