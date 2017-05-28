import java.util.Scanner;

public class CONSESNK {

	public static void main(String[] args) {
		Scanner i = new Scanner(System.in);

		int t = i.nextInt(); // number of test cases
		int n = 0, l, a, b; // standard variables as mentioned in question
		int res[] = new int[t]; // array to store results
		int[] arr = null, arr2 = null; // arr is input array and arr2 is expected array
		
		/*
		We will calculate the expected array, which will involve least movements to satisfy all conditions and then 
		compare it with input array to calculate the number of movements.
		*/
		
		
		for (int z = 0; z < t; z++) { // loop for each test case
			int m = 0, count = 0; // m is temporary variable, count is the counter for distance count
			
			//Standard Inputs
			n = i.nextInt();
			l = i.nextInt();
			a = i.nextInt();
			b = i.nextInt();
			
			
			arr = new int[n];
			arr2 = new int[n];
			
			MyMergeSort1 mmsort = new MyMergeSort1(); // object for sorting

			for (int y = 0; y < n; y++) { //loop for input array
				arr[y] = i.nextInt();
			}

			mmsort.sort(arr); // sorting input array

			for (int y = 0; y < n; y++) { //initial expected array (starts from a and goes till the end of sequence for n snakes
				arr2[y] = a + (l * y);
				// System.out.print(arr2[y]);
			}

			//calculating the average of inputs and finding the element closest to the average
			int avg = (arr[n - 1] + arr[0]) / 2;
			int myNumber = avg;
			int distance = Math.abs(arr[0] - myNumber);
			int idx = 0;
			for (int c = 1; c < arr.length; c++) {
				int cdistance = Math.abs(arr[c] - myNumber);
				if (cdistance < distance) {
					idx = c;
					distance = cdistance;
				}
			}
			int theNumber = arr[idx]; //theNumber stores the element closest to average value of inputs, idx has its index

			//System.out.println(theNumber);
			//System.out.println(idx);

			//altering the expected array for different test cases to minimize distance
			if (arr[idx] - ((idx) * l) >= a && (arr[idx] + ((n-idx)*l)) <=b) {
				m = (arr[idx] - ((idx) * l)) - arr2[0]; 
				for (int y = 0; y < n; y++) {
					arr2[y] += m;
				}
			}
			else if((arr[idx] + ((n-idx)*l)) >=b) {
				m = (arr[idx] + (n-idx)*l) - b;
				int mm = arr[idx] - m;
				int kk = (mm - (idx*l)) - arr2[0];
				for (int y = 0; y < n; y++) {
					arr2[y] += kk;
				}
				System.out.println(arr2[0]);
			}
			else if((arr[idx] + ((idx)*l)) <=a) {
				//m = a - (arr[idx] + ((idx)*l));
				//arr[idx] += m;
				//m = (arr[idx] - ((idx) * l)) - arr2[0];
			}
			
			//calculating the distance
			for (int y = 0; y < n; y++) {
				count += Math.abs(arr[y] - arr2[y]);
			}
			
			//storing result in array
			res[z] = count;
		}

		//outputting result
		for (int z = 0; z < t; z++) {
			System.out.println(res[z]);
		}

	}

}

class MyMergeSort1 { // merge sort, copied from the internet

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
