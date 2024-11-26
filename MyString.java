public class MyString {
    public static void main(String[] args) {
        System.out.println("Testing lowercase:");
        System.out.println("UnHappy : " + lowerCase("UnHappy"));
        System.out.println("This costs 15 Sheksls : " + lowerCase("This costs 15 Sheksls"));
        System.out.println("TLV : " + lowerCase("TLV"));
        System.out.println("lowercase : " + lowerCase("lowercase"));

        System.out.println("Testing contains:");
        System.out.println(contains("unhappy", "happy")); // true
        System.out.println(contains("happy", "unhappy")); // false
        System.out.println(contains("historical", "story")); // false
        System.out.println(contains("psychology", "psycho")); // true
        System.out.println(contains("personality", "son")); // true
        System.out.println(contains("personality", "dad")); // false
        System.out.println(contains("resignation", "sign")); // true
    }

    /** Returns the lowercase version of the given string. */
    public static String lowerCase(String str) {
        String strLower = "";
        for (int i = 0; i < str.length(); i++) {
            char curr1 = str.charAt(i);
            if (curr1 >= 'A' && curr1 <= 'Z') {
                // using ascii value manipulation
                strLower += (char) (curr1 + 32);
            }else {
                // some char that is not a letter  or lowerCase already
                strLower += curr1; 
            }
        }
    
        return strLower;
    }

    /** If str1 contains str2, returns true; otherwise returns false. */
    public static boolean contains(String str1, String str2) {
        // we iterate from the beginning to the end of str1
        // but as we need to check for a string of the str2 length
        // we cut our iteration short by str2's length
        for (int i = 0; i < str1.length() - str2.length() + 1; i++) {
            // we compare the substring of length str2 in each location
            // from beginning to end to str2
            if (str1.substring(i, i + str2.length()).equals(str2)) {
                return true;
            }
        }
        return false;
    }
}
