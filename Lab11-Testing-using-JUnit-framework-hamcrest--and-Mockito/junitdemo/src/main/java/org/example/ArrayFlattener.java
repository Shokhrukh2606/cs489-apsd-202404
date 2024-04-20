package org.example;

import java.lang.reflect.GenericArrayType;
public class ArrayFlattener implements ArrayFlattenerService {
    public int[] flattenArray(int[][] args){
        if(args==null)return null;
        int rowsCount=args.length;
        int colsCount=args[0].length;
        int i=0;
        int[] result=new int[rowsCount*colsCount];
        for(int[] rowItems: args){
            for (int colItem: rowItems){
                result[i]=colItem;
                i++;
            }
        }
        return result;
    }
}
