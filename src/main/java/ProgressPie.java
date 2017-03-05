import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ProgressPie {
    public static void main(String[] args) throws IOException {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.valueOf(bi.readLine());
        int centerX = 50;
        int centerY = 50;
        int counter = 1;
        while (testCases-- >0){
            String input = bi.readLine();
            String[] inputs = input.split(" ");
            int perc = Integer.valueOf(inputs[0]);
            int x = Integer.valueOf(inputs[1]);
            int y = Integer.valueOf(inputs[2]);

            double degrees = getDegreesFromPoints(centerX,centerY,x,y);
            double percDegree = perc * (360.0/100);
            if (degrees <= percDegree){
                double length = findLength(centerX,centerY,x,y);
                if (length <= 50.000006)
                    System.out.println("Case #"+counter+": black");
                else
                    System.out.println("Case #"+counter+": white");

            }else {
                System.out.println("Case #"+counter+": white");
            }
            counter++;
        }
    }

    private static double findLength(int centerX, int centerY, int x, int y) {
        return Math.sqrt(Math.pow(Math.abs(centerX-x),2) + Math.pow(Math.abs(centerY-y),2));
    }

    private static Double getDegreesFromPoints(int centerX, int centerY, int x, int y) {
        double degree = Math.toDegrees(Math.atan2(Math.abs(centerY-y),Math.abs(centerX-x)));
        //check for which quadrant it falls to

        if (x>=50 && y>=50){
            // first quadrant
            return 90.0 - degree;
        }else if (x>=50 && y<50){
            // second quadrant
            return 90.0 + degree;
        }else if (x<50 && y<=50){
            // third quadrant
            return 270.0 - degree;

        }else if (x<50 && y>50){
            // fourth quadrant
            return 270.0 + degree;
        }
        return null;
    }
}
