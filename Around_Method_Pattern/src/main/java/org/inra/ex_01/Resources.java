
package org.inra.ex_01;

/**
 *
 * @author ryahiaoui
 */

class Resource {  
    
    public   Resource()  { System.out.println("Get Connection.... ")  ; } 
    public void opOne()  { System.out.println(" Run Op One ")         ; } 
    public void opTwo()  { System.out.println(" Run Op Two ")         ; }    
    public void close()  { System.out.println(" CleanUp Connection ") ; }
}

 public class Resources {

     public static void main(String[] args) {
         
         Resource resource = new Resource() ;
         resource.opOne()    ;
         resource.opTwo()    ;
         // Easy to forget Close + Exception 
         resource.close() ;
     }
    
 }

