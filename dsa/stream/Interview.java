package dsa.stream;

import java.util.ArrayList;
import java.util.List;

public class Interview {

        public static List<Integer> checkPrime(int n){
            List<Integer> list = new ArrayList<>();
            int i =n;
            while(i!=0){
                if(i/2==0){
                    list.add(2);
                    i = i/2;
                    continue;
                }
                else if(i/3==0){
                    list.add(3);
                    i=i/3;
                    continue;
                }else if(i%5==0){
                    list.add(5);
                    i= i/5;
                    continue;
                }else if(i%7==0){
                    list.add(7);
                    i=i/7;
                    continue;
                }
            }
            return list;
        }
        public static void main(String[]args){

            int n = 12;
            List<Integer> result = new ArrayList<>();
            result = checkPrime(n);
            System.out.println(result);

        }
}

