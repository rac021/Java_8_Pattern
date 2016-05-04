
package org.inra.ex_04;

import java.util.function.Consumer;

/**
 *
 * @author ryahiaoui
 */

class Resource  { 
    
    private       Resource()  { System.out.println(" Get Connection.... ")          ; } 
    public  Resource opOne()  { System.out.println(" Run Op One ")  ;  return this  ; }
    public  Resource opTwo()  { System.out.println(" Run Op Two ")  ;  return this  ; }
    private void     close()  { System.out.println(" CleanUp Connection ")          ; }
       
    public static void use( Consumer<Resource> consummer ) { 
        
       Resource resource = new Resource();
       
       try {
          consummer.accept(resource);
       } 
       finally {
          resource.close();
       }
    }
}


 public class Resources {

     public static void main(String[] args) {
      
         Resource.use( resource -> 
                           resource.opOne()
                                   .opTwo());
     }
 }
 