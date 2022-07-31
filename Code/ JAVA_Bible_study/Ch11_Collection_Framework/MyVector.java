package Ch11_Collection_Framework;
import java.util.*;
public class MyVector implements List {
    Object[] data = null;
    int capacity = 0;
    int size = 0;
    public MyVector(int capacity){
        if(capacity<0){
            throw new IllegalArgumentException("유효하지 않은 값입니다. : "+capacity);
        }
        this.capacity=capacity;
        data = new Object[capacity];
    }
    public MyVector(){
        this(10);
    }
    public void ensureCapacity(int minCapacity){
        //현재 vector 길이보다 더큰용량이 필요하다면?
        //새롭게 배열을 만들어라
        if(minCapacity- data.length>0)
            setCapacity(minCapacity);
    }
    public boolean add(Object obj){
        //추가하게 되면 현재 보다 무조건 1칸이 더필요하기 때문에, ensureCapacity메서드를 호출한다.
        ensureCapacity(size+1);
        //한칸 용량이 늘어난 배열의 끝 인덱스에 add 해준다.
        data[size++] = obj;
        return true;
    }
    public Object get(int index){
        if(index<0||index>=size)
            throw new IndexOutOfBoundsException("범위를 벗어났습니다.");
        return data[index];
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    public Object remove(int index){
        Object oldObj = null;

        if(index<0 || index>=size)
            throw new IndexOutOfBoundsException("범위를 벗어났습니다.");
        oldObj = data[index];

        if(index != size-1){
            //객체가 마지막 객체가 아니라면, 배열복사를 한다.
            //arraycopy(원본,원본의 삭제할 인덱스의 뒷번호부터 복사,다시 원본에, 삭제할 대상의 인덱스부터, 삭제하고 남은 갯수만큼을)
            System.arraycopy(data,index+1,data,index,size-index-1);
        }
        //지웠다고 해서 용량이 주는 것은 아니나, 요소의 개수 (size)가 줄기 때문에, 마지막 인덱스를 null로 채우고, 요소의 개수를 의미하는 size를 지운다.
        data[size-1]=null;
        size--;
        return oldObj;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    public boolean remove(Object obj){
        for(int i=0;i<size;i++){
            if(obj.equals(data[i])){
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    public void trimToSize(){
        setCapacity(size);
    }
    public void setCapacity(int capacity){
        if(this.capacity==capacity) return;
        Object[] tmp = new Object[capacity];
        System.arraycopy(data,0,tmp,0,size);
    }
    public void clear(){
        for(int i=0;i<size;i++)
            data[i]=null;
        size=0;
    }
    public Object[] toArray(){
        Object[] result =new Object[size];
        System.arraycopy(data,0,result,0,size);
        return result;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    public boolean isEmpty(){return size==0;}

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    public int capacity(){return capacity;}
    public int size(){return size;}
}
