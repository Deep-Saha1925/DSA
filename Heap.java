import java.util.ArrayList;

public class Heap<T extends Comparable<T>> {
    private ArrayList<T> list;

    public Heap(){
        list = new ArrayList<>();
    }

    private void swap(int first, int second){
        T temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }

    private int parent(int i){
        return (i-1)/2;
    }

    private int left(int i){
        return (2*i)+1;
    }

    private int right(int i){
        return (2*i)+2;
    }

    private void upheap(int idx){
        if(idx == 0){
            return;
        }

        int p = parent(idx);
        
        if(list.get(idx).compareTo(list.get(p))){
            swap(idx, p);
            upheap(p);
        }
    }

    public void insert(T value){
        list.add(value);
        upheap(list.size()-1);
    }

    private void downheap(int idx){
        int min = idx;
        int left = left(idx);
        int right = right(idx);

        if(left < list.size() && list.get(min).compareTo(list.get(left)) > 0){
            min = left;
        }

        if(right < list.size() && list.get(min).compareTo(list.get(right)) > 0){
            min = right;
        }

        if(min != idx){
            swap(min, idx);
            downheap(min);
        }
    }

    public T remove() throws Exception {
        if(list.isEmpty()){
            throw new Exception("Removing from empty heap!!");
        }

        T item = list.get(0);
        T last = list.remove(list.size() - 1);

        if(!list.isEmpty()){
            list.set(0, last);
            downheap(0);
        }

        return item;
    }

    public ArrayList<T> heapSort() throws Exception{
        ArrayList<T> data = new ArrayList<>();

        while(!list.isEmpty()){
            data.add(this.remove());
        }

        return data;
    }

}