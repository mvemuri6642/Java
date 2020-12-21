/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binary_search;
import java.util.Scanner;

/**
 *
 * @author Manohar V
 */
class Implement{
    int binary_search(int l,int h,int arr[],int x){
        if(h>=l){
            int mid=(l+h)/2;
            if(arr[mid]==x){
                return mid;
            }
            if(arr[mid]>x){
                return binary_search(l,mid-1,arr,x);
            }
            return binary_search(mid+1,h,arr,x);
        }
        return -1;
    }
}
public class Binary_Search {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Implement ob=new Implement();
        Scanner scan = new Scanner(System.in);
        int arr[]={1,2,3,4,5,6,7,8,9,10};
        int h=arr.length;
        System.out.println("Enter a value to search");
        int x=scan.nextInt();
        int res=ob.binary_search(0, h-1, arr, x);
        if(res==-1){
            System.out.println("Not Present");
        }
        else{
            System.out.println("Element Present at: "+res);
        }
        
    }
    
}
