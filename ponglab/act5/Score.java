public class Score{

	private int leftScore;
	private int rightScore;

	public Score(){
		leftScore = 0;
		rightScore = 0;
	}

	public void leftPoint(){
		leftScore++;
	}

	public void rightPoint(){
		rightScore++;
	}

	public String toString(){
		return ("left score == " + leftScore +" \n rightScore ==  " + rightScore);
	}

}