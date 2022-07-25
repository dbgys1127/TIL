package Ch4_Stack_Queue;

public class StackGeneric<T> {
    private T[] stk;
    private int capacity;
    private int ptr;

    public static class EmptyGstackException extends RuntimeException{
        public EmptyGstackException(){};
    }
    public static class OverflowGstackException extends RuntimeException{
        public OverflowGstackException(){};
    }
    public StackGeneric(int maxlen){
        ptr = 0;
        capacity=maxlen;
        try{
            stk = (T[]) new Object[capacity];
        }catch (OutOfMemoryError e){
            capacity=0;
        }
    }
    public T push(T x) throws OverflowGstackException{
        if(ptr>=capacity){
            throw new OverflowGstackException();
        }
        return stk[ptr++]=x;
    }
    public T pop() throws EmptyGstackException{
        if(ptr<=0){
            throw new EmptyGstackException();
        }
        return stk[--ptr];
    }
    public void clear(){ptr=0;}
    public int indexOf(T x){
        for(int i =ptr-1;i>=0;i--)
            if(stk[i].equals(x))
                return i;
        return -1;
    }
    public T peek() throws EmptyGstackException{
        if(ptr<=0)
            throw new EmptyGstackException();
        return stk[ptr-1];
    }
    public int getCapacity() {
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
            System.out.println("스택이 비어 있습니다.");
        else {
            for(int i =0; i<ptr;i++){
                System.out.print(stk[i]+ " ");
            }
            System.out.println();
        }
    }
}
