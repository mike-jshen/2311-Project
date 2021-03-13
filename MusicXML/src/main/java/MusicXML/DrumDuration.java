package MusicXML;

public class DrumDuration {

	 int durationcount;
	 boolean breaksDivider = false;
	
	public int NoteDurationLength(int col,  int nextCol, int nextNextCol, int [] dividers)
	{
		
		if (col != nextCol)
		{
			for (int i = 0; i < dividers.length; i++) 
			{
				if(i+1 < dividers.length) {
				if ((dividers[i] < col) && (nextCol > dividers[i+1]) && (col< dividers[i+1]))
				{
					durationcount = dividers[i+1] - col; 
					breaksDivider  = true;
					
				}
				}
				
				
				if (breaksDivider == false)
				{
					durationcount = nextCol - col; 
					breaksDivider = true;
					
				}
				
			}
				
			
		}
		
		if (col == nextCol)
		{
			
			for (int i = 0; i < dividers.length; i++) 
			{
				if(i+1 < dividers.length) {
				if ((dividers[i] < col) && (nextNextCol > dividers[i+1]) && (col< dividers[i+1]))
				{
					durationcount = dividers[i+1] - col; 
					breaksDivider  = true;
					
				}
				}
				
				if (breaksDivider == false)
				{
					durationcount = nextNextCol - col;
					breaksDivider = true;
					
				}
			}
			
		}
		
		
	
	return durationcount;
	}		
	
}
	
	

