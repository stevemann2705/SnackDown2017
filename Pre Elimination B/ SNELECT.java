import java.util.Scanner;

public class SNELECT {

	public static void main(String[] args) {
		Scanner i = new Scanner(System.in);
		int t = i.nextInt();
		
		String[] res = new String[t];
		
		for(int testcase = 0; testcase < t; testcase++) {
			String str = i.next();
			char[] arr = str.toCharArray();
			int len = arr.length;
			int s = 0, m =0, c=0;
			
			//System.out.println(arr);
			L:for(int a=0; a<len; a++) {
				if(arr[a] == 's') {
					s++;
					//System.out.println("increment s");
					
				}else if(arr[a] == 'm') {
					m++;
					//System.out.println("increment m");
					if(a-1>=0 && arr[a-1] == 's') {
						s--;
						//System.out.println("decrement s");
						continue L;
					}else if(a+1<len && arr[a+1] == 's') {
						s--;
						//System.out.println("decrement s");
						continue L;
					}
				}
				
				
				
			}
			c = s-m;
			//System.out.println(c);
			if(c < 0) {
				res[testcase] = "mongooses";
			}
			else if(c > 0) {
				res[testcase] = "snakes";
			}
			else if(c == 0) {
				res[testcase] = "tie";
			}
			
		}

		for(String r: res) {
			System.out.println(r);
		}
	}

}
