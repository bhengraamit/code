import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by amit.bhengra on 18/12/16.
 * https://www.hackerrank.com/contests/world-codesprint-8/challenges/climbing-the-leaderboard
 *
 */
public class ClimbingTheLeaderboard {
    public static void main(String[] args) throws IOException {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        Integer leadersNum = Integer.valueOf(bi.readLine());
        String scores = bi.readLine();
        int[] leaderScores = Arrays.asList(scores.split(" ")).stream().mapToInt(Integer::parseInt).toArray();
        Integer levels = Integer.valueOf(bi.readLine());
        String levelScores = bi.readLine();
        int[] scoresArr = Arrays.asList(levelScores.split(" ")).stream().mapToInt(Integer::parseInt).toArray();

        int[] ranks = mapRanks(leaderScores);

        int lastIndex = leadersNum-1 ;
        for (Integer levelScore : scoresArr){

            while (lastIndex>=0 && leaderScores[lastIndex]<=levelScore){
                lastIndex--;
            }

            if (lastIndex<0)
                System.out.println(1);
            else
                System.out.println(ranks[lastIndex]+1);


        }

    }

    private static int[] mapRanks(int[] leaderScores) {
        int[] ranks = new int[leaderScores.length];
        int prevScore = leaderScores[0];
        int prevRank = 1;
        int rankIndex = 0;
        for (Integer score: leaderScores){
            if (score == prevScore){
                ranks[rankIndex] = prevRank;
            }else {
                prevRank++;
                prevScore = score;
                ranks[rankIndex] = prevRank;
            }
            rankIndex++;
        }
        return ranks;
    }
}
