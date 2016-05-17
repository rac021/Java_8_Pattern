
package org.inra.validator ;

import java.util.Optional  ;

/**
 *
 * @author ryahiaoui
 */
public class Validator_01 {
    
    public static Validation<Exception, Integer> validate( String s ) {
        try {
            return new Validation<Exception, Integer>().setOptional(Integer.valueOf(s.trim())) ;
        } catch(Exception ex) {
           return  new Validation<Exception, Integer>().setException(ex) ;
        }
    }
    
    public static void main(String[] args) {
        
        String  v1 = null                                 ;
        Validation<Exception, Integer> val = validate(v1) ;
        
        System.out.println(val.toOptional())              ;
        System.out.println(val.potentialException())      ;
    
        
        String v2 = "21"                                  ;
        val       = validate(v2)                          ;
        
        System.out.println(val.toOptional())              ;
        System.out.println(val.potentialException())      ;
        
        String v3 = "r21"                                 ;
        val       = validate(v3)                          ;
        
        System.out.println(val.toOptional())              ;
        System.out.println(val.potentialException())      ;
        
    }   
  }

     class Validation<E, T> {

        private  T value ;
        private  E error ;
        
        public Validation <E, T> setOptional( T value ) {
            this.value = value ;
            return this        ;
        }
        
       public Validation <E, T>  setException( E error ) {
            this.error = error ;
            return this        ;
        }
        
        public Optional toOptional() {
            if( value != null) { return Optional.of(value) ; }
            return Optional.empty()                        ;
        }
       
        public Optional potentialException() {
            if( error != null) { return Optional.of(error) ; }
            return Optional.empty()                        ;
        }

    }
