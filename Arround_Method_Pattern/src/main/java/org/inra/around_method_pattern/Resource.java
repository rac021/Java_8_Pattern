
package org.inra.around_method_pattern;

/**
 *
 * @author ryahiaoui
 */

class Resource_V1 {  
    
    public Resource_V1()   { System.out.println("Get Connection.... ")  ; } 
    public void opOne()    { System.out.println(" Run Op One ")         ; } 
    public void opTwo()    { System.out.println(" Run Op Two ")         ; }    
    public void finalize() { System.out.println(" CleanUp Connection ") ; }
}

 public class Resource {

     public static void main(String[] args) {
         
         Resource_V1 resource = new Resource_V1() ;
         resource.opOne()    ;
         resource.opTwo()    ;
         // Easy to forget cLose + Exception 
         resource.finalize() ;
     }
    
 }

