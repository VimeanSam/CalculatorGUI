import java.util.*;

public class Evaluator {
  private Stack<Operand> operandStack;
  private Stack<Operator> operatorStack;

  private StringTokenizer tokenizer;
  private static final String DELIMITERS = "+-*^/#!() ";

  public Evaluator() {
    operandStack = new Stack<>();
    operatorStack = new Stack<>();
  }
 
  public int eval( String expression ) {
    String token;
    // When is it a good time to add the "!" operator?
    //To indicate the end of the expression
    expression = expression.concat("!"); //somehow it worked for the while loop when
    //I add the parameter of Operandstack.size > 1.
    // The 3rd argument is true to indicate that the delimiters should be used
    // as tokens, too. But, we'll need to remember to filter out spaces.
  
    this.tokenizer = new StringTokenizer( expression, DELIMITERS, true );
    
    // initialize operator stack - necessary with operator priority schema
    // the priority of any operator in the operator stack other than
    // the usual mathematical operators - "+-*/" - should be less than the priority
    // of the usual operators

    // TODO Operator is abstract - this will need to be fixed:
    // operatorStack.push( new Operator( "#" ));
       operatorStack.push(new HashtagOperator());
       
    while ( this.tokenizer.hasMoreTokens() ) {
      // filter out spaces
       if ( !( token = this.tokenizer.nextToken() ).equals( " " )) {
        // check if token is an operand
        if ( Operand.check( token )) {
           operandStack.push( new Operand( token ));
        } else {
            if ( ! Operator.check( token )) {
                System.out.println( "*****invalid token******" );
                System.exit( 1 );
          }
          
          // TODO Operator is abstract - these two lines will need to be fixed:
          // The Operator class should contain an instance of a HashMap,
          // and values will be instances of the Operators.  See Operator class
          // skeleton for an example.
          Operator newOperator = Operator.getOperator(token);
          
          //System.out.println("Token: "+token);
          //System.out.println("Op Stack size: "+operandStack.size());
          //Push the "(" into the operatorStack as it will be used to solve parentheses equations
          if(token.equals("(")){
              operatorStack.push( newOperator );
              continue;
          }
          
          if(token.equals(")")){
              while(operatorStack.peek() != Operator.getOperator("(")){
                  Operator oldOpr = operatorStack.pop();
                  //System.out.println(oldOpr.toString());
                  Operand op2 = operandStack.pop();
                  //System.out.println("op2: "+op2.getValue());
                  Operand op1 = operandStack.pop();
                  //System.out.println("op1: "+op1.getValue());
                  operandStack.push( oldOpr.execute( op1, op2 ));
              }
              //pop ( operator
              operatorStack.pop();
              continue;
          }
          
          while (operatorStack.peek().priority() >= newOperator.priority() && operandStack.size() > 1) {
            // note that when we eval the expression 1 - 2 we will
            // push the 1 then the 2 and then do the subtraction operation
            // This means that the first number to be popped is the
            // second operand, not the first operand - see the following code
            
            //System.out.println("ENTER");
            Operator oldOpr = operatorStack.pop();
            //System.out.println(oldOpr.toString());
            Operand op2 = operandStack.pop();
            //System.out.println("op2: "+op2.getValue());
            Operand op1 = operandStack.pop();
            //System.out.println("op1: "+op1.getValue());
            operandStack.push( oldOpr.execute( op1, op2 ));
          }
          operatorStack.push( newOperator );
        }
      }
    }

    // Control gets here when we've picked up all of the tokens; you must add
    // code to complete the evaluation - consider how the code given here
    // will evaluate the expression 1+2*3
    // When we have no more tokens to scan, the operand stack will contain 1 2
    // and the operator stack will have + * with 2 and * on the top;
    // In order to complete the evaluation we must empty the stacks (except
    // the init operator on the operator stack); that is, we should keep
    // evaluating the operator stack until it only contains the init operator;
    // Suggestion: create a method that takes an operator as argument and
    // then executes the while loop; also, move the stacks out of the main
    // method
   
    //clear the stack when pop the final result
    return operandStack.pop().getValue();
  }
}