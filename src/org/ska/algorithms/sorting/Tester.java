package org.ska.algorithms.sorting;

public class Tester {
    public static void main(String[] args) {
        
        //findSin{lS, 16, 19, 2a, 25, 1, 3,4,5,7, l0, 14}
        //Output: 8 (the index of 5 in the array)
        
// 
//        MergeTwoArrays merge = new MergeTwoArrays();
//        
//        Integer[] arrA = new Integer[10];
//        arrA[0] = 0;
//        arrA[1] = 2;
//        arrA[2] = 5;
//        arrA[3] = 6;
//        //arrA[4] = 7;
//        
//        Integer[] arrB = new Integer[] {1, 3, 4, 6, 7, 9};
//        
//        Integer[] arrResult = merge.merge(arrA, arrB);
//      
//        for(int i=0; i<arrResult.length; i++) {
//            System.out.println(arrResult[i]); //0,1,2,3,4,5,6,6,7,9
//        }

        //System.out.println(SearchInRotatedArray.findIndex(15, new int[]{15, 16, 19, 20, 25, 1, 3, 5, 5, 7, 10, 14}));
        
        System.out.println(SparseSearch.getIndex("car", new String[]{"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""})); //4
        
        //System.out.println(SparseSearch.getIndex("www2", new String[]{"at", "", "", "att", "ball", "", "", "car", "ccc", "cdd", "dad", "www", "www2"})); //4
        
   }
}
