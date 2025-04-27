package dsa.design.lldDesign;

public class MainClassHeapDs {
    public static  void main(String[]args){
        Heap p = new MaxHeap();
        p.add(1);
        p.add(2);
        p.add(10);
        p.add(20);
        p.add(14);
        p.add(6);

        System.out.println(p.peek());
    }
}
