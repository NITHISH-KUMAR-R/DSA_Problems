package dsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Given a sorted array arr[] of size n,
// the goal is to rearrange the array so that all distinct elements appear at the beginning in sorted order.
// Additionally, return the length of this distinct sorted subarray.
public class Interview {
    public static void main(String[] args) {
        int arr[] = {1,1,2,3,4,4,5,5,6,7};


        //int output[] ={2,3,6,7,1,4,5};
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();

        for(int i:arr){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(Map.Entry<Integer,Integer> a : map.entrySet()){
            if(map.get(a.getValue())==2){
                list.add(a.getKey());
            }
        }
        for(Map.Entry<Integer,Integer> a : map.entrySet()){
            if(map.get(a.getValue())==1){
                list.add(a.getKey());
            }
        }
        System.out.println(list);



        //map// 1- 1

    }
}
