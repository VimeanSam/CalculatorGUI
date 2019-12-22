public class Operand {
    
  int num;  
  public Operand( String token ) {
      num = Integer.parseInt(token);
  }

  public Operand( int value ) {
      num = value;
  }

  public int getValue() {
      return num;
  }

  public static boolean check( String token ) {

      try{
          Integer.parseInt(token);
      }catch (NumberFormatException e){
          return false;
      }
      return true;
      }
  }
