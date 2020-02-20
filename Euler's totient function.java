/*
Euler's totient function

-Euler's totient function, also known as phi-function ϕ(n), counts the number of integers between 1 and n inclusive, 
which are coprime to n.

Properties
The following properties of Euler totient function are sufficient to calculate it for any number:

1) If p is a prime number, then gcd(p,q)=1 for all 1≤q<p. Therefore we have: ϕ(p)=p−1.

2) If p is a prime number and k≥1, then there are exactly (p^k)/p numbers between 1 and (p^k) that are divisible by p. 
Which gives us: ϕ(p^k)=(p^k)−p^(k−1).

3) If a and b are relatively prime, then: ϕ(ab)=ϕ(a)⋅ϕ(b).

4) In general, for not coprime a and b, the equation  ϕ(ab)=ϕ(a)⋅ϕ(b)⋅dϕ(d)  with d=gcd(a,b) holds.
*/

int phi(int n) {
    int result = n;
    for (int i = 2; i * i <= n; i++) {
        if(n % i == 0) {
            while(n % i == 0){
                n /= i;
            }
            result -= result / i;
        }
    }
    if(n > 1)result -= result / n;
    return result;
}
