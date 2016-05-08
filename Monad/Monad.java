
package org.inra.ex_01;

import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

/**
 *
 * @author ryahiaoui
 */
public interface Monad {
    
    public static IntPredicate inBetween( int start , int end ) {
        return value -> value > start && value < end ;
    }
    
    
    public class Validator<T> {
    
         private final T t ;
         private final ArrayList<Throwable> throwables = new ArrayList();
         
         
         private Validator ( T t) {
             this.t = t ;
         }
         
         
         public T get() throws IllegalStateException {
             if (throwables.isEmpty())
                 return t;
         
            IllegalStateException ise = new IllegalStateException();
            throwables.forEach(t -> ise.addSuppressed(t));
            throw ise ;
        }
         
         
        public static <T> Validator<T> of( T t ) {
            Objects.requireNonNull(t);
            return new Validator<>(t);
            
        } 
   
        public Validator<T> validate( Predicate<T> predicate , String message ) {
            if(!predicate.test(t))
                throwables.add(new IllegalStateException(message));
            
            return this ;
        }
        
        
        public <U> Validator<T> validate( Function<T, U> funct , Predicate<U> predicate , String message ) {
           
            Function<User, String> m = w -> w.getName() ;
            
             U apply = funct.apply(t) ;
            return validate( t -> predicate.test( funct.apply(t)    ) , message ) ;
        }
        
    }
    
    
     
    public class User {
    
        private String name ;
        private int age  ;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
        
      
    }
    
    
    public static void main(String[] args) {
        
        User u = new User();
        User validatedUser  = Validator.of(u)
                .validate( User::getName, Objects::nonNull, "name is null ")
                .validate( User::getAge, inBetween(20, 50), "Age > 50 or age < 20")
                .get();
        
        
    }
    
    
    
}
