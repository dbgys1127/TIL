package Ch4_Stack_Queue;

public class SwitchStack {
    private int[]stk;
    private int capacity;
    private int ptrA;
    private int ptrB;

    public enum AorB {StackA, StackB};

    public class EmptyDoubleHeadException extends RuntimeException{
        public EmptyDoubleHeadException(){};
    }
    public class OverDoubleHeadException extends RuntimeException{
        public OverDoubleHeadException(){};
    }
    public SwitchStack(int maxlen){
        ptrA =0;
        ptrB = maxlen-1;
        capacity=maxlen;
        try{
            stk = new int[capacity];
        }catch (OutOfMemoryError e){
            capacity=0;
        }
    }
    public int push(AorB sw, int x) throws OverDoubleHeadException{
        if(ptrA>=ptrB+1)
            throw new OverDoubleHeadException();
        switch (sw){
            case StackA: stk[ptrA++]=x; break;
            case StackB: stk[ptrB--]=x; break;
        }
        return x;
    }
    public int pop(AorB sw) throws EmptyDoubleHeadException{
        int x = 0;
        switch (sw){
            case StackA:
                if(ptrA<=0)
                    throw new EmptyDoubleHeadException();
                x=stk[--ptrA];
                break;
            case StackB:
                if(ptrB>=capacity-1)
                    throw new EmptyDoubleHeadException();
                x=stk[++ptrB];
                break;
        }
        return x;
    }
    public int peek(AorB sw) throws EmptyDoubleHeadException{
        int x = 0;
        switch (sw){
            case StackA:
                if(ptrA<=0)
                    throw new EmptyDoubleHeadException();
                x=stk[ptrA-1];
                break;
            case StackB:
                if(ptrB>=capacity-1)
                    throw new EmptyDoubleHeadException();
                x=stk[ptrB+1];
                break;
        }
        return x;
    }
    public int indexOf(AorB sw, int x){
        switch (sw){
            case StackA:
                for(int i=ptrA-1;i>=0;i--) {
                    if (stk[i] == x)
                        return i;
                }
                break;
            case StackB:
                for(int i=ptrB+1;i<=capacity-1;i++) {
                    if (stk[i] == x)
                        return i;
                }
                break;
        }
        return -1;
    }
    public void clear(AorB sw){
        switch (sw){
            case StackA: ptrA=0; break;
            case StackB: ptrB=capacity-1;break;
        }
    }
    public int getCapacity(){return capacity;}
    public int size(AorB sw){
        switch (sw){
            case StackA: return ptrA;
            case StackB: return capacity - ptrB-1;
        }
        return 0;
    }
    public boolean isEmpty(AorB sw){
        switch (sw){
            case StackA: return ptrA<=0;
            case StackB: return ptrB>=capacity-1;
        }
        return true;
    }
    public boolean isFull(){return ptrA>=ptrB+1;}

    public void dump(AorB sw){
        switch (sw){
            case StackA:
                if(ptrA<=0)
                    System.out.println("stack is empty");
                else{
                    for(int i=0;i<ptrA;i++){
                        System.out.print(stk[i]+" ");
                    }
                    System.out.println();
                }
                break;
            case StackB:
                if(ptrB>=capacity-1)
                    System.out.println("stack is empty");
                else{
                    for(int i=capacity-1;i>ptrB;i--){
                        System.out.print(stk[i]+" ");
                    }
                    System.out.println();
                }
                break;
        }
    }
}
