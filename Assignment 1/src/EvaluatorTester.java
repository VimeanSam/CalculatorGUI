
public class EvaluatorTester {
  public static void main(String[] args) {
    Evaluator evaluator = new Evaluator();

    String hardTest = "2+3-5*((2-3)*2-5*2+3*(2-3-5-5*6)+4/2)*2-9";
    String expr2 = "(2+3)*4";
    String expr3 = "14-((3+7)-(3*2))+7";
    String expr4 = "(11+3)-2";
    String expr5 = "100*(2+12)/14";
    String expr6 = "((3+7)+(3*2))";
    String expr7 = "(3*(1+4)+2";
    String expr8 = "((3*7)-(2+2))";
    System.out.println(hardTest+" = "+evaluator.eval(hardTest));
    System.out.println(expr2+" = "+evaluator.eval(expr2));
    System.out.println(expr3+" = "+evaluator.eval(expr3));
    System.out.println(expr4+" = "+evaluator.eval(expr4));
    System.out.println(expr5+" = "+evaluator.eval(expr5));
    System.out.println(expr6+" = "+evaluator.eval(expr6));
    System.out.println(expr7+" = "+evaluator.eval(expr7));
    System.out.println(expr8+" = "+evaluator.eval(expr8));
    
  }
}
