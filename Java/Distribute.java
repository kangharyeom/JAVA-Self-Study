package Java;

public class Distribute {
    public static void main(String[] args) {
        String s = "jaja";
        String str = s.toLowerCase();
        char x = str.charAt(0);
        System.out.println(x);
        int trueX = 0;
        int nonX = 0;
        for(int i=0; i<s.length(); i++){
            if(x==str.charAt(i)){
                trueX += 1;
            } else {
                nonX += 1;
            }
        }
        if (trueX==nonX){
            System.out.println("same");
        } else {
            System.out.println("different");
        }

    }
}
