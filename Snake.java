//import java.io.IOException;
import java.util.*;

public class Snake {
	public static void main(String args[]) {
		Scanner i = new Scanner(System.in);
		int times = i.nextInt();
		String[] outputs = new String[times];
		for (int b = 0; b < times; b++) {
			outputs[b] = "Valid";
		}
		
		
		for (int b = 0; b < times; b++) {
			Stack<String> stack = new Stack<String>();
			int len;
			boolean flag = true;

			len = i.nextInt();

			String inp = "Valid";

			inp = i.next();

			if (inp.length() != len) {
				System.out.println("Error");
				System.exit(0);
			}
			char[] str = inp.toCharArray();

			T:for (int a = 0; a < len; a++) {
				if (str[a] == 'H' || str[a] == 'h') {
					try {
						if (stack.get(0) == "H" || stack.get(0) == "h") {
							outputs[b] = "Invalid";
							break T;
						}
					} catch (ArrayIndexOutOfBoundsException e) {

					}
					stack.push("H");
				} else if (str[a] == 'T' || str[a] == 't') {
					try {
						stack.pop();
					} catch (EmptyStackException e) {
						outputs[b] = "Invalid";
						break T;
						//System.exit(0);
					}
				} else if (str[a] == '.') {
					continue T;
				} else {
					System.out.println("Error, input not valid");
					break T;
					//System.exit(0);
				}
				if (stack.isEmpty()) {
					outputs[b] = "Valid";
				} else {
					outputs[b] = "Invalid";
				}
			}

			
		}
		for(int b = 0; b < times; b++) {
			System.out.println(outputs[b]);
		}
	}
}
