/**
 * Created by Marcello on 10/09/2018.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Stack;
public class stackMachine {
    Stack pilha;

    public stackMachine() {
        this.pilha = new Stack();
    }

    public void readFile(String arquivo){
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(arquivo)));
            String line;
            while((line = br.readLine()) != null){
                switch(line){
                    case "SUM":
                        this.SUM();
                        break;
                    case "SUB":
                        this.SUB();
                        break;
                    case "MULT":
                        this.MULT();
                        break;
                    case "DIV":
                        this.DIV();
                        break;
                    case "PRINT":
                        this.PEEK();
                        break;
                    default:
                        String[] lines = line.split(" ");
                        switch(lines[0]){
                            case "PUSH":
                                this.PUSH(Integer.valueOf(lines[1]));
                                break;
                        }
                }
            }
            br.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public void PEEK(){
        System.out.println(this.pilha.peek());
    }

    private double POP(){
        return (Double) this.pilha.pop();
    }

    private void PUSH(double valor){
        this.pilha.add(valor);
    }

    private void SUM(){
        double op1, op2;
        op1 = this.POP();
        op2 = this.POP();
        op1 = op1 + op2;
        this.PUSH(op1);
    }

    private void SUB(){
        double op1, op2;
        op1 = this.POP();
        op2 = this.POP();
        op1 = op2 - op1;
        this.PUSH(op1);
    }

    private void DIV(){
        double op1, op2;
        op1 = this.POP();
        op2 = this.POP();
        op1 = op2/op1;
        this.PUSH(op1);
    }

    private void MULT(){
        double op1, op2;
        op1 = this.POP();
        op2 = this.POP();
        op1 = op2*op1;
        this.PUSH(op1);
    }
}
