package com.company;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
public class Main {

    public static Boolean stringToBoolean(String expression) throws java.lang.Exception {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");

        Boolean dPenne = (Boolean) engine.eval(expression.toLowerCase());

        return dPenne;
    }

    public static void main(String[] args) throws IOException, java.lang.InterruptedException, java.lang.Exception {
        File tableSheet = new File("TruthTableSheet.txt");
        tableSheet.createNewFile();
        FileWriter tsWriter = new FileWriter(tableSheet);

        char array[] = new char[10000];
        boolean continuee = true;

        Scanner kbReader = new Scanner(System.in);
        System.out.println("Hey! Do you want to choose a boolean expression? 'Yes' or 'No' ");

        String s = kbReader.next();
        while (continuee) {

            String a = "true", b = "true";

            if (s.toLowerCase().equals("yes")) {

                TimeUnit.SECONDS.sleep(1);
                System.out.println("Hi! What do you want your expression to be? Do not use spaces and use 'a' and 'b'");

                String s2 = kbReader.next();
                System.out.println("A" + "\t \t" + "B" + "\t \t" + s2);
                tsWriter.write("A" + "\t \t" + "B" + "\t \t" + s2 + "\n");
                tsWriter.flush();
                for (int i = 0; i < 4; i++) {
                    if (i < 2) {
                        a = "true";
                        if (i % 2 == 0) {
                            b = "true";
                        }

                        else {
                            b = "false";
                        }
                    } else {
                        a = "false";
                        if (i % 2 == 0) {
                            b = "true";
                        }

                        else {
                            b = "false";
                        }
                    }
                    Boolean boolres = stringToBoolean(s2.replace("a", a).replace("b", b));

                    if (boolres) {
                        System.out.println(a + "\t" + b + "\t" + boolres);
                        tsWriter.write(a + "\t" + b + "\t" + boolres + "\n");
                        tsWriter.flush();

                    }

                    else {
                        System.out.println(a + "\t" + b + "\t" + boolres);
                        tsWriter.write(a + "\t" + b + "\t" + boolres + "\n");
                        tsWriter.flush();
                    }

                }
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Do you wish to continue? Yes or No");
                String leave = kbReader.next();

                if (leave.toLowerCase().equals("no")) {
                    System.out.println("Goodbye");
                    continuee = false;
                }

                else if (leave.toLowerCase().equals("yes")) {
                    System.out.println("Let's continue!");
                }

                else {
                    System.out.println("Welp...we are going anyway");
                }
            }
            else {
                System.out.println("Sorry, I didn't get that.");
                break;
            }

        }

    }

}