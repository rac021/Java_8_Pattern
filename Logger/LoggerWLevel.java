
package org.inra.logger ;

/**
 *
 * @author Rac021
 */
import java.util.Objects ;
import java.util.function.Predicate ;

public class HelloWorld {

     public static void main(String []args) {
  
       LoggerLevel loggerLevel = ( level, message ) -> System.out.println( level + " --- " + message ) ;
       
       Logger loggerError  = loggerLevel.level(Level.ERROR) ;
       Logger loggerWarn   = loggerLevel.level(Level.WARN)  ;
      
       loggerError.log("Disk quota exceeded") ; 
       loggerWarn.log("Low disk space") ; 
     }

    enum Level {  WARN , ERROR ;  }
    
    interface LoggerLevel {
      void log ( Level level , String message ) ;
      
      default Logger level ( Level level ) {
          return message -> log ( level, message) ;
      }
    }
    
    interface Logger {
        void log( String message ) ;
    }
}
