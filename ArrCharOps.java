/** A library of operations on arrays of characters (char values).
 *  The library also features a string comparison method. */
public class ArrCharOps {
    public static void main(String[] args) {
        String str = "clearly";
        char[] arr = "Somebody stop me".toCharArray();
        char[] arr1 = {'c','l','e','a','r','l','y'};
        char[] arr2 = {'U','n','d','e','r','s','t', 'o', 'o', 'd'};
        System.out.println(str);  // Prints the string
        println(arr1);            // Prints an array of characters
        System.out.println(charAt(arr1,2));      
        System.out.println(indexOf(arr1,'l'));  
        System.out.println(indexOf(arr1,'l',3)); 
        System.out.println(lastIndexOf(arr1, 'l'));
        System.out.println(concat(arr1, arr2));
        System.out.println(subArray(arr, 0, 8));
        System.out.println(compareTo("abcd", "abcd"));
        System.out.println(compareTo("abc", "abcd"));
        System.out.println(compareTo("abw", "abcd"));
        System.out.println(compareTo("Abcd", "a"));
        System.out.println(compareTo("apple", "banana"));
        System.out.println(compareTo("apple", "applepie"));
        System.out.println(compareTo("Zoo", "zoo"));
        System.out.println(hashCode(arr1));
        System.out.println(hashCode(arr2));
    }

    /** Prints the given array of characters, and moves the cursor to the next line.
     */
    public static void println(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    /** Returns the char value at the specified index. Assume that the array is non-empty.
     */
    public static char charAt(char[] arr, int index) {
        // throwing errors if the index is not feasible inside the array
        if (index <= -1 || index >= arr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        // returns the character at the index
        return arr[index];
        
    }

    /** If the two arrays have the same value in every index, 
     *  returns true; Otherwise returns false.
     */
    public static boolean equals(char[] arr1, char[] arr2) {
        // if they are not equal in length they cannot be equal
        if (arr1.length != arr2.length) return false;

        for (int i = 0; i < arr1.length; i++) {
            // if even one value is not the same the arrays are not equal
            if (arr1[i] != arr2[i]) return false; 
        }
        return true;
    }

    /** Returns the index within the given array of the first occurrence of the given character.
     *  If no such character is found, returns -1.
     */
    public static int indexOf(char[] arr, char ch) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ch) return i; // if found return the index
        }
        return -1; // not found if exited the loop with no returns
    }

    /** Same as indexOf(char[], char), but starts the search in the given index.
     */
    public static int indexOf(char[] arr, char ch, int fromIndex) {
        // if given index not valid throws an error
        if (fromIndex <= -1 || fromIndex >= arr.length){
            throw new ArrayIndexOutOfBoundsException();
        }
        // starts from the given index
        for (int i = fromIndex; i < arr.length; i++) {
            if (arr[i] == ch) return i; // if found return the index
        }
        return -1; // not found if exited the loop with no returns
    }

    /** Returns the index within the given arr of the last occurrence of the given character.
     *  If no such character is found, returns -1.
     */
    public static int lastIndexOf(char[] arr, char ch) {
        // to do this we will iterate from end to start which will find the first 
        // occurence of the character from the end which is also 
        // the last occurence of it
        for (int i = arr.length-1; i >= 0; i--) {
            if (arr[i] == ch) return i; // if found return the index
        }
        return -1; // not found if exited the loop with no returns
    }

    /* Returns an array which is the concatanation of the two given arrays.
    */
    public static char[] concat(char[] arr1, char[] arr2) {
        // creating a new array and allocating space in memory 
        // equal to the sum of lengths
        char[] concatArr = new char[arr1.length+arr2.length];
        // going over the first array and adding it to the one we created
        for (int i = 0; i < arr1.length; i++) {
            concatArr[i] = arr1[i];
        }
        // as the array we created has the size of both given ones combined
        // we can just iterate over the second one and place the value from the end 
        // of our last iteration (will work even if the lengths are 0)
        for (int i = 0; i < arr2.length; i++) {
            concatArr[i+arr1.length] = arr2[i];
        }
        // will return null if lengths are 0
        return concatArr;
    }

    /** Returns a new array that can be described as a sub-array of this array.
     *  The sub-array begins at the specified beginIndex and extends to the character at index endIndex - 1.
     *  For example, if arr contains the characters "hamburger", then subArray(4, 8) returns an array of
     *  characters containing the characters "urge".
     */     
    public static char[] subArray(char[] arr, int beginIndex, int endIndex) {
        // we return null if indices are incorrect
        if (beginIndex <= -1 || beginIndex > arr.length || beginIndex > endIndex) {
            return null;
        }else if (endIndex <= -1 || endIndex > arr.length) {
            return null;
        }
        // aas the endIndex can be the length itself we'll just retain it unless both are equal
        // which then will make no subArr
        char[] subArr = new char[endIndex-beginIndex];

        // we want to iterate from beginning to end included
        for (int i = beginIndex; i < endIndex; i++) {
            subArr[i-beginIndex] = arr[i];
        }
        return subArr;
    }

     /** Returns a single integer that represents the given array. This integer is sometimes 
     *  referred to as the array's "hash code". Later in the course we'll explain what these 
     *  hash codes are used for. For now, simply implement the specification given below.
     *  The hash code is computed as: arr[0]*7^(n-1) + arr[1]*7^(n-2) + ... + arr[n-2]*7 + arr[n-1]
     *  where arr[i] is the i'th character of the array, and n is the array's length.
     *  The hash value of an empty array is zero.
     */
    public static long hashCode(char[] arr) {
        int hashC = 0;
        // we just return 0 if arr is empty
        if (arr.length == 0) return hashC;
        // we iterate over the array
        for (int i = 0; i < arr.length; i++) {
            // the formula to get the hashCode 
            hashC += arr[i]*Math.pow(7, arr.length-i-1);
        }
        return hashC;
    }

    /**
     * Compares the two strings lexicographically.
     * Assume that both strings are not empty.
     * 
     * Characters are compared one by one from left to right, using their numeric Unicode values,
        as follows:
     * 1. If two characters at the same position in both strings are different,
     *    the string with the smaller character is considered lexicographically smaller.
     * 2. If all characters in the shorter string match the corresponding characters
     *    in the longer string, the shorter string is considered lexicographically smaller.
     * 3. If both strings have the same characters and the same length, they are considered equal.
     * 
     * Examples:
     * - "apple" is less than "banana" because 'a' comes before 'b'.
     * - "abc" is less than "abcd" because it is shorter.
     * - "hello" is equal to "hello".
     * - "date" is greater than "dark" because 't' comes after 'k'.
     * 
     * @param str1 the first string to compare
     * @param str2 the second string to compare
     * @return -1 if str1 is lexicographically less than str2,
     *         zero if they are equal, and 1 if str1 is
     *         lexicographically greater than str2.
     *         return -2 if there is an error with the input.
     */
    public static int compareTo(String str1, String str2) {
        if (str1.length() > str2.length()){
            for (int i = 0; i < str2.length(); i++) {
                // We have two character vars to make it more readable
                // then we compare the two if the first is smaller then the second
                // it means the first string is lexicographically less than the second.

                // If the first var is greater it means the opposite
                // that the first one is greater than the second.

                // as str1 is greater in length if we exited we return 1 by the rules
                char curr1 = str1.charAt(i);
                char curr2 = str2.charAt(i);
                if (curr1 < curr2) return -1;
                else if(curr1 > curr2) return 1;
            }
            return 1;
        }else if (str1.length() < str2.length()){
            for (int i = 0; i < str1.length(); i++) {
                // we do the same operation as above but if it exited the loop
                // as str1 is smaller in length than str2, that means
                // str1 is lexicographically less than str2 thus we return -1
                char curr1 = str1.charAt(i);
                char curr2 = str2.charAt(i);
                if (curr1 < curr2) return -1;
                else if(curr1 > curr2) return 1;
            }
            return -1;
        }
        // if it got here that means both are equal in length
        for (int i = 0; i < str1.length(); i++) {
            // we do the same operations as we did above but if it exited the loop
            // without returning it means they are equal
            char curr1 = str1.charAt(i);
            char curr2 = str2.charAt(i);
            if (curr1 < curr2) return -1;
            else if(curr1 > curr2) return 1;
        }

        return 0;
    }
}
