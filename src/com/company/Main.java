package com.company;
import java.util.*;
public class Main {

    public static void main(String[] args) {

        Scanner kbReader = new Scanner(System.in);
        System.out.println("What would you like your expression to be? Please use 'A' and 'B' as your variable names.");
        String exp = kbReader.next();

        System.out.println("A" + "   " + "B" + "    " + exp);
        for(int i = 0; i < 4; i++){
            boolean A;
            boolean B;

            if(i < 2){

                A = true;

                if(i % 2 == 0){

                     B = true;
            }
                else {
                    B = false;
                }

            } else {
                 A = false;

                if(i % 2 == 0){

                    B = true;
                }
                else {
                    B = false;
                }
            }


            if(Boolean.parseBoolean(exp) == false){
                System.out.println(A + "    " + B + "   " + "F");
            }
            else{
                System.out.println(A + "    " + B + "   " + "T");
            }

        }

    }
}
