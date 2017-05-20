import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Eaters {

	public static void main(String[] args) {
		
		//Scanner to scan inputs
		Scanner i = new Scanner(System.in);
		
		//Merge Sort for Sorting O(n log n)
		MyMergeSort mmsort = new MyMergeSort();
		
		//number of executions
		int times = i.nextInt();
		
		//list to store output
		List<Integer> list = new ArrayList<Integer>();
		
		//initial loop, to run the whole program 'times' number of times
		for (int z = 0; z < times; z++) {
			int numberofelements = i.nextInt(); // number of elements as input (N)
			int queries = i.nextInt(); // number of queries as input (Q)
			int[] query = new int[queries]; // array to store the the input queries
			int[] outputs = new int[queries]; // array to store result
			int ele[] = new int[numberofelements];  // array to store input elements 
			for (int a = 0; a < numberofelements; a++) { //inputting the elements (L1, L2 ...... )
				ele[a] = i.nextInt();
			}
			int a = 0;
			for (; a < queries; a++) { //loop to calculate as and when the query is given
				query[a] = i.nextInt(); //input query (K)

				int[] temp = new int[numberofelements]; //temp variable to copy elements of original array of elements
				for (int b = 0; b < numberofelements; b++) { // copying the elements
					temp[b] = ele[b];
				}
				mmsort.sort(temp); //merge sort

				for (int b = 0; b < numberofelements; b++) { // actual calculation
					temp[b] = temp[b] + b;
					if (temp[b] >= query[a]) {
						outputs[a]++;
					}
					//System.out.println(temp[b]);
				}

				list.add(outputs[a]); //adding output to the list
			}
			
			
		}
		
		for(int a: list) { // printing the list
			System.out.println(a);
		}
		
	}
	
	

}

class MyMergeSort { //merge sort, copied from the internet
    
    private int[] array;
    private int[] tempMergArr;
    private int length;
     
    public void sort(int inputArr[]) {
        this.array = inputArr;
        this.length = inputArr.length;
        this.tempMergArr = new int[length];
        doMergeSort(0, length - 1);
    }
 
    private void doMergeSort(int lowerIndex, int higherIndex) {
         
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            doMergeSort(lowerIndex, middle);
            // Below step sorts the right side of the array
            doMergeSort(middle + 1, higherIndex);
            // Now merge both sides
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }
 
    private void mergeParts(int lowerIndex, int middle, int higherIndex) {
 
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }
 
    }
}
