import java.util.ArrayList;
import java.util.List;

public class Solution {
List<Integer> temp=new ArrayList<Integer>();
public void nP(List<List<Integer>> list){
	nxuhuan(list,temp, 0);

}
public void nxuhuan(List<List<Integer>> list,List<Integer> temp,int n){
	if (n>=list.size()) {
		return;
	}else {
		for (int i = 0; i < list.get(n).size(); i++) {

			if (n<list.size()-1) {
				temp.add(list.get(n).get(i));
				nxuhuan(list,temp,n+1);

			}else if (n==list.size()-1) {
				temp.add(list.get(n).get(i));
				for (Integer integer : temp) {
					System.out.print(integer);
				}
				System.out.println();

			}
			temp.remove(n);
		}
	} 
}
public static void main(String[] args) {
// TODO Auto-generated method stub


List<List<Integer>> list=new ArrayList<List<Integer>>();
List<Integer> l1=new ArrayList<Integer>();
List<Integer> l2=new ArrayList<Integer>();
List<Integer> l3=new ArrayList<Integer>();
List<Integer> l4=new ArrayList<Integer>();
l1.add(1);
l1.add(2);
l1.add(3);
l2.add(4);
l2.add(5);
l2.add(5);
l2.add(6);
l3.add(7);
l3.add(8);
l4.add(9);
list.add(l1);
list.add(l2);
list.add(l3);
list.add(l4);
Solution solution=new Solution();
solution.nP(list);

}


}