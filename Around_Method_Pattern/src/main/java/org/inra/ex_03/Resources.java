
package org.inra.ex_03;

/**
 *
 * @author ryahiaoui
 */

class Resource implements AutoCloseable { 
    
    public   Resource() { System.out.println(" Get Connection... ")   ; } 
    public void opOne() { System.out.println(" Run Op One ")          ; } 
    public void opTwo() { System.out.println(" Run Op Two ")          ; }    
    @Override
    public void close() { System.out.println(" CleanUp Connection ")  ; }
}

 public class Resources {

     public static void main(String[] args) {
         
        try ( Resource resource = new Resource() ) {
            
          resource.opOne()    ;
          resource.opTwo()    ;
        }
        
        // Easy to forget Try
     }
   
}