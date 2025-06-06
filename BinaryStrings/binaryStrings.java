package BinaryStrings;

public class binaryStrings {
    public static void generateBits(int[] A, int index) {
       if(index == A.length){
        for (int i : A) {
            System.out.print(i);
        }
        System.out.println();
        return;
       }
       A[index] = 0;
       generateBits(A, index+1);
       A[index] = 1;
       generateBits(A, index+1);
    }

    public static void main(String[] args) {
        int n = 3; // You can change this value
        int[] A = new int[n];
        generateBits(A, 0);
    }
}
