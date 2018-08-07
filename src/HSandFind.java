public class HSandFind {
    //this is for chapter question 5.5
    private int[] toSort;
    private int val;
    private boolean sorted = false;

    public HSandFind(int[] toSort, int val)
    {
        this.toSort = toSort;
        this.val = val;
    }

    public void heapSort(){
        System.out.println(this.toString());
        int swap;
        for(int i=toSort.length-1;i>1;i-- ){
            for(int j=i;j>0;j--){
                buildMaxHeap(toSort,j);
            }
            swap=toSort[0];
            toSort[0]=toSort[i];
            toSort[i]=swap;
            //print out for debug and testing
            System.out.println(this.toString());
        }
        sorted = true;
    }

    public boolean findVal(){
        //heapSort the array, which alwasy has O(nlogn)
        if(!sorted) {
            this.heapSort();
        }
        //find the val
        for(int i=0,j=toSort.length-1;j>i;){
            int sum = toSort[i]+toSort[j];
            if(sum == val){
                //print i j for debug and testing
                System.out.println("(True) Found,which:");
                System.out.println("i: "+i);
                System.out.println("j: "+j);
                return true;
            }
            else if (sum>val){
                j--;
            }
            else {
                i++;
            }
        }
           System.out.println("***False***");
           return false;
    }

    private void buildMaxHeap(int[] heap, int index){
        int parentIn = (index+1)/2-1;
        int swap;
        if(heap[index]>heap[parentIn]){
            swap=heap[index];
            heap[index]=heap[parentIn];
            heap[parentIn]=swap;
        }
    }

    @Override
    public String toString()
    {
        StringBuilder sb1= new StringBuilder();
        for(int i=0;i<toSort.length;i++){
            sb1.append(toSort[i]).append(" ");
        }
        return sb1.toString();
    }
}
