import java.io.FileNotFoundException;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;


public class Test {
	private static final int frameSize = 150;
	public static void main(String[] args) throws FileNotFoundException {
		FileReader file = new FileReader();
		JFrame frame = new JFrame("Exam");
		frame.add(new MyPanel(file.getQuestionList()));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(file.getQuestionList().size() * frameSize,file.getQuestionList().size() * frameSize); 
		frame.setVisible(true);

	}

}
