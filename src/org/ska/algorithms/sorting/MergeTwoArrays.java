package org.ska.algorithms.sorting;

public class MergeTwoArrays {
    public Integer[] merge(Integer[] arrA, Integer[] arrB) {
        
        int arrAIndex = arrA.length-1;
        int arrBIndex = arrB.length-1;
        
        for (int i=arrA.length-1; i>-1; i--) {
            if (arrA[i] != null) {
                
                for (int b=arrBIndex; (b>-1 && arrB[b] > arrA[i]); b--) {
                    arrA[arrAIndex] = arrB[b];
                    arrAIndex = arrAIndex - 1;
                    arrBIndex = arrBIndex - 1;
                }
                
              arrA[arrAIndex] = arrA[i];
              arrAIndex = arrAIndex-1;
            }
        }
        if (arrBIndex > -1) {
            System.arraycopy(arrB, 0, arrA, arrAIndex - arrBIndex, arrBIndex);
        }
        
        return arrA;
    }

}

//MergeTwoArrays merge = new MergeTwoArrays();
//
//Integer[] arrA = new Integer[10];
//arrA[0] = 0;
//arrA[1] = 2;
//arrA[2] = 5;
//arrA[3] = 6;
////arrA[4] = 7;
//
//Integer[] arrB = new Integer[] {1, 3, 4, 6, 7, 9};
//
//Integer[] arrResult = merge.merge(arrA, arrB);
//
//for(int i=0; i<arrResult.length; i++) {
//    System.out.println(arrResult[i]); //0,1,2,3,4,5,6,6,7,9
//}
