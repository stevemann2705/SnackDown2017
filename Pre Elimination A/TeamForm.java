import java.util.*;


public class TeamForm {

	public static void main(String[] args) {
		Scanner i = new Scanner(System.in);
		int tests = i.nextInt();
		int n,m;
		int[][] arr;
		List<String> l = new ArrayList<String>();
		
		for(int a =0; a<tests; a++) {
			n = i.nextInt();
			m = i.nextInt();
			arr = new int[m][2];
			for(int b=0; b<m; b++) {
				arr[b][0] = i.nextInt();
				arr[b][1] = i.nextInt();
			}
			if((n%2)!=0) {
				l.add("no");
			}else {
				l.add("yes");
			}
		}
		for(String a: l) {
			System.out.println(a);
		}
	}

}
