import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        // 우선순위 [작업 번호, 요청 시각, 작업 소요 시간] 순으로 정렬
        Queue<int[]> q = new PriorityQueue<>(
            (o1, o2) -> {
                if(o1[2]==o2[2]){
                    if(o1[1]==o2[1]){
                        return o1[0]-o2[0];
                    }else{
                        return o1[1]-o2[1];
                    }
                }else{
                    return o1[2]-o2[2];
                }
            }
        );
        int time=0;
        int returnTime=0;
        int jobs_count=0;
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));
        while(true){
            // 대기 큐에 작업 번호를 추가해서 담기
            int[] job;
            // 추가
            
            while(jobs_count<jobs.length && jobs[jobs_count][0]==time){
                job = new int[]{jobs_count, jobs[jobs_count][0], jobs[jobs_count][1]};
                q.add(job);
                jobs_count++;
            }
            // 작업 담기
            if(time>=returnTime && !q.isEmpty()){
                int[] temp = q.poll();
                if(returnTime<temp[1]) returnTime+=temp[1]-returnTime;
                returnTime += temp[2];
                answer+=returnTime-temp[1];
            }
            if(jobs_count==jobs.length && q.isEmpty()) break;
            time++;
        }
        answer = answer/jobs.length;
        return answer;
    }
}