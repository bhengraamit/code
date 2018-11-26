package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by amit.bhengra on 15/09/18.
 *
 * https://leetcode.com/problems/exclusive-time-of-functions/description/
 *
 * Question is not clear so resulted in this way of implementation could be better according to
 *
 * https://leetcode.com/problems/exclusive-time-of-functions/solution/
 */
public class ExclusiveTimeOfFunctions {

    public static void main(String[] args) {
        ExclusiveTimeOfFunctions exclusiveTimeOfFunctions = new ExclusiveTimeOfFunctions();
        String[] logsStr = {"0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"};
        List<String> strings = Arrays.asList(logsStr);
        exclusiveTimeOfFunctions.exclusiveTime(1,strings);
    }

    public class Log{
        int fid;
        String event;
        int ts;
    }
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        if(logs == null || logs.size() == 0)
            return result;
        Stack<Log> logStack = new Stack<>();
        Stack<Log> timeStack = new Stack<>();
        int i=0;
        while(i<logs.size()){
            String logstr = logs.get(i);
            Log log = parseLog(logstr);
            if("end".equals(log.event)){
                Log pop = logStack.pop();
                calTime(timeStack,log,result);
            }else{
                logStack.push(log);
                timeStack.push(log);
            }
            i++;
        }
        return result;
    }


    public void calTime(Stack<Log> timeStack,Log end,int[] result){
        int sum = 0;
        while(!(timeStack.peek().fid==end.fid && timeStack.peek().event.equals("start"))){
            Log pop = timeStack.pop();
            sum += pop.ts;
        }
        Log start = timeStack.pop();
        Log newTs = new Log();
        newTs.fid = start.fid;
        newTs.ts = end.ts - start.ts +1;
        newTs.event = "over";
        timeStack.push(newTs);
        int totalTime = end.ts - start.ts - sum + 1;
        result[start.fid] += totalTime;
    }

    public Log parseLog(String logstr){
        String[] parsed = logstr.split(":");
        Log log = new Log();
        log.fid = Integer.valueOf(parsed[0]);
        log.event = parsed[1];
        log.ts = Integer.valueOf(parsed[2]);
        return log;
    }
}

