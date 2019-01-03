package c1;

import java.util.Stack;

public class Evaluate {

  public static void main(String[] args) {
    Stack<String> ops = new Stack<String>();
    Stack<Double> vals = new Stack<Double>();
    String express = "(1 + ((2 + 3) * (4 * 5)))";
    for (int i = 0; i < express.length(); i++) {
      String s = String.valueOf(express.charAt(i));
      if (s.equals(" ")) continue;
      if (s.equals("(")) ;
      else if (s.equals("+")) ops.push(s);
      else if (s.equals("-")) ops.push(s);
      else if (s.equals("*")) ops.push(s);
      else if (s.equals("/")) ops.push(s);
      else if (s.equals("squrt")) ops.push(s);
      else if (s.equals(")")) {
        String op = ops.pop();
        double v = vals.pop();
        if (op.equals("+")) v += vals.pop();
        else if (op.equals("-")) v -= vals.pop();
        else if (op.equals("*")) v *= vals.pop();
        else if (op.equals("/")) v /= vals.pop();
        else if (op.equals("squrt")) v = Math.sqrt(v);
        vals.push(v);
      } else {
        vals.push(Double.parseDouble(s));
      }
    }
    System.out.println(vals.pop());
  }

}
