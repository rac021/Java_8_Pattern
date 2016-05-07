
package org.inra.logger ;

/**
 *
 * @author Rac021
 */
import java.util.Objects ;
import java.util.function.Predicate ;

public class HelloWorld {

     public static void main(String []args) {
  
       Logger logger        =  msg -> System.out.println(msg) ;
       Logger loggerFilter  =  logger.filter ( msg -> msg.contains("Error") ) ;
       
       loggerFilter.log("Error : disk quota exceeded ") ;
       loggerFilter.log("WARN : low disk space ") ; 
     }


    interface Logger {
        
        void log( String message ) ;
        
        default Logger filter ( Predicate<String> filter ) {
            Objects.requireNonNull(filter ) ;
            return 
                msg -> { 
                    if( filter.test(msg) ) { log(msg) ; }
                } ;
        }
    }

}
