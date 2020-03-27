// Z Algorithm - This algorithm finds all occurrences of a pattern in a text in linear time.

String p = "abc";
Z-Function (Pattern Matching) - O(n+m)

String m = "abc";
String n = "xabcabzabc";
String s2 = m + "$" + n;
int n = s2.length();
int[] z = new int[n];

for (int i = 1, l = 0, r = 0; i < n; i++) {
    if (i <= r) z[i] = Math.min(r - i + 1, z[i - l]);
    while (i + z[i] < n && s2.charAt(z[i]) == s2.charAt(i + z[i])) z[i]++;
    if (i + z[i] - 1 > r){
	r = i + z[i] - 1;
	l=i;
      }
 }

for (int i = 0; i < n; i++) System.out.print(s2.charAt(i) + " ");
System.out.println();
for (int i = 0; i < n; i++) System.out.print(z[i] + " ");

