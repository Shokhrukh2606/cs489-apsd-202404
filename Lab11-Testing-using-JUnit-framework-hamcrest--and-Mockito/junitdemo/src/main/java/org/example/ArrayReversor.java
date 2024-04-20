package org.example;

import java.util.Arrays;
import java.util.Collections;

public class ArrayReversor {

    public int[] reverseArray(int [][] given, ArrayFlattenerService arrayFlattenerService){
        if(given==null) return null;
        int result[]=new int[given.length*given[0].length];
        result=arrayFlattenerService.flattenArray(given);
        int i=0;
        int j=result.length-1;
        while (i<j){
            int temp=result[i];
            result[i]=result[j];
            result[j]=temp;
            i++;
            j--;
        }
        return result;
    }
}
