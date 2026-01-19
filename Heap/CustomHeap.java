import java.util.ArrayList;

public class CustomHeap {
    static class Heap{
        ArrayList<Integer> list = new ArrayList<>();

        public void insert(int num){
            list.add(num); // Insertion
            int childIdx = list.size()-1;
            int parentIdx = (childIdx-1)/2;
            while (list.get(childIdx) < list.get(parentIdx)) {
                //swap
                int temp = list.get(childIdx);
                list.set(childIdx, list.get(parentIdx));
                list.set(parentIdx, temp);

                childIdx = parentIdx;
                parentIdx = (childIdx-1)/2;
            }
        }

        public int peek(){
            return list.get(0);
        }

        public void heapify(int idx){
            int left = idx*2+1;
            int right = idx*2+2;
            int minIdx = idx;

            if(left < list.size() && list.get(left) < list.get(minIdx)){
                minIdx = left;
            }
            if(right < list.size() && list.get(minIdx) > list.get(right)){
                minIdx = right;
            }

            if(minIdx != idx){
                int temp = list.get(minIdx);
                list.set(minIdx, list.get(idx));
                list.set(idx, temp);
                heapify(minIdx);
            }
            
        }

        public int remove(){
            int temp = list.get(0);
            list.set(0, list.get(list.size()-1));
            list.set(list.size()-1, temp);

            list.remove(list.size()-1);
            
            heapify(0);

            return temp;
        }
    }

    public static void main(String[] args) {
        Heap h = new Heap();
        h.insert(9);
        h.insert(2);
        h.insert(7);
        h.insert(8);
        h.insert(3);
        h.insert(1);

        while (h.list.size() > 0) {
            System.out.println(h.peek());
            h.remove();
        }
    }
}
