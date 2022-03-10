import java.util.concurrent.ThreadLocalRandom;
public class RandomNumbers_Same_One_Array {

    public static int randomInRange(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
    /*created 2 data structures - a linked list that each node holds in his data cell a unique number, and an array that holds
    a pointer to a node in the list
    */
    public static void get_Random_numbers(int min, int max) {
        int size = max - min +1;   //the range between the given integers - is the data in the cells.
        /* result array that holds the shuffled array*/
        if(max<min)
            throw new RuntimeException("min can not be bigger than max");
        int[] result = new int [size];  //results array - holds the shuffled array
        int[] numbers = new int [size];
        int data=min;
        for( int i = 0; i<size; i++) {
            numbers[i] = data;
            data++;
        }  // an array that holds all numbers between the numbers given.

        int idx_from_random =-1;
        int arr_idx = 0;
        int len = numbers.length;
        while(arr_idx< numbers.length) {
            idx_from_random = randomInRange(0, len-1); //gets the index of the cell that needs to be swapped
            int temp = numbers[len-1];
            numbers[len-1]= numbers[idx_from_random];
            if(temp!= numbers[idx_from_random])
                numbers[idx_from_random]=temp;
            arr_idx++;
            len--;
        }
        for(int i=0;i<numbers.length;i++)
            System.out.println(numbers[i]);
    }
}