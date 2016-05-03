
package org.inra.around_method_pattern;

/**
 *
 * @author ryahiaoui
 */

class Resource_ARM implements AutoCloseable { 
    
    public Resource_ARM() { System.out.println(" Get Connection... ")   ; } 
    public void   opOne() { System.out.println(" Run Op One ")          ; } 
    public void   opTwo() { System.out.println(" Run Op Two ")          ; }    
    @Override
    public void   close() { System.out.println(" CleanUp Connection ")  ; }
}

 public class Resource_02_ARM {

     public static void main(String[] args) {
         
        try ( Resource_ARM resource = new Resource_ARM() ) {
            
          resource.opOne()    ;
          resource.opTwo()    ;
        }
        
        // Easy to forget Try
     }
   
}
