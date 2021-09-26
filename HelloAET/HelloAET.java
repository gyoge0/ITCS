public class HelloAET {

   public static void main (String[] args) {
        
        fizzbuzz(100);
        
   }
   
   public static void fizzbuzz (int amount) {
   
      for (int i=1;i<amount+1;i++) {
         if (i%15==0) {
            System.out.println("fizzbuzz");
         } else if (i%5==0) {
            System.out.println("buzz");
         } else if (i%3==0) {
            System.out.println("fizz");
         } else {
            System.out.println(i);
         }
      }
      
   }
    
}