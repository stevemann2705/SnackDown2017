import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Eaters {

	public static void main(String[] args) {
		Scanner i = new Scanner(System.in);
		
		int times = i.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		for (int z = 0; z < times; z++) {
			int numberofelements = i.nextInt();
			int queries = i.nextInt();
			int[] query = new int[queries];
			int[] outputs = new int[queries];
			int ele[] = new int[numberofelements];
			for (int a = 0; a < numberofelements; a++) {
				ele[a] = i.nextInt();
			}
			int a = 0;
			for (; a < queries; a++) {
				query[a] = i.nextInt();

				int[] temp = new int[numberofelements];
				for (int b = 0; b < numberofelements; b++) {
					temp[b] = ele[b];
				}
				Arrays.sort(temp);

				for (int b = 0; b < numberofelements; b++) {
					temp[b] = temp[b] + b;
					//System.out.println(temp[b]);
				}

				for (int b = 0; b < numberofelements; b++) {
					if (temp[b] >= query[a]) {
						outputs[a]++;
					}
				}
				list.add(outputs[a]);
			}
			
			
		}
		
		for(int a: list) {
			System.out.println(a);
		}

	}

}
