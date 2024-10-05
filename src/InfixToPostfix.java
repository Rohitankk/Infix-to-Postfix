public class InfixToPostfix {

    public boolean isOperator(char c){
        if(c == '+' || c == '-' || c == '*' || c =='/' || c == '^')
            return true;
        return false;
    }

    public boolean checkPrecedence(char c1, char c2){
        if((c2 == '+' || c2 == '-') && (c1 == '+' || c1 == '-'))
            return true;
        else if((c2 == ' ' || c2 == '/') && (c1 == '+' || c1 == '-' || c1 == ' ' || c1 == '/'))
            return true;
        else if((c2 == '^') && (c1 == '+' || c1 == '-' || c1 == '*' || c1 == '/'))
            return true;
        else
            return false;
    }

    public String convert(String infix){
        System.out.printf("%-8s%-10s%-15s\n", "Input","Stack","Postfix");
        String postfix = "";
        Stack<Character> s = new Stack<>(Character.class, infix.length());
        s.push('#');
        System.out.printf("%-8s%-10s%-15s\n", "",format(s.toString()),postfix);

        for(int i = 0; i < infix.length(); i++){
            char inputSymbol = infix.charAt(i);
            if(isOperator(inputSymbol)){
                while(checkPrecedence(inputSymbol, s.peek()))
                    postfix += s.pop();
                s.push(inputSymbol);
            }
            else if(inputSymbol == '(')
                s.push(inputSymbol);
            else if(inputSymbol == ')'){
                while(s.peek() != '(')
                    postfix += s.pop();
                s.pop();
            }
            else
                postfix += inputSymbol;

            System.out.printf("%-8s%-10s%-15s\n", ""+inputSymbol,format(s.toString()),postfix);

        }

        while(s.peek() != '#'){
            postfix += s.pop();
            System.out.printf("%-8s%-10s%-15s\n", "",format(s.toString()),postfix);
        }


        return postfix;
    }

    public String format(String s){
        s = s.replaceAll(",","");
        s = s.replaceAll(" ","");
        s = s.replaceAll("null", "");
        s = s.substring(1, s.length()-1);
        return s;
    }
}