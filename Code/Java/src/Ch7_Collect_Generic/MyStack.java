package Ch7_Collect_Generic;

class MyStack<T> implements IStack<T> {
    int tos;
    Object [] stck;
    public MyStack(){
        tos=0;
        stck = new Object[10];
    }
    public T pop(){
        if(tos==0) return null;
        tos--;
        return (T)stck[tos];
    }
    public boolean push(T ob){
        if(tos==10){
            return true;
        }
        stck[tos]=ob;
        tos++;
        return true;
    }
}
