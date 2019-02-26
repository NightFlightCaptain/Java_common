package algorithm.sort;

/**
 *
 * @author wanhaoran
 * @date 2018年3月9日 下午9:57:09
 *
 */
public class InsertionSort {

//	public static void InsertionSore(int[] array) {
//		for(int i =1 ;i<array.length;i++){
//			for (int j = 0; j < i; j++) {
//				if (array[j]>array[i]) {
//					int temp = array[j];
//					array[j] =array[i];
//					array[i] = temp;
//				}
//			}
//		}
//	}
	
	public static void  insert_sort(int array[],int lenth){

		   int temp;

		   for(int i=0;i<lenth-1;i++){
		       for(int j=i+1;j>0;j--){
		           if(array[j] < array[j-1]){
		               temp = array[j-1];
		               array[j-1] = array[j];
		               array[j] = temp;
		           }else{         //不需要交换
		               break;
		           }
		       }
		   }
		}
}
