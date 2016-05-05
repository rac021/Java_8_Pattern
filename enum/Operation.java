
package com.inra.enumeration ;

public enum Operation {
    
  PLUS   { double eval ( double x, double y ) { return x + y ; } } ,
  MINUS  { double eval ( double x, double y ) { return x - y ; } } ,
  TIMES  { double eval ( double x, double y ) { return x * y ; } } ,
  DIVIDE { double eval ( double x, double y ) { return x / y ; } } ;

  // Arithmetic op represented by this constant
  abstract double eval(double x, double y) ;
  
  public static void main ( String[] args )  {
  
    Operation op = Operation.PLUS       ;
    double   sum = op.eval( 21 , 21 )   ;
    System.out.println("sum = " + sum)  ;

  }
}
