package KiwiJuiceEasy;

public class KiwiJuiceEasy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] capacities = {700000, 800000, 900000, 1000000};
		int[] bottles = {478478, 478478, 478478, 478478};
		int[] fromId = {2, 3, 2, 0, 1};
		int[] toId = {0, 1, 1, 3, 2};
		int[] result = thePouring(capacities, bottles, fromId, toId);

		System.out.print("{");
		for(int i = 0; i < result.length-1; i++) {
			System.out.print(result[i]+",");
		}
		System.out.print(result[result.length-1] + "}");
	}
	
	public static int[] thePouring(int[] capacities, int[] bottles, int[] fromId, int[] toId) {
		int[] result = {};
		
		for(int i = 0; i < fromId.length; i++) {
			int from = fromId[i];
			int to = toId[i];
			
			if(bottles[to]+bottles[from] > capacities[to]) {
				int leak = bottles[from] + bottles[to] - capacities[to];
				bottles[to] = capacities[to];
				bottles[from] = leak;
			}else {
				bottles[to] += bottles[from];
				bottles[from] = 0;
			}
		}
		result = bottles;
		
		return result;
	}
}
