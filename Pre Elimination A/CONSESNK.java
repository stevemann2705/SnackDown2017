import java.util.Scanner;

public class CONSESNK {

	public static void main(String[] args) {
		Scanner i = new Scanner(System.in);

		int t = i.nextInt();
		int n = 0, l, a, b;
		int res[] = new int[t];
		int[] arr = null, arr2 = null;
		for (int z = 0; z < t; z++) {
			int m = 0, count = 0;
			n = i.nextInt();
			l = i.nextInt();
			a = i.nextInt();
			b = i.nextInt();
			arr = new int[n];
			arr2 = new int[n];
			MyMergeSort1 mmsort = new MyMergeSort1();

			for (int y = 0; y < n; y++) {
				arr[y] = i.nextInt();
			}

			mmsort.sort(arr);

			for (int y = 0; y < n; y++) {
				arr2[y] = a + (l * y);
				// System.out.print(arr2[y]);
			}

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
			int theNumber = arr[idx];

			//System.out.println(theNumber);
			//System.out.println(idx);

			if (arr[idx] - ((idx) * l) >= a && (arr[idx] + ((n-idx)*l)) <=b) {
				m = (arr[idx] - ((idx) * l)) - arr2[0]; // 23 - 8 = 15
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
			
			for (int y = 0; y < n; y++) {
				count += Math.abs(arr[y] - arr2[y]);
			}

			res[z] = count;
		}

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
