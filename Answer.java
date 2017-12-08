
public class Answer {
	private String text;
	private Boolean correct;

	public Answer(String text, Boolean correct){
		this.text = text;
		this.correct = correct;
	}

	public String getText(){
		return text;
	}

	public Boolean checkCorrect(){
		return correct;
	}

	public void setCorrect(Boolean b){
		this.correct = b;
	}
}

