import sun.misc.BASE64Encoder;

import java.io.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by amit.bhengra on 30/01/17.
 */
public class ThreeStages {

    public static void main(String[] args) throws Exception {
        //reading from file
        String inputFileName = "/Users/amit.bhengra/Downloads/test/amit/input";//args[1];
        String outputFileName = "/Users/amit.bhengra/Downloads/test/amit/output";//args[2];
        BufferedReader br = null;
        FileReader fr = null;
        List<Future> futures = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        try {

            fr = new FileReader(inputFileName);
            br = new BufferedReader(fr);
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                final String tempString = sCurrentLine;
                Future<Void> allStages = executorService.submit(new Callable<Void>() {
                    @Override
                    public Void call() throws Exception {
                        Future<String> firstStage = executorService.submit(new FirstStage(tempString));
                        Future<Object> secondStage = executorService.submit(new SecondStage(firstStage.get()));
                        Future<Void> thirdStage = executorService.submit(new ThirdStage(outputFileName,secondStage.get()));
                        thirdStage.get();
                        return null;
                    }
                });
                futures.add(allStages);
                Thread.sleep(1000);
            }
            for (Future future: futures){
                future.get();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return;
    }

    static class FirstStage implements Callable<String>{

        String input;

        public FirstStage(String input) {
            this.input = input;
        }

        @Override
        public String call() throws Exception {
            if (isValidString(input) )
                return new StringBuilder(input).reverse().toString();

            return null;
        }
    }

    static class SecondStage implements Callable<Object>{

        String input;

        public SecondStage(String input){
            this.input = input;
        }
        @Override
        public Object call() throws Exception {
            if(isValidString(input)){
                return Base64.getEncoder().encode(input.getBytes());
            }

            return null;
        }
    }

    static class ThirdStage implements Callable<Void>{

        Object object;
        String fileName;
        public ThirdStage(String fileName,Object object){
            this.object = object;
            this.fileName = fileName;
        }
        @Override
        public Void call() throws Exception {
            writeToAFile(fileName, object);
            return null;
        }
    }

    public static boolean isValidString(String input){
        if(input!=null && !input.isEmpty())
            return true;
        else
            return false;
    }

    public static void writeToAFile(String fileName,Object object) throws Exception {
        PrintWriter writer = new PrintWriter(new FileOutputStream( new File(fileName), true));
        writer.print(object);
        writer.println();
        writer.close();
    }

}
