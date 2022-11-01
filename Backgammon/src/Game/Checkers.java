package Game;

public class Checkers {
	
		private CheckerColour colour;


		Checkers(CheckerColour colour)
		{
			this.colour = colour;
		}
		
		public CheckerColour getcolour()
		{
			return colour;
		}
		
		public String toString()
		{
			if (getcolour() == CheckerColour.RED)
			{
				return "🔴";
			}
			else 
				
			return "🔵";
		}


}
