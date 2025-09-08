package org.example;

public class App {
    public static void main(String[] args) {
        Hofstadter hofstadter = new Hofstadter();

        System.out.println("First 12 terms of Hofstadter G-sequence:");
        for (int i = 0; i < 12; i++) {
            System.out.print(hofstadter.gSequence(i) + " ");
        }
        System.out.println();

        int n = 10;
        int naiveVal = hofstadter.gSequence(n);
        int memoVal = hofstadter.gSequenceMemo(n);

        System.out.printf("G(%d) [naive] = %d%n", n, naiveVal);
        System.out.printf("G(%d) [memoized] = %d%n", n, memoVal);
    }
}
