
import java.util.*;
import java.io.*;
public class Main{
	
	// 친구 관계 맵을 담을 그릇
	static List<Integer>[] frineds;
	static boolean[] visited;
	static Queue<Integer> q;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//유저의 수 N (2 ≤ N ≤ 100)과 친구 관계의 수 M (1 ≤ M ≤ 5,000)
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 초기 설정
		frineds = new List[N+1];
		for(int i=0; i<N+1; i++) {
			frineds[i]=new ArrayList<>();
		}
		
		// 친구 관계 넣기
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start=Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			// 이미 친구 관계가 있으면 추가 안함
			if(frineds[start].contains(end)) continue;
			// 양방향 연결
			frineds[start].add(end);
			frineds[end].add(start);
		}
		// 사람마다의 케빈 베이컨의 합 구하기
		int answer=1;
		int temp=Integer.MAX_VALUE;
		int sum;
		for(int i=1; i<N+1; i++) {
			sum=0;
			int[] count = new int[N+1];
			visited = new boolean[N+1];
			q=new LinkedList<>();
			q.add(i);
			visited[i]=true;
			while(!q.isEmpty()) {
				int start = q.poll();
				for(int j : frineds[start]) {
					if(!visited[j]) {
						q.add(j);
						visited[j]=true;
						count[j]=count[start]+1;
						sum+=count[j];
					}
				}
			}
			if(sum<temp) {
				temp=sum;
				answer=i;
			}
		}
		System.out.println(answer);
	}
}
