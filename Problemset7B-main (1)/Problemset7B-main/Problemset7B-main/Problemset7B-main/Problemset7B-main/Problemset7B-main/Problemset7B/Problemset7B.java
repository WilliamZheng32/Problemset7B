import java.util.Scanner;
import java.util.ArrayList;

public class Problemset7B
{
    public static void main(String[]args){
      
        Scanner scan = new Scanner(System.in);
        System.out.print("enter n:");
        int n = scan.nextInt();
        System.out.println(Eratosthenes(n));
        System.out.println(GoldbachConjecture(120));
        
        
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(9);
        a.add(9);
        ArrayList<Integer> b = new ArrayList<Integer>();
        b.add(9);
        b.add(9);
        
        System.out.println(BigInts(a, b));
    }

    public static ArrayList<Integer> Eratosthenes(int n){
        ArrayList<Integer> lst = new ArrayList();
        int p = 2;
        for(int i = p; i<=n; i++){
            lst.add(i);
        }
        //System.out.println(lst);
        while(p < n-1){
        int z = 0;
        for(int j = lst.indexOf(p)+1; j<lst.size(); j++){
            if(lst.get(j) % p == 0) {
               lst.remove(j);
               j--;
         }
         //System.out.println(p);
    }
    if(lst.indexOf(p) != lst.size()-1) p = lst.get(lst.indexOf(p)+1);
    else return lst;
 }    
    return lst;
}
public static String GoldbachConjecture(int num){
   ArrayList<Integer> lst = Eratosthenes(num);
    
    for(int i = 0; i < lst.size(); i++){
        int a = lst.get(i);
        for(int j = i+1; j < lst.size(); j++){
        int b = lst.get(j);
             if (a + b == num) {
             return num + "=" + a + "+" + b;
        }
    }
}
    return "";
}

public static ArrayList<Integer> BigInts(ArrayList<Integer> a, ArrayList<Integer> b){
    ArrayList<Integer> answer = new ArrayList<Integer>();
    int carry = 0;
    int endA = a.size()-1;
    int endB = b.size()-1;
   
    while(endA >= 0 || endB >= 0){
        int sum = 0;
    if (endA >= 0 && endB >= 0) sum = a.get(endA) + b.get(endB) + carry;
    else if (endA >= 0) sum = a.get(endA) + carry;  
    else if (endB >= 0) sum = b.get(endB) + carry;
    else sum = carry;
   //int sum = a.get(endA) + b.get(endB) + carry;
   answer.add(0, sum);
    carry = sum/10;
    if(carry>0) {
       carry = 1;
       sum -= 10;
       answer.set(0, sum);
   } else carry = 0;
   
   endA--;
   endB--;
   
   if(carry>0 && endA <0 && endB <0){
       answer.add(0,1);
   }
  }
  return answer;
 }
}
