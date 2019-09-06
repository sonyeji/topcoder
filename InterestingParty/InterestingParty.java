package InterestingParty;

import java.util.HashMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Collections;

public class InterestingParty {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] first = {"fishing", "gardening", "swimming", "fishing"};
		String[] second = {"hunting", "fishing", "fishing", "biting"};
		int result = bestInvitation(first, second);
		System.out.print(result);
	}
	
	public static int bestInvitation(String[] first, String[] second) {
		int result = 0;
		HashMap<String, Integer> invitation = new HashMap<>();
		
		for(int i = 0; i < first.length; i++) {
			if(invitation.containsKey(first[i])) {
				invitation.put(first[i], invitation.get(first[i])+1);
			}else {
				invitation.put(first[i], 1);
			}
			
			if(invitation.containsKey(second[i])) {
				invitation.put(second[i], invitation.get(second[i])+1);
			}else {
				invitation.put(second[i], 1);
			}
		}
		
		//using Iterator
		int max = 0;
		Collection<Integer> invitations = invitation.values();
		for(Iterator it = invitations.iterator(); it.hasNext();) {
			int temp = (int)it.next();
			if(max < temp)
				max = temp;
		}
		result = max;
	
		/* simple code
		int ans = 0;
		for(String key : invitation.keySet()) {
			ans = Math.max(ans, invitation.get(key));
		}
		*/
		
		return result;
	}

}
