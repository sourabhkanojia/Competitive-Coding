Fenwick Trees(BIT)

/*A Fenwick tree is a wonderful data structure that supports two operations on an array: increment a given value by a given amount, 
and find the sum of a segment of values, both in O(log n) time. What's more, the Fenwick tree is represented as just an array of 
the same size as the array being updated and queried,
and we don't need to store the original array itself! In other words, we can support the above operations 
without any additional memory.

For a start, here is the entire code for a Fenwick tree: */
class bit{
//Initialization
    int[] tree;
    int size;
    public bit(int size){
        tree=new int[size];
        this.size=size;
    }
 
 // update position by delta
    void update(int i,int delta){
        while(i<=size){
            tree[i]+=delta;
            i+=i&(-i);
            //i+=Integer.lowestOneBit(i);
        }
    }
 
 // compute the prefix sum value[1,i]
    int sum(int i){
        int sum=0;
        while(i>0){
            sum+=tree[i];
            i-=i&(-i)
            //i-=Integer.lowestOneBit(i);
        }
        return sum;
    }

// compute the range sum [l,r];
    int rangeSum(int l,int r){
        return sum(r)-sum(l-1);
    }
//-------------------------------------------------------------------------------------------------------------------------------------
//For Range Update and Point Query
  void range_add(int l, int r, int val) {
      add(l, val);
      add(r + 1, -val);
  }
  int point_query(int idx) {
      int res = 0;
      while(idx>0){
         res+=tree[idx];
         i-=i&(-i);
	    }
	return res; 
  }
}
