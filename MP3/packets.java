package MP3;

import java.io.*;
import java.util.*;
import java.util.LinkedList;

/**
 * Created by Allyssa Albores on 31/10/2016.
 */

/*
 *  WARNING: INPUT TEXT SHOULD NOT HAVE AN EMPTY LINE OR EXTRA SPACES
 *  FIRST LINE OF POEM SHOULD START WITH SEQUENCE 0
 */

public class packets {
    private static String line;
    private static String from;
    private static String to;
    private static int decimalSize;
    private static int decimalSeq;
    private static int decimalCheck;
    private static Integer count = 0;
    private static List<String> list = new LinkedList<>();
    private static String lastto = null, lastfrom = null, sequence = null;

    public static void sorting() {

        //--------------------------------------------------- sort -----------------------------------------------------

        Collections.sort(list);

        //--------------------------------------------- writing the file -----------------------------------------------

        try {
            File file = new File("output.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            Iterator i = list.iterator();

            while (i.hasNext()) {
                String cont = i.next().toString();

                //------------------------------------ print ip address and poem ---------------------------------------

                lastfrom = cont.substring(cont.indexOf("{") + 1, cont.indexOf("}"));
                lastto = cont.substring(cont.indexOf("<") + 1, cont.indexOf(">"));
                sequence = cont.substring(cont.indexOf("[") + 1, cont.indexOf("]"));

                if(sequence.equals("0")) {
                    bw.write("\nFrom: " + lastfrom + "\n");
                    bw.write("To: " + lastto + "\n\n");
                }

                String result = cont.substring(cont.indexOf("(") + 1, cont.indexOf(")"));

                //--------------------------------------------- missing ------------------------------------------------

                if(sequence.equals("0")) {
                    count = 0;
                }

                if(sequence.equals(count.toString())) {
                    bw.write(result + "\n");
                } else {
                    bw.write("[MISSING]" + "\n");
                }

                count++;
            }

            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int CheckSum() {
        int checkSum = 0;
        char[] arr = line.toCharArray();
        int sizeOfArr = arr.length;

        for(int i = 0; i < sizeOfArr; i++) {
            int ascii = (int) arr[i];
            checkSum += ascii;
        }

        return checkSum;
    }

    public static void main(String args[])throws IOException {
        String content;

        File file = new File("input.txt");

        try {
            Scanner sc = new Scanner(new FileInputStream(file));
            while (sc.hasNextLine()){
                content = sc.nextLine();
                //----------------------------------------------- size -------------------------------------------------

                String size = content.substring(0, 32);
                decimalSize = Integer.parseInt(size, 2);
                System.out.println("Size: " + decimalSize);

                //----------------------------------------------- from -------------------------------------------------

                String from1 = content.substring(32, 40);
                String from2 = content.substring(40, 48);
                String from3 = content.substring(48, 56);
                String from4 = content.substring(56, 64);
                int decimalFrom1 = Integer.parseInt(from1, 2);
                int decimalFrom2 = Integer.parseInt(from2, 2);
                int decimalFrom3 = Integer.parseInt(from3, 2);
                int decimalFrom4 = Integer.parseInt(from4, 2);
                from = decimalFrom1 + "." + decimalFrom2 + "." + decimalFrom3 + "." + decimalFrom4;
                System.out.println("From: " + from);

                //------------------------------------------------ to --------------------------------------------------

                String to1 = content.substring(64, 72);
                String to2 = content.substring(72, 80);
                String to3 = content.substring(80, 88);
                String to4 = content.substring(88, 96);
                int decimalTo1 = Integer.parseInt(to1, 2);
                int decimalTo2 = Integer.parseInt(to2, 2);
                int decimalTo3 = Integer.parseInt(to3, 2);
                int decimalTo4 = Integer.parseInt(to4, 2);
                to = decimalTo1 + "." + decimalTo2 + "." + decimalTo3 + "." + decimalTo4;
                System.out.println("To: " + to);


                //--------------------------------------------- sequence -----------------------------------------------

                String seq = content.substring(96, 128);
                decimalSeq = Integer.parseInt(seq, 2);
                System.out.println("Seq: " + decimalSeq);

                //----------------------------------------------- line -------------------------------------------------

                int sizeOfContent = content.length();
                String check = content.substring(sizeOfContent-32, sizeOfContent);
                line = content.substring(128, sizeOfContent-32);
                System.out.println("Line: " + line);

                //----------------------------------------------- check ------------------------------------------------

                decimalCheck = Integer.parseInt(check, 2);
                System.out.println("Check: " + decimalCheck + "\n");

                //---------------------------------------------- checkSum ----------------------------------------------

                if(CheckSum() != decimalCheck) {
                    line = "[CORRUPTED]";
                }

                //----------------------------------------------- bundle -----------------------------------------------
                    String bundle = "{" + from + "}" + "<" + to + ">" + "[" + decimalSeq + "]" + "(" + line + ")" + decimalCheck + "/" + decimalSize + "/";
                    list.add(bundle);
            }
            sc.close();
        }catch(FileNotFoundException fnf){
            fnf.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        sorting();
    }
}