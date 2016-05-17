
package org.inra.validator;

import java.util.Optional;

/**
 *
 * @author ryahiaoui
 */
public class Validator_01 {
    
    public static Validation<Exception, Integer> toInt( String s ) {
        try {
            return new Validation<Exception, Integer>().setOptional(Integer.valueOf(s.trim()));

        } catch(Exception ex) {
           return  new Validation<Exception, Integer>().setException(ex);
        }
    }
    
    public static void main(String[] args) {
        
        String v = null;
        Validation<Exception, Integer> val = toInt(v);
        
        System.out.println(val.toOptional());
        System.out.println(val.potentialException());
    }   
  }

     class Validation<E, T> {

        private  T t ;
        private  E e ;
        
        public Validation <E, T> setOptional( T t ) {
            this.t = t  ;
            return this ;
        }
        
       public Validation <E, T>  setException( E e ) {
            this.e = e  ;
            return this ;
        }
        
        public Optional toOptional() {
            if(t != null){ return Optional.of(t) ; }
            return Optional.empty() ;
        }
       
        public Optional potentialException() {
            if(e != null) { return Optional.of(e) ; }
            return Optional.empty() ;
        }

    }
