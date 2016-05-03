
package org.inra.around_method_pattern;

import java.util.function.Consumer;

/**
 *
 * @author ryahiaoui
 */

class Resource_AMP  { 
    
    private Resource_AMP()        { System.out.println(" Get Connection.... ")          ; } 
    public  Resource_AMP opOne()  { System.out.println(" Run Op One ")  ;  return this  ; }
    public  Resource_AMP opTwo()  { System.out.println(" Run Op Two ")  ;  return this  ; }
    private void         close()  { System.out.println(" CleanUp Connection ")          ; }
       
    public static void use( Consumer<Resource_AMP> consummer ) { 
        
       Resource_AMP resource = new Resource_AMP();
       
       try {
          consummer.accept(resource);
       } 
       finally {
          resource.close();
       }
    }
}

 public class Resource_Around_Method_Pattern {

     public static void main(String[] args) {
      
         Resource_AMP.use( resource -> 
                           resource.opOne()
                                   .opTwo());
     }
 }
 