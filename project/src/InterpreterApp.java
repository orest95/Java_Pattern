/**
 * Created by Orest on 17.05.2016.
 */
 class InterpreterApp {
    public static void main(String[] args) {

        System.out.println("Вартість реклами:");


        String str = "9";
        Context context = new Context(str);

        Expression price = new TerminalExpression();
        price.interpret(context);
    }
}

 abstract class Expression {
    public abstract void interpret(Context context);
}


 class Context {
    private String input;
    private String output;

    public Context(String input) {
        this.input = input;
        this.output = "";
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
}

 class TerminalExpression extends Expression {
    @Override
    public void interpret(Context context) {
        double price;
        String input = context.getInput();
        price = Integer.valueOf(input);
        price = price * 3000;

        context.setOutput(Double.toString(price) + " грн");
        System.out.println(context.getOutput());
    }
}
