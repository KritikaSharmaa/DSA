package Hard;

public class MissingAndRepeatingNos {
    public static void main(String[] args) {
        int[] numbers ={4, 3, 6, 2, 1, 1};
        int[] res =findRepeatingAndMissingNos(numbers); 
        for(int r: res){
            System.out.print(r+" ");
        }
    }

    //Brute Force Approach 
    //Time complexity - O(N^2)
    //Space complexity - O(1), only using array to store result.
    //public static int[] findRepeatingAndMissingNos(int[] numbers){
    //    int[] res = new int[2];
//
    //    for(int i=1; i<=numbers.length; i++){
    //        boolean found=false;
    //        int count=0;
    //        for(int j=0; j<numbers.length; j++){
    //            if(i==numbers[j]){
    //                found=true;
    //                count++;
    //            }
//
    //            if(count>1){
    //                res[0]=numbers[j];
    //            }
    //        }
//
    //        if(found==false) res[1]=i;
    //    }
//
    //    return res;
    //}

    //Optimal Approch - Using Simple Maths - Way 1(confusing)
    //public static int[] findRepeatingAndMissingNos(int[] numbers){
    //    int n = numbers.length;
    //    int sum_n = 0, sum_n2 = 0;
//
    //    for(int i=0;i<numbers.length; i++){
    //        sum_n +=numbers[i];
    //        sum_n2 += numbers[i]*numbers[i];
    //    }
    //    System.out.println("sum_n"+sum_n+" sum_n2"+sum_n2);
//
    //    int Sn = (n * (n+1))/2;
    //    int Sn2 = ((n*(n+1)*(2*n+1))/6);
    //    
    //    int a = Sn - sum_n;
    //    System.out.println("a: "+a);
    //    int b = Sn2 - sum_n2;
    //    System.out.println("b: "+b);
//
    //    int c = b/a;
    //    System.out.println("C: "+ c);
//
    //    int r = (a+c)/2;
    //    System.err.println("r" + r);
//
    //    int count=0;
    //    for(int i=0; i<numbers.length; i++){
    //        if(numbers[i]==r)
    //            count++;
    //    }
//
    //    if(count>0){
    //        return new int[]{r, a-r};
    //    }else{
    //        return new int[]{r-a, r};
    //    }
//
    //}

    //Optimal Approch - Using Simple Maths - Way2 (derive formaula)
    //Time Complexity - O(n)
    //Space Complexity - O(1)
    public static int[] findRepeatingAndMissingNos(int[] numbers){
        int n = numbers.length;
        // Expected sum and sum of squares for numbers from 1 to n
        int Sn = (n*(n+1))/2 , Snsq = (n*(n+1)*(2*n + 1))/6;

        // Subtract actual values from expected sums
        for(int i=0;i<numbers.length; i++){
            Sn -=numbers[i];                
            Snsq -= (numbers[i]*numbers[i]);
        }

        //Above 2 steps makes
        // (4+3+6+2+1+1) - (1+2+3+4+5+6)  ===> 1(duplicate) - 5(missing) ==> 4. Hence, we can say x(missing) - y(duplicate) = 4 or Sn =4
        // (4^2 + 3^2 + 6^2 + 2^2 + 1^2 + 1^2) - (1^2 + 2^2 + 3^2 + 4^2 + 5^2 + 6^2) ===> 1^2(missing) - 5^2(duplicate) = 24 or Sq=24

        // Let x = missing, y = repeating
        // Sn = x - y
        // Snsq = x^2 - y^2 = (x - y)(x + y) = Sn * (x + y)
        // => x + y = Snsq / Sn  --> y=x-Sn
        // => x + (x -Sn) = Snsq / Sn ==> 2x - Sn = Snsq / Sn .........do +Sn both side
        //DERIVED FORMULA -
        // => x = (Sn + Snsq / Sn) / 2 
        // => y = x - Sn

        int missing = (Sn + (Snsq/Sn)) /2;
        int repeating = missing - Sn;

        return new int[] {repeating, missing};
    }

    //Optimal Approach - using XOR [ will do later upon learning bitwise]
}
