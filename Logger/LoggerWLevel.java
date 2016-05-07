
package org.inra.logger ;

/**
 *
 * @author Rac021
 */
import java.util.Objects ;
import java.util.function.Predicate ;

public class LoggerWLevel {

    enum Level {  WARN , ERROR ;  }
    
    interface Logger {
        void log( String message ) ;
    }
    
    interface LoggerLevel {
      void log ( Level level , String message ) ;
      
      default Logger level ( Level level ) {
          return message -> log ( level, message) ;
      }
    }
    
     public static void main(String []args) {
  
       LoggerLevel loggerLevel = ( level, message ) -> System.out.println( level + " --- " + message ) ;
       
       Logger loggerError  = loggerLevel.level(Level.ERROR) ;
       Logger loggerWarn   = loggerLevel.level(Level.WARN)  ;
      
       loggerError.log("Disk quota exceeded") ; 
       loggerWarn.log("Low disk space") ; 
     }
}
