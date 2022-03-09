import java.util.concurrent.ThreadLocalRandom;

public class Random_numbers_prev_version {

    public static int randomInRange(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
    /*created 2 data structures - a linked list that each node holds in his data cell a unique number, and an array that holds
    a pointer to a node in the list
    */
    public static void get_Random_numbers(int min, int max) {
        int size = max - min +1;   //the range between the given integers - is the data in the cells.
        /* result array that holds the shuffled array*/
        int[] result = new int [size];
        if(max<min)
            throw new RuntimeException("min can not be bigger than max");
        DoublyLinkedList.Node[] numbers = new DoublyLinkedList.Node[size]; //double linked list
        DoublyLinkedList nodes_list = new DoublyLinkedList();
        int data=min;
        for( int i = 0; i<size; i++) {
            DoublyLinkedList.Node n  = nodes_list.addNode(data);
            numbers[i] = n;
            data++;
        }// each cell in the array holds a pointer to a relevant node
        // -at start each node's data holds number that is a sum of (index+1)

        int index;
        int arr_idx = 0;
        int size_of_nodes_list =  nodes_list.size;
        while(arr_idx< numbers.length) {
            index = randomInRange(0, size_of_nodes_list-1);
            DoublyLinkedList.Node to_delete =numbers[index];
            result[arr_idx]= numbers[index].data;
            if(index!=size_of_nodes_list)
                numbers[index]=numbers[size_of_nodes_list-1] ;

            arr_idx++;
            size_of_nodes_list--;
        }
//        for(int i=0;i<result.length;i++)
//            System.out.println(result[i]);
    }
}
