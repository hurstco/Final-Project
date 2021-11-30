class Question
{

private String question;
private String choiceOne;
private String choiceTwo;
private String choiceThree;
private String choiceFour;
private int answer;
private int points;
private String category;


Question(String aQuestion, String achoiceOne, String achoiceTwo, String achoiceThree, String achoiceFour, int anAnswer, int thePoints, String aCategory)
{
question = aQuestion;
choiceOne = achoiceOne;
choiceTwo = achoiceTwo;
choiceThree = achoiceThree;
choiceFour = achoiceFour;
answer = anAnswer;
points = thePoints;
category = aCategory;

}

String getQuestion()
{
 return question;
}

String getChoiceOne()
{
  return choiceOne;
}

String getChoiceTwo()
{
  return choiceTwo;
}

String getChoiceThree()
{
  return choiceThree;
}

String getChoiceFour()
{
  return choiceFour;
}

int getAnswer()
{
  return answer;
}

int getPoints()
{
  return points;
}

String getCategory()
{
  return category;
}

}