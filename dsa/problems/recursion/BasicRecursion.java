package dsa.problems.recursion;

public class BasicRecursion {
    public static void func(int n){
        if(n==4){
            return;
        }
        System.out.println("N value: "+n);
        n++;
        func(n);
        System.out.println("hello after recur call met:" +n);
    }

    static void backTrack(int n){
        if(n<1) {
            return;
        }
        backTrack(n-1);
        System.out.println("Value reverse: "+n);
    }

    static void backTrack2(int i , int n){
        if(i>n){return;}
        backTrack2(i+1, n);
        System.out.println("backTrack : "+i );
    }
    public static void main(String[] args) {
    func(1);
        backTrack(4);
        backTrack2(1,3);

    }
}
