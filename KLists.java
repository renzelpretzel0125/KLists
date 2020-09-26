import java.util.Arrays;
public class KLists{
  
  public static double [] mergeKLists(double[][]outerArray){// turn to single array, contains all the other functions
    int l = lengthOfArray(outerArray);
    double[]newArray= new double[l];
    for(int i = 1; i<outerArray.length;i++){
      double[]temp1=getTemp(outerArray[i-1]);
      double[]temp2=getTemp(outerArray[i]);
      newArray=merge(newArray,temp1,temp2);
    }
    return newArray;
  }
  public static int lengthOfArray(double[][]outerArray){//finds length to find space for new array
    int count =0;
    for(int i = 0; i<outerArray.length;i++){
      count+=outerArray[i].length;
    }
    return count;
  }
  public static double[]getTemp(double[]arr){//creates a temp array for each array withing the 2D array
    double[]newArr=new double[arr.length];
    for(int i=0; i<arr.length;i++){
      newArr[i]=arr[i];
    }
    return newArr;
  }
  public static double[]merge(double[]target,double[]temp1,double[]temp2){
    int t1 = 0;
    int t2 = 0;
    int i = 0;
    while(t1<temp1.length&&t2<temp2.length){// compare temp1 and temp2
      if(temp1[t1]<temp2[t2]){
        target[i]=temp1[t1++];
      }else{
        target[i]=temp2[t2];
        t2++;
      }
      ++i;
    }
    while(t1<temp1.length){//copy temp1 into target
      target[i++]=temp1[t1++];
    }
    while(t2<temp2.length){//copy temp 2 into target
      target[i++]=temp2[t2++];
    }
    return target;
  } 

  public static void main(String[]args){

    double[][]KLists = {{1.1, 4.4, 5.5}, {1.1, 3.3, 4.4},{2.2, 6.6}};
    double[]newList=mergeKLists(KLists);
    System.out.println(Arrays.toString(newList));

  }

}
