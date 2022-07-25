package Ch4_Stack_Queue;

public class GenericQueue<T> {
    private T[] que;
    private int capacity;
    private int front;
    private int rear;
    private int num;

    public static class EmptyGQueueException extends RuntimeException{
        public EmptyGQueueException(){}
    }
    public static class OverflowGQueueException extends RuntimeException{
        public OverflowGQueueException(){}
    }
    public GenericQueue(int maxlen){
        num = front = rear =0;
        capacity = maxlen;
        try{
            que =(T[]) new Object[capacity];
        }catch (OutOfMemoryError e){
            capacity =0 ;
        }
    }
    public T enque(T x) throws OverflowGQueueException {
        if(num>=capacity)
            throw new OverflowGQueueException();
        que[rear++]=x;
        num++;
        if(rear==capacity)
            rear=0;
        return x;
    }
    public T deque() throws EmptyGQueueException {
        if(num<=0)
            throw new EmptyGQueueException();
        T x = que[front++];
        num--;
        if(front==capacity)
            front=0;
        return x;
    }
    public T peek() throws EmptyGQueueException {
        if(num<=0)
            throw new EmptyGQueueException();
        return que[front];
    }
    public void clear(){
        num=front=rear=0;
    }
    public int indexOf(T x){
        for(int i =0;i<num;i++){
            int idx = (i+front)%capacity;
            if(que[idx]==x)
                return idx;
        }
        return -1;
    }
    public int search(T x){
        for(int i=0;i<num;i++){
            int idx = (i+front)%capacity;
            if(que[idx]==x){
                return i+1;
            }
        }
        return 0;
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
                System.out.println(que[(i+front)%capacity]+" ");
            }
            System.out.println();
        }
    }
}
