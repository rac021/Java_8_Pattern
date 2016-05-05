
package com.rac.visitorlambda;

/**
 *
 * @author Rac021
 */
public enum Singleton {
   
   INSTANCE ;
   int i    ;
  
   private Singleton() {
   }

   public void show() {
     System.out.println("i = " + i);
   }
  
  public static void main( String[] args) {
     
      Singleton sing1 = Singleton.INSTANCE  ;
      sing1.i         = 10                  ;
      sing1.show()                          ;
      
      Singleton sing2 = Singleton.INSTANCE  ;
      sing2.i         = 101                 ;
      
      sing1.show()                          ;
      
  }

}
