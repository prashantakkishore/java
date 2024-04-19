package com.pks.ds.arrays;

/**
 * https://www.geeksforgeeks.org/minimize-flips-to-make-binary-string-as-all-1s-by-flipping-characters-in-substring-of-size-k-repeatedly/
 */
public class MinFlipsKSubStringAll1s {

    // Function to find the minimum number
// of operations required to convert all
// the characters to 1 by flipping the
// substrings of size K
    static void minOperation(String S, int K, int N) {

        // Stores the minimum number of
        // operations required
        int min = 0;

        int i;

        // Traverse the string S
        for (i = 0; i < N; i++) {

            // If the character is 0
            if (S.charAt(i) == '0' && i + K <= N) {

                // Flip the substrings of
                // size K starting from i
                for (int j = i; j < i + K; j++) {
                    if (S.charAt(j) == '1')
                        S = S.substring(0, j) + '0' + S.substring(j + 1);
                    else
                        S = S.substring(0, j) + '1' + S.substring(j + 1);
                }

                // Increment the minimum count
                // of operations required
                min++;
            }
        }

        // After performing the operations
        // check if string S contains any 0s
        for (i = 0; i < N; i++) {
            if (S.charAt(i) == '0')
                break;
        }

        // If S contains only 1's
        if (i == N)
            System.out.println(min);
        else
            System.out.println(-1);
    }

    // Driver Code
    public static void main(String[] args) {

        String S = "00010110";
        int K = 3;
        int N = S.length();
        minOperation(S, K, N);
    }
}


