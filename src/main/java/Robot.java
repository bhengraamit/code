import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by amit.bhengra on 21/12/16.
 */
public class Robot {

    public static void main(String[] args) throws IOException {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        String command = bi.readLine();
        char[] commandArr = command.toCharArray();
        Map<Integer,Integer> blocksMap = new HashMap<>();
        for (int i = 0; i<10;i++){
            blocksMap.put(i,0);
        }

        Map<Integer,Character> hexMap = new HashMap<>();
        hexMap.put(0,'0');
        hexMap.put(1,'1');
        hexMap.put(2,'2');
        hexMap.put(3,'3');
        hexMap.put(4,'4');
        hexMap.put(5,'5');
        hexMap.put(6,'6');
        hexMap.put(7,'7');
        hexMap.put(8,'8');
        hexMap.put(9,'9');
        hexMap.put(10,'A');
        hexMap.put(11,'B');
        hexMap.put(12,'C');
        hexMap.put(13,'D');
        hexMap.put(14,'E');
        hexMap.put(15,'F');

        int index = 0;
        while (index<commandArr.length){
            if(commandArr[index] == 'P'){
                index++;
                int count = 0;
                while(index <commandArr.length && commandArr[index]!='L'){
                    if (commandArr[index]=='P')
                        count = 0;
                    else if (commandArr[index] =='M')
                        count++;

                    index++;
                }
                if (commandArr[index] == 'L'){
                    blocksMap.put(count,blocksMap.get(count)+1);
                }
            }
            index++;
        }

        String finalString = "";
        for (int i =0; i < 10; i++){
            finalString += String.valueOf(hexMap.get(blocksMap.get(i)));
        }
        System.out.println(finalString);

    }
}
