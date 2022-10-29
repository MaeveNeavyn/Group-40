package Game;

public enum Checkers {
	
		RED_CHECKER (DisplayColour.RED + "●" , CheckerColour.RED),
		BLUE_CHECKER (DisplayColour.BLUE + "●" , CheckerColour.BLUE);
		
		
		private String symbol;
		private CheckerColour colour;


		Checkers(String symbol, CheckerColour colour)
		{
			this.colour = colour;
			this.symbol = symbol;
			// TODO Auto-generated constructor stub
		}
		
		public CheckerColour getcolour()
		{
			return colour;
		}
		
		public String toString()
		{
			return symbol;
		}


}
