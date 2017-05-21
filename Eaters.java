import java.io.*;

import java.util.*;

public class Eaters {
	
	
	
	static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
 
        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }
 
        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');
 
            if (neg)
                return -ret;
            return ret;
        }
 
        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }
 
        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
 
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
 
            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }
 
            if (neg)
                return -ret;
            return ret;
        }
 
        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
 
        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
 
        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
	
	
	
	
	
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		//Scanner to scan inputs
		//Scanner i = new Scanner(System.in);
		Reader i = new Reader();
		
		//Merge Sort for Sorting O(n log n)
		MyMergeSort mmsort = new MyMergeSort();
		
		//number of executions
		int times = 0;
		try {
			times = i.nextInt();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		//list to store output
		List<Integer> list = new ArrayList<Integer>();
		
		//initial loop, to run the whole program 'times' number of times
		for (int z = 0; z < times; z++) {
			int numberofelements = 0;
			try {
				numberofelements = i.nextInt();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			} // number of elements as input (N)
			int queries = 0;
			try {
				queries = i.nextInt();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			} // number of queries as input (Q)
			int[] query = new int[queries]; // array to store the the input queries
			int[] outputs = new int[queries]; // array to store result
			int ele[] = new int[numberofelements];  // array to store input elements 
			int[] temp = new int[numberofelements];
			for (int a = 0; a < numberofelements; a++) { //inputting the elements (L1, L2 ...... )
				try {
					ele[a] = i.nextInt();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
			}
			int a = 0;
			for (; a < queries; a++) { //loop to calculate as and when the query is given
				try {
					query[a] = i.nextInt();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				} //input query (K)
			}
			for (a=0; a < queries; a++) {
				
				System.arraycopy(ele, 0, temp, 0, numberofelements);//temp variable to copy elements of original array of elements
				/*for (int b = 0; b < numberofelements; b++) { // copying the elements
					temp[b] = ele[b];
				}*/
				
				mmsort.sort(temp); //merge sort

				L: for (int b = 0; b < numberofelements; b++) { // actual calculation
					temp[b] = temp[b] + b;
					if (temp[b] >= query[a]) {
						outputs[a] = numberofelements - b;
						break L;
					}
					//System.out.println(temp[b]);
				}
				

				list.add(outputs[a]); //adding output to the list
			}
		}
		
		
		for(int a: list) { // printing the list
			System.out.println(a);
		}
		long stopTime = System.currentTimeMillis();
	      long elapsedTime = stopTime - startTime;
	      System.out.println(elapsedTime);
	      
	      
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
