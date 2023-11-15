package Lab8;
import java.util.*;
/**
 * containsSL() - A class for implementing contains().
 * @author Nathaniel Serrano
 * @version 15 November, 2023
 */
public class containsSL<T> extends SkipList {
	SkipList list;
	


	@Override
	public void insert(Comparable value) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * contains() - Returns true if the inputted value is present in the SkipList
	 * @param value
	 */
	@Override
	public boolean contains(Comparable value) {
		SkipList.SkipListNode<T> currentNode = list.header.forward[MAX_LEVEL];
		SkipList.SkipListNode<T> predecessor = list.header;
		int i = MAX_LEVEL;
		while (currentNode.forward[i]!= null) {
			if ((currentNode.value).equals(value)) {
				return true;
			}
			if (((Comparable) currentNode.forward[i].value).compareTo(value)>0) {
				i--;
				currentNode = predecessor;
			}
			predecessor = currentNode;
			currentNode = currentNode.forward[i];

		} 	
		return false;
		
		
	}
	
	

	@Override
	public boolean delete(Comparable value) {
		// TODO Auto-generated method stub
		return false;
	}


}
