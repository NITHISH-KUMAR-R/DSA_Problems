package dsa;

public class StringReverse {
    public static char[] reverseWord (char [] s, int left , int right){

        StringBuilder sb = new StringBuilder();
        while(left!=right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;

        }
        return s;
    }
    public static String revMethod( String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
    public static void main(String a[]){
        String s   = "Hello world";
        String str1 = "";
        StringBuilder sb = new StringBuilder();

        System.out.println(reverseWord(s.toCharArray(),0,s.length()-1));
        String [] str = s.split(" ");
        for(String rev : str){
            String sh = revMethod(rev);
            str1 +=sh;
            sb.append(sh);
            sb.append(" ");
        }

        System.out.println(str1);

        System.out.println(sb.toString());


    }
}
