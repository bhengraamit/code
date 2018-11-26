//package leetcode;
//
///**
// * Created by amit.bhengra on 24/08/18.
// *
// * https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/description/
// */
//public class Read4 {
//
//   /* The read4 API is defined in the parent class Reader4.
//      int read4(char[] buf); */
//
//    public class Solution extends Reader4 {
//        /**
//         * @param buf Destination buffer
//         * @param n   Maximum number of characters to read
//         * @return    The number of characters read
//         */
//        int logicalPointer = 0;
//        int totalRead = 0;
//        int actualPointer = 0;
//        char[] currentBuff = new char[4];
//        char[] file = null;
//        int buffSize = 4;
//        public int read(char[] buf, int n) {
//            if(file == null)
//                file = buf;
//            if(logicalPointer + n <= totalRead){
//                char[] retChar = readChars(logicalPointer,logicalPointer+n,currentBuff);
//                logicalPointer += logicalPointer+n;
//                return retChar;
//            }
//            // if more read is required.
//            char[] retChar = readMore(buf,n);
//        }
//
//        public char[] readMore(char[] buf, int n){
//            int extraSize = n - (totalRead - logicalPointer);
//            int readTimes = 0;
//            int div = extraSize / buffSize;
//            int rem = extraSize % buffSize;
//            readTimes = div + rem > 0 ? 1:0;
//            char[] currentRead = new char[readTimes*buffSize];
//            int startPoint = 0;
//            char[] fourChar = null;
//            for(int i=0;i<readTimes;i++){
//                fourChar = read4(buf);
//                copyChar(fourChar,currentRead,startPoint);
//                startPoint += buffSize;
//            }
//            char[] currentBuffChar = readChars(logicalPointer,totalRead,currentBuff);
//
//
//
//        }
//
//        public void copyChar(char[] source, char[] destination, int startPoint){
//            for(int i=0;i< source.length;i++){
//                destination[startPoint] = source[i];
//                startPoint++;
//            }
//        }
//
//        public char[] readChars(int start, int end, char[] currBuff){
//            if(!(start<=end))
//                return null;
//            int bufSize = end-start;
//            char[] retChar = new char[bufSize];
//            for(int i = 0;i<=bufSize;i++){
//                retChar[i] = currBuff[i];
//            }
//            return retChar;
//        }
//    }
//}
