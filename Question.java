import java.util.ArrayList;
import java.util.Collections;


public class Question {
	private String text;
	private ArrayList<Answer> answerList = new ArrayList<Answer>();

	public Question(String text , ArrayList<Answer> answerList){
		this.text = text;
		this.answerList = answerList;
	}

	public Question(String text){
		this.text = text;
	}

	public void shuffleAnswers(){
		Collections.shuffle(answerList);
	}

	public String getText(){
		return text;
	}

	public ArrayList<Answer> getAswerList(){
		return answerList;
	}

	public void addAnswer(Answer a){
		answerList.add(a);
	}

	public void setAnswerList(ArrayList<Answer> getAswerList){
		answerList.addAll(answerList);
	}
}
