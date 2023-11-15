import java.util.Random;

public class intertSL extends SkipList {

	@Override
	/*
	 * Ethan Gilles
	 * Insertion into a skip list using a comparable value
	 * 
	 */
	public void insert(Comparable value) {
		
		SkipListNode current = super.header;
		int level = current.forward.length;
		
		SkipListNode[] predecessor = new SkipListNode[level];
		
		for (int i = level; i >= 0; i--) { // all the levels
            while (current.forward[i] != null && current.forward[i].value.compareTo(value) < 0 ) { //go to the furthest value that is less than the entry value
                current = current.forward[i];
            }
            predecessor[i] = current;
        }
		
		int ranLevel = randomLevel();
		
		SkipListNode entry = new SkipListNode(value, ranLevel);
		
		for(int i = 0; i < predecessor.length; i++) { //reassign pointers
			entry.forward[i] = predecessor[i].forward[i];
            predecessor[i].forward[i] = entry;
		}
		
	}
	
	/*
	 * Ethan Gilles & Taylor Brookes
	 * Returns a random level with logarithmic distribution 
	 */
	private int randomLevel() {
		SkipListNode header = super.header;
		int size = 0;
		
		while(header.forward[0] != null) {
			size++;
			header = header.forward[0];
		}
		
		int maxCap = 1;
		while(maxCap < size) {
			maxCap *= 2;
		}
		
		Random rand = new Random();
		int r = rand.nextInt(maxCap);
		int k = (int) (Math.log(r+1) / Math.log(2));
		if(k > super.MAX_LEVEL -1) {
			k = MAX_LEVEL - 1;
		}
		return MAX_LEVEL - k;
	}

	@Override
	public boolean contains(Comparable value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Comparable value) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
