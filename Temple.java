import java.util.Scanner;

public class Temple {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int times = in.nextInt();
		String[] outputs = new String[times];

		for (int z = 0; z < times; z++) {
			StringBuilder temp = new StringBuilder();
			StringBuilder temp2 = new StringBuilder();
			int len = in.nextInt();

			int[] inp = new int[len];

			for (int a = 0; a < len; a++) {
				inp[a] = in.nextInt();
			}

			for (int a = 0; a < len; a++) {
				temp2.append(inp[a] + " ");
			}

			int n = len - (len / 2);
			int i = n;

			for (int j = 1; j <= i; j++)
				temp.append(j + " ");
			for (int j = i - 1; j >= 1; j--)
				temp.append(j + " ");

			if (len % 2 == 0) {
				outputs[z] = "No";
				continue;
			} else {
				if (temp.toString().equals(temp2.toString())) {
					outputs[z] = "Yes";
				} else {
					outputs[z] = "No";
				}
			}
		}
		for (int z = 0; z < times; z++) {
			System.out.println(outputs[z]);
		}
	}

}
