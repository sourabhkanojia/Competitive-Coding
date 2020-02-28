/*
Sparse Table is a data structure, that allows answering range queries. It can answer most range queries in O(logn), 
but its true power is answering range minimum queries (or equivalent range maximum queries). 
For those queries it can compute the answer in O(1) time.
*/

//Build
int st[MAXN][K + 1];                   //MAXN  is the array length.
for (int i = 0; i < N; i++){           //K has to satisfy K≥⌊log2(MAXN)⌋+1
    st[i][0] = array[i];
}

for (int j = 1; j <= K; j++){
    for (int i = 0; i + (1 << j) <= N; i++){
        st[i][j] = min(st[i][j-1], st[i + (1 << (j - 1))][j - 1]);
    }
}

//Query
int log[MAXN+1];
log[1] = 0;
for (int i = 2; i <= MAXN; i++){
    log[i] = log[i/2] + 1;
}

int j = log[R - L + 1];
int minimum = min(st[L][j], st[R - (1 << j) + 1][j]);
