package leetcode;

/**
 * Created by amit.bhengra on 15/09/18.
 *
 * https://leetcode.com/problems/robot-return-to-origin/description/
 */
public class RobotReturnToOrigin {

    public boolean judgeCircle(String moves) {
        if(moves == null || moves.length() == 0)
            return true;
        char[] chArr = moves.toCharArray();
        int x=0,y=0;
        for(int i = 0; i< moves.length() ; i++){
            if(chArr[i] == 'U')
                y++;
            if(chArr[i] == 'D')
                y--;
            if(chArr[i] == 'L')
                x--;
            if(chArr[i] == 'R')
                x++;
        }

        if(x==0 && y ==0)
            return true;
        return false;
    }
}
