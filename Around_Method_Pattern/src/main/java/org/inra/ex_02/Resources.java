
package org.inra.ex_02;

/**
 *
 * @author ryahiaoui
 */

class Resource { 
    
    public Resource  ()  { System.out.println(" Get Connection.... ") ; } 
    public void opOne()  { System.out.println(" Run Op One ")         ; } 
    public void opTwo()  { System.out.println(" Run Op Two ")         ; }    
    public void close()  { System.out.println(" CleanUp Connection ") ; }
}

 public class Resources {

     public static void main(String[] args) {
         Resource resource = new Resource() ;
        try {
          resource.opOne()    ;
          resource.opTwo()    ;
        }
        finally {
          resource.close() ;
        }
        // Easy to forget ++ ( Try and Close )
     }
   
}