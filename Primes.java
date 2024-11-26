public class Primes {
    public static void main(String[] args) {
        int lastN = Integer.parseInt(args[0]);
        boolean[] arr = new boolean[lastN + 1];
        
        // Initialize all entries as true. A value in arr[i] will 
        // finally be false if i is not a prime, else true.
        for (int i = 2; i <= lastN; i++) {
            arr[i] = true;
        }

        for (int p = 2; p * p <= lastN; p++) {
            // If arr[p] is not changed, then it is a prime
            if (arr[p] == true) {
                // Update all multiples of p
                for (int i = p * p; i <= lastN; i += p) {
                    arr[i] = false;
                }
            }
        }

        // Print all prime numbers
        int count = 0;
        System.out.println("Prime numbers up to " + lastN + ":");
        for (int i = 2; i <= lastN; i++) {
            if (arr[i] == true) {
                System.out.println(i);
                count++;
            }
        }
        System.out.println("There are " + count + " primes between 2 and " + lastN + " (" + count*100/lastN + "% are primes)");
    }
}