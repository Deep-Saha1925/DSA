import java.util.ArrayList;

class Heap<T extends Comparable<T>> {
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

}