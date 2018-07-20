
https://www.youtube.com/watch?v=Ke_tII6Y0GE&list=PLTZbNwgO5ebqw1v0ODk8cPLW9dQ99Te8f

## Open Addressing
H(x) = H(x) + f(i)

### Linear probing:

For linear probing f(i) = i
H(x) = H(x) + i
After collision check element at - H(x) % table_size

[This leads to clustering problem - more table elements are empty still more compariions]

### Quadratic probing:

For quadratic probing f(i) = i * i
H(x) = H(x) + i * i
After collision check element at - H(x) % table_size

### Double hashing

For double probing f(i) = i * H2(x)
H2(x) = 7 - x mod 7 (7 is any number less than table size)

After collision check element at - H(x) + H2(x)  % table_size , next - H(x) + 2 * H2(x)  % table_size
