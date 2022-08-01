package Ch11_Collection_Framework;
import java.util.*;
public class ImplementIterator extends MyVector implements Iterator{
    int cursor =0;
    int lastRet = -1;

    public ImplementIterator(int capacity){
        super(capacity);
    }
    public ImplementIterator(){
        this(10);
    }
    public String toString(){
        String tmp = "";
        Iterator it = iterator();

        for(int i=0;it.hasNext();i++){
            if(i!=0) tmp+=", ";
            tmp+=it.next();
        }
        return "["+tmp+"]";
    }
    public Iterator iterator(){
        cursor=0;
        lastRet =-1;
        return this;
    }
    public boolean hasNext(){
        return cursor!=size();
    }
    public Object next(){
        Object next = get(cursor);
        lastRet=cursor++;
        return next;
    }
    public void remove(){
        if(lastRet==-1)
            throw new IllegalArgumentException();
        else{
            remove(lastRet);
            //cursor--;
            lastRet=-1;
        }
    }

    public static void main(String[] args) {
        ImplementIterator v = new ImplementIterator();
        v.add("0");
        v.add("1");
        v.add("2");
        v.add("3");
        v.add("4");

        System.out.println("삭제전 : "+v);
        Iterator it =v.iterator();
        it.next();
        it.remove();
        it.next();
        it.remove();

        System.out.println("삭제 후 : "+v);
    }
}
