
package org.inra.logger ;

import java.util.Objects ;

/**
 *
 * @author Rac021
 */
 
public class HelloWorld {

     public static void main(String []args) {
  
       Logger logger       = msg -> System.out.println(msg);
       Logger loggerFilter = logger.filter( msg -> msg.contains("Error")) ;
       
       loggerFilter.log("Error disk quota exceeded ") ; 
     }

    interface Filter {
        boolean accept( String message) ;
    }

    interface Logger {
        
        void log( String message );
        
        default Logger filter ( Filter filter ) {
            Objects.requireNonNull(filter );
            return 
                msg -> { 
                    if( filter.accept(msg) ) { log(msg) ; }
                } ;
        }
    }
}
