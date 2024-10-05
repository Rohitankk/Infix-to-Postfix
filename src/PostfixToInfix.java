public class PostfixToInfix extends InfixToPostfix{
    public String convert(String postfix){
        System.out.printf("%-8s%-10s%-15s\n", "Input","Stack", "");
        String infix = "";
        Stack<String> s = new Stack<>(String.class, postfix.length());
        s.push("#");

        System.out.printf("%-8s%-10s%-15s\n", "",format(s.toString()),infix);

        for(int i = 0; i < postfix.length(); i++){
            char inputSymbol = postfix.charAt(i);
            if(isOperator(inputSymbol)){
                String op1 = s.pop();

                String op2 = s.pop();

                s.push("(" + op2 + inputSymbol + op1 + ")");
            }
            else
                s.push(inputSymbol + "");
            System.out.printf("%-8s%-10s%-15s\n", ""+inputSymbol,format(s.toString()),infix);
        }


        while(s.peek() != "#"){
            infix += s.pop();
            System.out.printf("%-8s%-10s%-15s\n", "",format(s.toString()),infix);

        }

        return infix;
    }
}
