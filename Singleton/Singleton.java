
package com.inra.singleton ;

/**
 * @author Rac021
 * From JAVA 5
 */
public enum Singleton {
   
   INSTANCE ;
   int i    ;
  
   private Singleton() {
      System.out.println(" In Singleton private Constructor ") ;
   }

   public void show() {
     System.out.println("i = " + i ) ;
   }
  
   public void doWork() {
     System.out.println(" Work in Singleton using Enum ") ;
 }
   
  public static void main( String[] args) {
     
      Singleton sing1 = Singleton.INSTANCE  ;
      sing1.i         = 21                  ;
      sing1.show()                          ;
      
      Singleton sing2 = Singleton.INSTANCE  ;
      sing2.i         = 42                  ;
      
      sing1.show()                          ;
      
      Singleton.INSTANCE.doWork()           ;
  }

}
