import java.util.*;
import java.io.*;
public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 책의 개수 N 받기
		int N = Integer.parseInt(br.readLine());
		
		// 제목과 팔린 개수를 담을 Map 선언
		Map<String, Integer> books = new HashMap<>();
		
		// 책 제목 받기
		for(int i=0; i<N; i++) {
			String book = br.readLine();
			books.put(book, books.getOrDefault(book, 0)+1);
		}
		
		// 가장 많이 팔린 책 구하기
		// 가장 많이 팔린 책을 저장할 변수 선언
		String bestBook = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
		// 가장 많이 팔린 책 수를 저장할 변수 선언
		int maxCount = Integer.MIN_VALUE;
		for(String book : books.keySet()) {
			if(maxCount<books.get(book)) {
				bestBook = book;
				maxCount=books.get(book);
			}
			else if(maxCount==books.get(book)&&bestBook.compareTo(book)>0) {
				bestBook = book;
				maxCount=books.get(book);
			}
		}
		System.out.println(bestBook);
	}
	
}
