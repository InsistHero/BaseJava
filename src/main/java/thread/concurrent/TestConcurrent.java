package thread.concurrent;

public class TestConcurrent {

    public static void main(String[] args) {
        //System.out.println("Hello");

        int[] a = {9,10,11,1,5,6,3};
        //a = bubbleSort(a);
        //for(int i=0;i<=a.length-1;i++){
        //   System.out.println(a[i]);
        //}
        fastSort(a,0,a.length-1);
        for(int i=0;i<=a.length-1;i++){
           System.out.println(a[i]);
        }
    }

    private static void fastSort(int[] a, int low, int high) {
        if (low < high) {
            int mid = getMiddle(a,low,high);
            fastSort(a,low,mid-1);
            fastSort(a,mid+1,high);
        }
    }

    public static int getMiddle(int[] a,int low,int high){

        int temp = a[low];

        while(high>low){
            while(high>low && temp<=a[high]) {
                high--;
            }
            a[low] = a[high];
            while(high>low && a[low]<=temp){
                low++;
            }
            a[high] = a[low];
        }
        a[high] = temp;
        return high;

    }


    private static int[] bubbleSort(int[] a) {
        for(int i = a.length-1;i>=0;i--){
            for(int j =0;j<a.length-1;j++){
                if(a[j]>a[j+1]){
                    int temp = 0;
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        return a;
    }


}
