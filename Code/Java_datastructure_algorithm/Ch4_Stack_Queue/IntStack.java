package Ch4_Stack_Queue;

public class IntStack {
    private int [] stk;
    private int capacity;
    private int ptr;

    public class EmptyIntStackException extends RuntimeException{
        public EmptyIntStackException(){};
    }
    public class OverflowIntStackException extends RuntimeException{
        public OverflowIntStackException(){};
    }
    public IntStack(int maxlen){
        ptr=0;
        capacity=maxlen;
        try{
            stk = new int[capacity];
        }catch (OutOfMemoryError e){
            capacity=0;
        }
    }
    public int push(int x) throws OverflowIntStackException{
        if(ptr>=capacity)
            throw new OverflowIntStackException();
        return stk[ptr++]=x;
    }
    public int pop() throws EmptyIntStackException{
        if(ptr<=0)
            throw new EmptyIntStackException();
        return stk[--ptr];
    }
    public int peek() throws EmptyIntStackException{
        if(ptr<=0)
            throw new EmptyIntStackException();
        return stk[ptr-1];
    }
    public void clear(){ptr=0;}
    public int indexOf(int x){
        for(int i = ptr-1; i>=0;i--){
            if(stk[i]==x)
                return i;
        }
        return -1;
    }
    public int getCapacity(){
        return capacity;
    }
    public int size(){
        return ptr;
    }
    public boolean isEmpty(){
        return ptr<=0;
    }
    public boolean isFull(){
        return ptr>=capacity;
    }
    public void dump(){
        if(ptr<=0)
            System.out.println("스택이 비어있어요.");
        else{
            for(int i =0;i<ptr;i++){
                System.out.println(stk[i]+" ");
            }
            System.out.println();
        }
    }
}
