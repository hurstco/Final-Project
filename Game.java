import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

class Game implements ActionListener
{
/*declaring all variables of gui and game class*/
  
  private JLabel labelWelcome;
  private JLabel labelGame;
  private JButton buttonOne;
  private JButton buttonTwo;
  private JButton buttonThree;
  private JButton buttonFour;
  private JLabel totalscore;
  private JButton nextQ;
  private JButton enterAnswer;
  private JButton enterName;
  private JButton exit;
  private ArrayList<Question> questions;
  private int score;
  private JTextField nameSpace;
  private JLabel name;
  private JLabel showQs;
  private JLabel feedback;
  private ButtonGroup choiceGroup;

  public Game() 
  {
    questions = new ArrayList<Question>();
    score = 0;
    String question = "";
    String choiceOne = "";
    String choiceTwo = "";
    String choiceThree = "";
    String choiceFour = "";
    int answer = 0;
    int points = 0;
    String category = "";

    try 
    {

      FileReader file;
      file = new FileReader("trivia.txt");
      BufferedReader reader = new BufferedReader(file);

      while (reader.ready()) 
      {
        // may need to parse the integer while intializing the question object
        question = reader.readLine();
        choiceOne = reader.readLine();
        choiceTwo = reader.readLine();
        choiceThree = reader.readLine();
        choiceFour = reader.readLine();
        answer = Integer.parseInt(reader.readLine());
        points = Integer.parseInt(reader.readLine());
        category = reader.readLine();
        Question q = new Question(question, choiceOne, choiceTwo, choiceThree, choiceFour, answer, points, category);
        questions.add(q);
      }
      reader.close();
    }

    catch (IOException e) 
    {

      System.out.println("An error occured: " + e);

    }
    // all this looks good
    FileWriter writer;
    try 
    {
      writer = new FileWriter("score.txt");
      BufferedWriter output = new BufferedWriter(writer);
      output.flush();
      output.close();
    }

    catch (IOException ex)
    {
      ex.printStackTrace();
    }

    try 
    {
      writer = new FileWriter("score.txt");
      BufferedWriter output = new BufferedWriter(writer);
      output.write("player Score =" + score);
      output.newLine();

      output.flush();
      output.close();
    } 
    
    catch (IOException exc) 
    {
      exc.printStackTrace();
    }

    //setting the layout and formatting the frame
    JFrame frame = new JFrame("Group 10's Jeopardy Game");
    frame.setLayout(new FlowLayout());
    frame.setSize(600, 350);
    frame.getContentPane().setBackground(Color.YELLOW);
    frame.setVisible(true);

    //setting the buttons equal to the choices in the trivia file
    buttonOne = new JButton(questions.get(0).getChoiceOne());
    buttonTwo = new JButton(questions.get(0).getChoiceTwo());
    buttonThree = new JButton(questions.get(0).getChoiceThree());
    buttonFour = new JButton(questions.get(0).getChoiceFour());

    //setting the color of the choice buttons to green and blue
    buttonOne.setForeground(Color.GREEN);
    buttonTwo.setForeground(Color.GREEN);
    buttonThree.setForeground(Color.GREEN);
    buttonFour.setForeground(Color.GREEN);
    buttonOne.setBackground(Color.BLUE);
    buttonTwo.setBackground(Color.BLUE);
    buttonThree.setBackground(Color.BLUE);
    buttonFour.setBackground(Color.BLUE);

    //adding the choice buttons to a button group
    choiceGroup = new ButtonGroup();
    choiceGroup.add(buttonOne);
    choiceGroup.add(buttonTwo);
    choiceGroup.add(buttonThree);
    choiceGroup.add(buttonFour);

    //intializing buttons to enter name , next question, and exit game
    enterName = new JButton("Click to Enter the Game!");
    enterAnswer = new JButton("Enter Choice");
    nextQ = new JButton("Next Question");
    exit = new JButton("Exit Game");

    //adding action liseteners to the buttons
    enterName.addActionListener(this);
    enterAnswer.addActionListener(this);
    nextQ.addActionListener(this);
    exit.addActionListener(this);
    exit.setForeground(Color.YELLOW);
    exit.setBackground(Color.BLACK);

    //intializing a textfield to add a name, with an action listener and label
    nameSpace = new JTextField(15);
    nameSpace.setActionCommand("myTF");
    nameSpace.addActionListener(this);
    name = new JLabel("Please enter your name: ");
    name.setForeground(Color.gray);

    //initializng welcome label and score, feedback, and questions label
    labelWelcome = new JLabel("Welcome to Jeopardy!");

    totalscore = new JLabel("Score: " + score);
    feedback = new JLabel("");
    showQs = new JLabel(questions.get(0).getQuestion());
    showQs.setForeground(Color.GRAY);


    //adding all aspects of the gui to the frame and setting them visbile or not visible depending on context
    frame.add(labelWelcome);
    frame.add(labelGame);
    frame.add(buttonOne);
    frame.add(buttonTwo);
    frame.add(buttonThree);
    frame.add(buttonFour);
    frame.add(nextQ);
    frame.add(enterName);
    frame.add(name);
    frame.add(nameSpace);
    frame.add(enterName);
    frame.add(totalscore);
    frame.add(showQs);
    frame.add(nextQ);
    frame.add(enterAnswer);
    frame.add(exit);
    frame.add(feedback);
    frame.setVisible(true);
    showQs.setVisible(false);
    labelWelcome.setVisible(false);
    totalscore.setVisible(false);
    buttonOne.setVisible(false);
    buttonTwo.setVisible(false);
    buttonThree.setVisible(false);
    buttonFour.setVisible(false);
    feedback.setVisible(false);
    enterAnswer.setVisible(false);
    nextQ.setVisible(false);
  }

  int i = 0;

  /* this method sets an integer of i = to 0, which is then modified to have the gui show different questions, choices and scores depending on the choice the user chooses*/
  void NextQuestion() {

    if (i < questions.size()) {
      showQs.setText("");
      buttonOne.setText("");
      buttonTwo.setText("");
      buttonThree.setText("");
      buttonFour.setText("");
      feedback.setText("");
      i++;

      showQs.setText(questions.get(i).getQuestion());
      buttonOne.setText(questions.get(i).getChoiceOne());
      buttonTwo.setText(questions.get(i).getChoiceTwo());
      buttonThree.setText(questions.get(i).getChoiceThree());
      buttonFour.setText(questions.get(i).getChoiceFour());

      System.out.println(questions.get(i).getQuestion());
      System.out.println(questions.get(i).getChoiceOne());
      System.out.println(questions.get(i).getChoiceTwo());
      System.out.println(questions.get(i).getChoiceThree());
      System.out.println(questions.get(i).getChoiceFour());

      enterAnswer.setVisible(true);
    }

    else 
    {
      labelWelcome.setText("The Game Has Ended");
      showQs.setVisible(false);
      buttonOne.setVisible(false);
      buttonTwo.setVisible(false);
      buttonThree.setVisible(false);
      buttonFour.setVisible(false);
      feedback.setVisible(false);
      enterAnswer.setVisible(false);
      nextQ.setVisible(false);
      exit.setVisible(false);

    }

  }

  //this method tallies up the score for correct answers and tells the user "incorrect" if they choose incorrectly
  public void actionPerformed(ActionEvent ae) 
  {

    int choiceOne = 1;
    int choiceTwo = 2;
    int choiceThree = 3;
    int choiceFour = 4;

    if (ae.getActionCommand().equals("Enter Choice")) {
      if (buttonOne.isSelected() && questions.get(i).getAnswer() == 1) 
      {
        feedback.setText("Nice. You're Correct! + 5 points");
        score += questions.get(i).getPoints();
        enterAnswer.setVisible(false);
      }

      else if (buttonTwo.isSelected() && questions.get(i).getAnswer() == 2)
      {
        feedback.setText("Nice. You're Correct! +5 points");
        score += questions.get(i).getPoints();
        enterAnswer.setVisible(false);
      }

      else if (buttonThree.isSelected() && questions.get(i).getAnswer() == 3) 
      {
        feedback.setText("Nice. You're Correct! +5 points");
        score += questions.get(i).getPoints();
        enterAnswer.setVisible(false);
      }

      else if (buttonFour.isSelected() && questions.get(i).getAnswer() == 4) 
      {
        feedback.setText("Nice. You're Correct! +5 points");
        score += questions.get(i).getPoints();
        enterAnswer.setVisible(false);
      }

      else 
      {
        feedback.setText("Wrong choice");
        enterAnswer.setVisible(false);

      }

      totalscore.setText("Your Score = " + score);
    }

    //allows the user to move to the next question and clear the gui
    else if (ae.getActionCommand().equals("Next Question")) 
    {
      choiceGroup.clearSelection();
      NextQuestion();
      questions.get(i).getAnswer();
      questions.get(i).getPoints();

    }

    //resets the game to its original status
    else if (ae.getActionCommand().equals("Click to Enter the Game!")) 
    {
      String userName = nameSpace.getText();
      labelWelcome.setText("Welcome " + userName + " to Jeopardy");

      name.setVisible(false);
      nameSpace.setVisible(false);
      enterName.setVisible(false);
      showQs.setVisible(true);
      labelWelcome.setVisible(true);
      totalscore.setVisible(true);
      buttonOne.setVisible(true);
      buttonTwo.setVisible(true);
      buttonThree.setVisible(true);
      buttonFour.setVisible(true);
      feedback.setVisible(true);
      enterAnswer.setVisible(true);
      nextQ.setVisible(true);
      exit.setVisible(true);

    }

    else if (ae.getActionCommand().equals("Exit Game")) 
    {
      System.exit(0);
    }

    else 
    {
      feedback.setText("Please click a button to continue");
    }

  }
}

