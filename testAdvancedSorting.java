
import java.util.*;

public class testAdvancedSorting {

    public static int[] RandomIntegers(int size) {

        int[] arr = new int[size];

        for (int i = 0; i < arr.length; i++) {

            // Generate random int between 1 and size
            int rand = 1 + (int) (Math.random() * (size));
            arr[i] = rand;
        }

        return arr;

    }


    public static int[] IncreasingIntegers(int size) {

        int[] arr = new int[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        return arr;
    }

    public static int[] DecreasingIntegers(int size) {

        int[] arr = new int[size];

        for (int i = 0, j = size; i < arr.length; i++, j--) {
            arr[i] = j;
        }

        return arr;
    }


    public static void main(String[] args) {

        // Declare small arrays
        int[] thousandRand = new int[1000];
        int[] thousandInc = new int[1000];
        int[] thousandDec = new int[1000];

        // Declare 10000 arrays
        int[] tenRand = new int[10000];
        int[] tenInc = new int[10000];
        int[] tenDec = new int[10000];

        // Declare 100000 arrays
        int[] hundRand = new int[100000];
        int[] hundInc = new int[100000];
        int[] hundDec = new int[100000];

        // Declare 1000000 arrays
        int[] milRand = new int[1000000];
        int[] milInc = new int[1000000];
        int[] milDec = new int[1000000];


        Scanner input = new Scanner(System.in);
        int selection = 0;

        int[][] comparisons = new int[9][4];

        while (selection != 4) {

            // Print user menu while exit option not selected

            System.out.println("\n---------------MAIN MENU---------------\n" +
                    "1. Populate Arrays\n" +
                    "2. Run Algorithms\n" +
                    "3. Display outputs\n" +
                    "4. Exit program\n" +
                    " Enter option number:\n");

            selection = input.nextInt();
            input.nextLine();

            if (selection == 1) {

                // Populate 1000 arrays
                thousandRand = RandomIntegers(1000);
                thousandInc = IncreasingIntegers(1000);
                thousandDec = DecreasingIntegers(1000);

                // Populate 10000 arrays
                tenRand = RandomIntegers(10000);
                tenInc = IncreasingIntegers(10000);
                tenDec = DecreasingIntegers(10000);

                // Populate 100000 arrays
                hundRand = RandomIntegers(100000);
                hundInc = IncreasingIntegers(100000);
                hundDec = DecreasingIntegers(100000);

                // Populate 1000000
                milRand = RandomIntegers(1000000);
                milInc = IncreasingIntegers(1000000);
                milDec = DecreasingIntegers(1000000);

            } else if (selection == 2) {

                Mergesort merge = new Mergesort();
                Quicksort quick = new Quicksort();
                Heapsort heap = new Heapsort();

                // Random arrays sort
                try {
                    comparisons[0][0] = merge.sort(thousandRand.clone());
                    comparisons[0][1] = merge.sort(tenRand.clone());
                    //comparisons[0][2] = merge.sort(hundRand.clone());
                    //comparisons[0][3] = merge.sort(milRand.clone());


                    comparisons[1][0] = quick.sort(thousandRand.clone());
                    comparisons[1][1] = quick.sort(tenRand.clone());
                    //comparisons[1][2] = quick.sort(hundRand.clone());
                    //comparisons[1][3] = quick.sort(milRand.clone());

                    comparisons[2][0] = heap.sort(thousandRand.clone());
                    //comparisons[2][1] = heap.sort(tenRand.clone());
                    //comparisons[2][2] = heap.sort(hundRand.clone());
                    //comparisons[2][3] = heap.sort(milRand.clone());


                    // Increasing arrays sort

                    comparisons[3][0] = merge.sort(thousandInc.clone());
                    //comparisons[3][1] = merge.sort(tenInc.clone());
                    //comparisons[3][2] = merge.sort(hundInc.clone());
                    //comparisons[3][3] = merge.sort(milInc.clone());

                    comparisons[4][0] = quick.sort(thousandInc.clone());
                    comparisons[4][1] = quick.sort(tenInc.clone());
                    //comparisons[4][2] = quick.sort(hundInc.clone());
                    //comparisons[4][3] = quick.sort(milInc.clone());

                    comparisons[5][0] = heap.sort(thousandInc.clone());
                    //comparisons[5][1] = heap.sort(tenInc.clone());
                    //comparisons[5][2] = heap.sort(hundInc.clone());
                    //comparisons[5][3] = heap.sort(milInc.clone());

                    // Decreasing arrays sort

                    comparisons[6][0] = merge.sort(thousandDec.clone());
                    //comparisons[6][1] = merge.sort(tenDec.clone());
                    //comparisons[6][2] = merge.sort(hundDec.clone());
                    //comparisons[6][3] = merge.sort(milDec.clone());

                    comparisons[7][0] = quick.sort(thousandDec.clone());
                    comparisons[7][1] = quick.sort(tenDec.clone());
                    //comparisons[7][2] = quick.sort(hundDec.clone());
                    //comparisons[7][3] = quick.sort(milDec.clone());

                    comparisons[8][0] = heap.sort(thousandDec.clone());
                    //comparisons[8][1] = heap.sort(tenDec.clone());
                    //comparisons[8][2] = heap.sort(hundDec.clone());
                    //comparisons[8][3] = heap.sort(milDec.clone());

                } catch(StackOverflowError e) {
                    System.out.println("-----STACK_OVERFLOW_ERROR-----");
                }


            } else if (selection == 3) {

                // Print Random sorts

                System.out.println("\nArray Type: Random\n" +
                        "Algorithm      n=1000    n=10000    n=100000    n=1000000\n" +
                        "----------------------------------------------------------");


                System.out.print("Mergesort");
                System.out.printf("%11d", comparisons[0][0]);
                System.out.printf("%12d", comparisons[0][1]);
                System.out.printf("%12d", comparisons[0][2]);
                System.out.printf("%12d\n", comparisons[0][3]);


                System.out.print("Quicksort");
                System.out.printf("%11d", comparisons[1][0]);
                System.out.printf("%12d", comparisons[1][1]);
                System.out.printf("%12d", comparisons[1][2]);
                System.out.printf("%12d\n", comparisons[1][3]);


                System.out.print("Heapsort");
                System.out.printf("%12d", comparisons[2][0]);
                System.out.printf("%12d", comparisons[2][1]);
                System.out.printf("%12d", comparisons[2][2]);
                System.out.printf("%12d\n", comparisons[2][3]);

                // Print Increasing sorts

                System.out.println("\nArray Type: Increasing\n" +
                        "Algorithm      n=1000    n=10000    n=100000    n=1000000\n" +
                        "----------------------------------------------------------");

                System.out.print("Mergesort");
                System.out.printf("%11d", comparisons[3][0]);
                System.out.printf("%12d", comparisons[3][1]);
                System.out.printf("%12d", comparisons[3][2]);
                System.out.printf("%12d\n", comparisons[3][3]);

                System.out.print("Quicksort");
                System.out.printf("%11d", comparisons[4][0]);
                System.out.printf("%12d", comparisons[4][1]);
                System.out.printf("%12d", comparisons[4][2]);
                System.out.printf("%12d\n", comparisons[4][3]);


                System.out.print("Heapsort");
                System.out.printf("%12d", comparisons[5][0]);
                System.out.printf("%12d", comparisons[5][1]);
                System.out.printf("%12d", comparisons[5][2]);
                System.out.printf("%12d\n", comparisons[5][3]);

                // Print decreasing sorts

                System.out.println("\nArray Type: Decreasing\n" +
                        "Algorithm      n=1000    n=10000    n=100000    n=1000000\n" +
                        "----------------------------------------------------------");

                System.out.print("Mergesort");
                System.out.printf("%11d", comparisons[6][0]);
                System.out.printf("%12d", comparisons[6][1]);
                System.out.printf("%12d", comparisons[6][2]);
                System.out.printf("%12d\n", comparisons[6][3]);

                System.out.print("Quicksort");
                System.out.printf("%11d", comparisons[7][0]);
                System.out.printf("%12d", comparisons[7][1]);
                System.out.printf("%12d", comparisons[7][2]);
                System.out.printf("%12d\n", comparisons[7][3]);


                System.out.print("Heapsort");
                System.out.printf("%12d", comparisons[8][0]);
                System.out.printf("%12d", comparisons[8][1]);
                System.out.printf("%12d", comparisons[8][2]);
                System.out.printf("%12d\n", comparisons[8][3]);


            }
        }
    }


}
