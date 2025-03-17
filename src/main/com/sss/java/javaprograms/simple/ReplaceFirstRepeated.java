package src.main.com.sss.java.javaprograms.simple;


import java.util.HashSet;


public class ReplaceFirstRepeated {
    public static void main(String[] args) {
        int[] num = {1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 5, 5};
        String[] result = replaceFirstRepeated(num);

        // Print the modified array
        for (String s : result) {
            System.out.print(s + " ");
        }
    }

    public static String[] replaceFirstRepeated(int[] num) {
        HashSet<Integer> seen = new HashSet<>();
        String[] result = new String[num.length];

        for (int i = 0; i < num.length; i++) {
            if (seen.contains(num[i])) {
                // If the element is already seen, check if it's the first duplicate
                if (!result[i - 1].equals("x")) {
                    result[i] = "x"; // Replace only the first duplicate with "x"
                } else {
                    result[i] = Integer.toString(num[i]); // Leave subsequent duplicates as is
                }
            } else {
                // Add the element to the set and keep it as is in the result
                seen.add(num[i]);
                result[i] = Integer.toString(num[i]);
            }
        }

        return result;
    }
}
/*
Explanation:
        We use a HashSet called seen to keep track of elements we've encountered.

        As we iterate through the array:

        If the current element is already in the HashSet, it means it's a duplicate, so we replace it with 'x'.

        If the current element is not in the HashSet, we add it to the HashSet to mark it as seen.

        This approach ensures that only the first occurrence of each repeated element is replaced, and subsequent duplicates are left as-is.

        Output:
        Copy
        1 x x 2 x x 3 x x 4 x 5 x
        Complexity:
        Time Complexity: O(n) because we iterate through the array once, and HashSet operations (contains and add) are O(1) on average.

        Space Complexity: O(n) in the worst case (if all elements are unique), as the HashSet stores unique elements.

        This is much more efficient than the previous solution!

        New chat
*/
