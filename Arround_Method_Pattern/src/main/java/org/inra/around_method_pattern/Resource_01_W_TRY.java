
package org.inra.around_method_pattern;

/**
 *
 * @author ryahiaoui
 */

class Resource_TRY { 
    
    public Resource_TRY() { System.out.println(" Get Connection.... ") ; } 
    public void opOne()   { System.out.println(" Run Op One ")         ; } 
    public void opTwo()   { System.out.println(" Run Op Two ")         ; }    
    public void close()   { System.out.println(" CleanUp Connection ") ; }
}

 public class Resource_01_W_TRY {

     public static void main(String[] args) {
         Resource_TRY resource = new Resource_TRY() ;
        try {
          resource.opOne()    ;
          resource.opTwo()    ;
        }
        finally {
          resource.close() ;
        }
        // Easy to forget ++ ( Try and CLose )
     }
   
}
