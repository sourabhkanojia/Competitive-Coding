/*
Binary Exponentiation (Fast Exponentiation)

Binary exponentiation (also known as exponentiation by squaring) is a trick which allows to 
calculate a raised to power n using only O(logn) multiplications (instead of O(n) multiplications required by 
the naive approach).
*/

static long binpow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b&1)==1)res = res * a;
            a = a * a;
            b >>= 1;
        }
        return res;
    }
    
// Applications-Effective computation of large exponents modulo a number ((a raised to power b) mod m).

static long binpow(long a,  long b,  long m){
        a %= m;
        long res = 1;
        while (b > 0) {
            if ((b&1)==1)
                res = (res * a) % m;
            a = (a * a) % m;
            b >>= 1;
        }
        return res;
    }
