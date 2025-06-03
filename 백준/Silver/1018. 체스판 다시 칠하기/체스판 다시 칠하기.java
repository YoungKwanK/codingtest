
import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// N, M 받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// N * M의 보드의 각 상태 받기
		char [][] board = new char[N][M]; // 보드판 생성
		// 2중 for문으로 board 채우기
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String temp=st.nextToken();
			for(int j=0; j<M; j++) {
				board[i][j] = temp.charAt(j);
			}
		}
		
		// 완전 탐색 : 이중for문으로 해당 인덱스의 좌표를 찍어 board 함수에 좌표를 전송하고 바꿔야하는 개수를 받음
		int min=64;
		for(int i=0; i<=N-8; i++) {
			for(int j=0; j<=M-8; j++) {
				int temp = searchBoard(i, j, board);
				if(min > temp) {
					min = temp;
				}
			}
		}
		System.out.println(min);
		
	}
	// 해당 좌표가 들어올 때 8*8만큼 오른쪽에서 아래로 보드판을 탐색하여 바꿔야 하는 문자를 찾음
	public static int searchBoard(int x, int y, char[][] board) {
		// 바꿔야하는 타일 수를 저장할 result 변수 선언
		int result=0;
		// 경우의 수 2가지 : 첫타일이 검은색일 때, 하얀색일 때
		int count_B=0;
		int count_W=0;
		// 이중 for문으로 8*8 탐색
		for(int i=x; i<x+8; i++) {
			for(int j=y; j<y+8; j++) {
				// i+j가 짝수이면 시작 타일과 같은 색, 홀수이면 다른 색
				if((i+j)%2==0) {
					if(board[i][j]!='B') count_B++;
					if(board[i][j]!='W') count_W++;
				}
				else {
					if(board[i][j]!='W') count_B++;
					if(board[i][j]!='B') count_W++;
				}
			}
			if(count_B>count_W) {
				result=count_W;
			}
			else result=count_B;
		}
		
		return result;
	}
	
	
}
