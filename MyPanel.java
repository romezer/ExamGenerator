import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MyPanel extends JPanel {
	private ArrayList<Question> questionList = new ArrayList<Question>();
	private ArrayList<Answer> answerList = new ArrayList<Answer>();
	private ArrayList<JCheckBox> checkboxList = new ArrayList<JCheckBox>();
	private ArrayList<JLabel> labelList = new ArrayList<JLabel>();
	private ArrayList<Boolean> rightAnwers = new  ArrayList<Boolean>();
	private JButton cmdSubmet , cmdClear;
	private JLabel lbGrade;
	private double grade;
	private boolean labelVisible;

	public MyPanel(ArrayList<Question> questionList){
		setLayout (new BoxLayout (this, BoxLayout.Y_AXIS));  
		setVisible(true);
		this.questionList = questionList;
		labelVisible = false;
		for(int i = 0 ; i < questionList.size() ; i ++){
			rightAnwers.add(false);
			JLabel l = new JLabel(questionList.get(i).getText());
			labelList.add(l);
			add(l);
			for(int j = 0 ; j < questionList.get(i).getAswerList().size() ; j ++){
				JCheckBox checkbox = new JCheckBox(questionList.get(i).getAswerList().get(j).getText());
				answerList.add(questionList.get(i).getAswerList().get(j));
				checkbox.addActionListener(new ButtonListener());
				checkboxList.add(checkbox);
				add(checkbox);
			}
		}
		cmdSubmet = new JButton("Submit");
		cmdSubmet.addActionListener(new ButtonListener());
		cmdClear = new JButton("Start New");
		cmdClear.addActionListener(new ButtonListener());
		lbGrade = new JLabel("Grade: " + grade);
		add(cmdSubmet);
		add(cmdClear);
		add(lbGrade);
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		lbGrade.setVisible(labelVisible);
		cmdClear.setVisible(labelVisible);

	}

	private class ButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == cmdSubmet){
				cmdSubmet.setVisible(false);
				labelVisible = true;
				grade = calculateGrade();
				lbGrade.setText("Grade: " + grade + "%");
				colorAnswers();
				repaint();
			}
			else if(e.getSource() == cmdClear){
				for(int i = 0 ; i < checkboxList.size() ; i ++){
					checkboxList.get(i).setSelected(false);
					cmdClear.setVisible(false);
					cmdSubmet.setVisible(true);
					labelVisible = false;
					repaint();
				}

				for(int j = 0 ; j < labelList.size() ; j ++){
					labelList.get(j).setOpaque(false);
					repaint();
				}
				for(int i = 0 ; i < rightAnwers.size() ; i ++){
					rightAnwers.set(i, false);
					repaint();
				}
			}

		}
		// Calculate final grade
		private double calculateGrade(){
			double count = 0;
			for(int i = 0 ; i < checkboxList.size() ; i ++){
				if(checkboxList.get(i).isSelected()  && answerList.get(i).checkCorrect()){
					rightAnwers.set(i / (labelList.size()-1), true) ;
					count ++;

				}

			}

			return (count/questionList.size())*100;
		}
		// Coloring right and wrong answers
		private void colorAnswers(){
			for(int i = 0 ; i < rightAnwers.size() ; i ++){
				if(rightAnwers.get(i) == true){
					labelList.get(i).setBackground(Color.green);
					labelList.get(i).setOpaque(true);
				}
				else{
					labelList.get(i).setBackground(Color.red);
					labelList.get(i).setOpaque(true);
				}
			}
		}
	}



}
