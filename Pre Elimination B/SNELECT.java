import java.util.Scanner;

public class SNELECT {

	public static void main(String[] args) {
		Scanner i = new Scanner(System.in);
		int t = i.nextInt();

		String[] res = new String[t];

		for (int testcase = 0; testcase < t; testcase++) {
			String str = i.next();
			char[] arr = str.toCharArray();
			char[][] arr1 = new char[2][str.length()];
			arr1[0] = arr;
			for (int mm = 0; mm < str.length(); mm++) {
				if (arr1[0][mm] == 's') {
					arr1[1][mm] = 'n';
				} else if (arr1[0][mm] == 'm') {
					arr1[1][mm] = 'm';
				}
			}
			int len = arr.length;
			int s = 0, m = 0, c = 0;

			L: for (int a = 0; a < len; a++) {
				if (arr1[0][a] == 's') {
					s++;

				} else if (arr1[0][a] == 'm') {
					m++;

					if (a - 1 >= 0 && arr1[0][a - 1] == 's') {
						if (arr1[1][a - 1] != 'e') {
							s--;
							arr1[1][a - 1] = 'e';
						}
						// continue L;
					} else if (a + 1 < len && arr1[0][a + 1] == 's') {
						if (arr1[1][a + 1] != 'e') {
							s--;
							arr1[1][a + 1] = 'e';
							// continue L;
						}
					}
				}

			}
			c = s - m;
			System.out.println("snakes: " + s);
			System.out.println("mongooses: " + m);
			if (c < 0) {
				res[testcase] = "mongooses";
			} else if (c > 0) {
				res[testcase] = "snakes";
			} else if (c == 0) {
				res[testcase] = "tie";
			}

		}

		for (String r : res) {
			System.out.println(r);
		}
		i.close();
	}
}
