import java.util.*;

public class Exp4Medium {
    public static void main(String[] args) {
        HashMap<Character,List<Integer>> map = new HashMap();
        HashSet<Character> set = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE NUMBER OF CARDS");
        int num = sc.nextInt();
        for(int i=1;i<=num;i++){
            System.out.println("ENTER CARD "+i);
            char key = sc.next().charAt(0);
            int val = sc.nextInt();
            if(map.containsKey(key)){
                map.get(key).add(val);
            }
            else{
                map.put(key,new ArrayList<Integer>());
                map.get(key).add(val);
            }
            if(!set.contains(key)){
                set.add(key);
            }
        }
        System.out.println("DISTINCT SYMBOLS ARE: ");
        for(char character : set){
            System.out.print(character+" ");
        }
        System.out.println();
        for(char character : set){
            System.out.println("CARDS IN "+character+" SYMBOL: ");
            int sum=0;
            List<Integer> keys = map.get(character);
            for(int n : keys){
                sum+=n;
                System.out.println(character+" "+n);
            }
           System.out.println("NUMBER OF CARDS: "+keys.size());
           System.out.println("SUM OF NUMBERS: "+sum);
        }
    }
}
