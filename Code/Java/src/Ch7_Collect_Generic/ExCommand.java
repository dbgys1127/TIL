package Ch7_Collect_Generic;
import java.util.StringTokenizer;
public class ExCommand {
    private String line;
    private String opcode;
    private String []operand = new String [2];
    public ExCommand(String line){
        this.line=line;
        StringTokenizer st = new StringTokenizer(line," ");
        opcode=st.nextToken().toUpperCase();
        operand[0]=st.nextToken();
        operand[1]=st.nextToken();
    }
    public String getOpcode(){ return opcode; }
    public String getOperand(int index){
        if(index<0||index>1){
            return null;
        }
        return operand[index];
    }
    public String toString() {
        return "[" + line + "] ";
    }
}
