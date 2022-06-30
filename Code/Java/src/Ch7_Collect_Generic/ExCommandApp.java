package Ch7_Collect_Generic;
import Answer.Instruction;

import java.util.*;

public class ExCommandApp {
    private Scanner Scan = new Scanner(System.in);
    Vector<ExCommand> program = new Vector<>();
    HashMap<String,Integer> memory = new HashMap<>();
    public void printAll(){

    }
    public void jn0(ExCommand instruction){
        String first = instruction.getOperand(0);
        String second = instruction.getOperand(1);
        int n = getValue(first);
        int m = getValue(second);
        if(n==-1){
            program.get(m);
        }
    }
    public void sub(ExCommand instruction){
        String first = instruction.getOperand(0);
        String second = instruction.getOperand(1);

        int n = getValue(first);
        int m = getValue(second);

        memory.put(first,n-m);
    }
    public void add(ExCommand instruction){
        String first = instruction.getOperand(0);
        String second = instruction.getOperand(1);

        int n = getValue(first);
        int m = getValue(second);

        memory.put(first,n+m);
    }
    public void mov(ExCommand instruction){
        String variable = instruction.getOperand(0);
        String second = instruction.getOperand(1);

        int n = getValue(second);
        memory.put(variable,n);
    }
    public int getValue(String opr){
        int n;
        try{
            n=Integer.parseInt(opr);
        }catch(NumberFormatException e){
            Integer value=memory.get(opr);
            if(value==null){
                memory.put(opr,0);
                n=0;
            }else{
                n=value;
            }
        }
        return n;
    }
    public void run(){
        System.out.println("수퍼컴이 작동합니다. 프로그램을 입력해주세요. GO를 입력하면 작동합니다.");
        while(true){
            String str = Scan.nextLine();
            ExCommand Instruction = new ExCommand(str);
            if(Instruction.getOpcode().equals("GO")) printAll();
            switch (Instruction.getOpcode()){
                case "MOV" : mov(Instruction); break;
                case "ADD" : add(Instruction); break;
                case "SUB" : sub(Instruction); break;
                case "JN0" : jn0(Instruction); break;
                case "PRT" : break;
            }
        }
    }
    public static void main(String[]args){
        ExCommandApp Game = new ExCommandApp();
        Game.run();
    }
}
