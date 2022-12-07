package Java;

import java.util.Scanner;

public class Timer {
    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        int numFirst = scan.nextInt();
        int numSecond = scan.nextInt();
        int nowTime = scan.nextInt();
        int totalTime = scan.nextInt();

        int Second = 0;

        if(numSecond>=0 && numSecond<10){
           Second = numSecond+50;
        System.out.println(numFirst+":"+"0"+numSecond+" - "+ numFirst+":"+ Second + " ("+ nowTime +"/"+ totalTime +")");
        }

        if(numSecond>=10 && numSecond<20){
            Second = numSecond-10;
            System.out.println(numFirst+":"+numSecond+" - "+ (numFirst+1)+":"+"0"+ Second +" ("+ nowTime +"/"+ totalTime +")");
        }

        if(numSecond>=20 && numSecond<60){
            Second = numSecond+50;
            System.out.println(numFirst+":"+numSecond+" - "+ (numFirst+1)+":"+ (Second-60) +" ("+ nowTime +"/"+ totalTime +")");
        }//
    }
}