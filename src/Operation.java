public class Operation {

    public int Oper(int arg1, String oper, int arg2) {
        int result = 0;
        switch (oper) {
            case "+": {
                result =  new Plus().exec(arg1, arg2);
                break;
            }
            case "-": {
                result = new Minus().exec(arg1, arg2);
                break;
            }
            case "*": {
                result = new Multiply().exec(arg1, arg2);
                break;
            }
            case "/": {
                result = new Division().exec(arg1, arg2);
                break;
            }
        }
        return result;
    }
}

