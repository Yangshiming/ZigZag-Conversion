public class Solution {
    public String convert(String s, int numRows) {
        // 3 row chars
		String[] rowChar = new String[numRows];
		for (int i = 0; i < rowChar.length; i++) {
			rowChar[i] = new String();
		}
		
		//UP and down iterator index
		int upIndex[]  ;
		int downIndex[];
		if (numRows == 1) {
			upIndex = new int[]{0};
			downIndex= new int[]{0};
		}
		else {
			upIndex = new int[numRows-1];
			downIndex= new int[numRows-1];
			for (int i = 0; i <numRows-1; i++) {
				downIndex[i] = i;
			}
			for (int i = 0; i < numRows-1; i++) {
				upIndex[i] = numRows-1-i;
			}
		}

    	int direction = -1; //-1-down   1-up
    	int index = 0;      // upIndex'index
    	int updex = 0;		//downIndex'inedx
    	for (int i = 0; i < s.length(); i++) {
    		
    		if(direction == -1){           //DOWN
    			int a = downIndex[index];
    			rowChar[downIndex[index]] = rowChar[downIndex[index]].concat(String.valueOf(s.charAt(i))) ;//rowChar[i%numRows]
    			index++;
    			if (index >= numRows-1) {
    				direction = -direction;
					index = 0;
				}
    		}else {							//UP
    			rowChar[upIndex[updex]] = rowChar[upIndex[updex]].concat(String.valueOf(s.charAt(i))) ;
    			updex++;
    			if (updex >= numRows-1) {
    				direction = - direction;
					updex = 0;
				}
			}
		}
    	
    	String result = new String();
    	for (int k = 0; k < numRows; k++) {
    		result = result.concat(rowChar[k]);
    	}
    	return result;
	}	
        
}
