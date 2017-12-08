import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {

	private ArrayList<Question> questionList = new ArrayList<Question>();
	private final int questionLength = 5;
	private ArrayList<String> lines = new ArrayList<String>();

	public FileReader() throws FileNotFoundException{
		readFile();
		setAnswerToQuestion();
	}
	// Read file data line by line and insert to lines list
	private void readFile() throws FileNotFoundException{
		Scanner input = new Scanner(new File("exam.txt"));
		while(input.hasNext()){
			String st = input.nextLine();
			lines.add(st);
		}
		input.close();
	}
	// Assignment answers to questions
	private void setAnswerToQuestion(){
		for(int i = 0 ; i <= lines.size() - questionLength ; i ++){
			if(i % questionLength == 0){
				Question q = new Question(lines.get(i));
				q.addAnswer(new Answer(lines.get(i+1),true));
				q.addAnswer(new Answer(lines.get(i+2),false));
				q.addAnswer(new Answer(lines.get(i+3),false));
				q.addAnswer(new Answer(lines.get(i+4),false));
				questionList.add(q);
			}

		}
	}
	// Get question list
	public ArrayList<Question> getQuestionList(){
		for(int i = 0 ; i < questionList.size() ; i ++){
			questionList.get(i).shuffleAnswers();
		}
		return questionList;
	}

}
