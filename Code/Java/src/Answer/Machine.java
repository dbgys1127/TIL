package Answer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;

public class Machine {
    private String name;
    private HashMap<String, Integer> memory = new HashMap<String, Integer>();
    private Vector<Instruction> program = new Vector<Instruction>();
    private Scanner scanner = new Scanner(System.in);

    public Machine(String name) {
        this.name = name;
    }

    public void readProgramIntoMemory() {
        while(true) {
            System.out.print(">> ");
            String line = scanner.nextLine();
            if(line.toUpperCase().equals("GO"))
                break;
            program.add(new Instruction(line));
        }
    }
    public void clearMemory() {
        program.removeAllElements(); // ������ ��� ��� ����
        memory.clear();
    }

    public void error(int pc, String msg) {
        System.out.print("���α׷� ���� " + (pc+1) + "���� ����. " + msg);
    }

    public void execute() {
        int pc=0;
        while(true) {
            Instruction instruction = program.get(pc);
            pc++; // �̸� ���� ����� �ּҷ� ����
            switch(instruction.getOpcode()) {
                case "MOV" : mov(instruction); break;
                case "ADD" : add(instruction); break;
                case "SUB" : sub(instruction); break;
                case "JN0" :
                    int newAddr = jn0(instruction);
                    if(newAddr == -1) // no jump
                        break; // break from switch
                    else {
                        pc = newAddr;
                        break;
                    }
                case "PRT" : prt(instruction); return;
                default : 	error(instruction); return;
            }

            // printVariables(instruction); // �� �޼ҵ带 �����ϸ� ���� �߿� ���ϴ� ���� ��� �� �� ����
        }
    }

    private void error(Instruction instruction) {
        System.out.print("��� ����! ");
        printVariables(instruction);
    }

    private void printVariables(Instruction instruction) {
        System.out.print(instruction+"\n");

        Set<String> s = memory.keySet();
        Iterator<String> it = s.iterator();
        while(it.hasNext()) {
            String variable = it.next();
            int value = memory.get(variable);
            System.out.print(variable + ":" + value + "\t");
        }
        System.out.println();
    }

    private void prt(Instruction instruction) { // ù��° �ǿ����� ���� ����ϰ� ����. �ι�° �ǿ����ڴ� �ǹ̾���
        String first = instruction.getOperand(0);

        int n = getValue(first);
        printVariables(instruction);
        System.out.println("����� ����� " + n + ". ���α׷� ���� ��");
    }

    private int jn0(Instruction instruction) { // ù��° �ǿ����ڰ� 0�� �ƴϸ� �ι�° �ǿ������� �ּҷ� ����
        String first = instruction.getOperand(0);
        String second = instruction.getOperand(1);

        int n = getValue(first);
        int m = getValue(second);
        if(n != 0) { // n�� 0�� �ƴϸ�
            return m; // ������ �ּ�
        }
        else
            return -1; // ���� ���� �������� ����
    }

    private void sub(Instruction instruction) {
        String first = instruction.getOperand(0);
        String second = instruction.getOperand(1);

        int n = getValue(first);
        int m = getValue(second);
        memory.put(first, n-m);
    }

    private void add(Instruction instruction) {
        String first = instruction.getOperand(0);
        String second = instruction.getOperand(1);

        int n = getValue(first);
        int m = getValue(second);
        memory.put(first, n+m);
    }

    private void mov(Instruction instruction) {
        String variable = instruction.getOperand(0); // ù��° ����
        String second = instruction.getOperand(1); // �ι�

        int n = getValue(second);
        memory.put(variable, n); // ù��° ������ �� ����
    }

    private int getValue(String opr) { // opr�� �����̸� ���� ����. �������̸� �������� �� ����.���� �����̸� ���θ���� 0����
        int n;
        try {
            n = Integer.parseInt(opr); // opr �ǿ����ڰ� ������ ���
        }
        catch(NumberFormatException e) { // opr �ǿ����ڰ� ������ ���
            Integer value = memory.get(opr); // ���� �� �˾Ƴ���
            if(value == null) { // opr �̸��� ������ ���ٸ�
                memory.put(opr, 0); // opr�� ���� 0���� �Ͽ� �� ���� ����
                n = 0; // �ʱ� �� 0
            }
            else {
                n = value; // opr ������ ���� ��
            }
        }
        return n;
    }

    public void run() {
        System.out.println(name + "�� �۵��մϴ�. ���α׷��� �Է����ּ���. GO�� �Է��ϸ� �۵��մϴ�.");
        while(true) {
            readProgramIntoMemory(); // "GO" �� �Էµ� ������ �б�
            execute();
            clearMemory();
        }
    }

    public static void main(String[] args) {
        Machine m = new Machine("������");
        m.run();
    }

}

