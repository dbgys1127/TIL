package Ch4_Stack_Queue;

public class IntArrayQueue {
    private int[] que;
    private int capacity;
    private int num;

    public class EmptyIntArrayQueueException extends RuntimeException{
        public EmptyIntArrayQueueException(){}
    }
    public class OverflowIntArrayQueueException extends RuntimeException{
        public OverflowIntArrayQueueException(){}
    }
    public IntArrayQueue(int maxlen){
        num=0;
        capacity=maxlen;
        try{
            que = new int[capacity];
        }catch (OutOfMemoryError e){
            capacity=0;
        }
    }
    public int enque(int x) throws OverflowIntArrayQueueException{
        if(num>=capacity)
            throw new OverflowIntArrayQueueException();
        que[num++]=x;
        return que[num];
    }
    public int deque() throws EmptyIntArrayQueueException{
        if(num<=0)
            throw new EmptyIntArrayQueueException();
        int x = que[0];
        --num;
        for(int i=0;i<num;i++){
            que[i]=que[i+1];
        }
        return x;
    }
    public int peek() throws EmptyIntArrayQueueException{
        if(num<=0)
            throw new EmptyIntArrayQueueException();
        return que[num-1];
    }
    public void clear(){
        num=0;
    }
    public int indexOf(int x){
        for(int i=0;i<num;i++){
            if(que[i]==x)
                return i;
        }
        return -1;
    }
    public int getCapacity(){
        return capacity;
    }
    public int size(){
        return num;
    }
    public boolean isEmpty(){
        return num<=0;
    }
    public boolean isFull(){
        return num>=capacity;
    }
    public void dump(){
        if(num<=0)
            System.out.println("que is empty");
        else{
            for(int i=0;i<num;i++){
                System.out.println(que[i]+" ");
            }
            System.out.println();
        }
    }
}
