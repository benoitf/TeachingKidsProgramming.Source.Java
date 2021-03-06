package org.teachingkidsprogramming.recipes.quizzes.tests;

import junit.framework.TestCase;

import org.approvaltests.reporters.DelayedClipboardReporter;
import org.approvaltests.reporters.FileLauncherReporter;
import org.approvaltests.reporters.UseReporter;
import org.teachingextensions.logo.Turtle;
import org.teachingextensions.logo.utils.TortoiseUtils;
import org.teachingextensions.simpleparser.Parser;
import org.teachingkidsprogramming.recipes.quizzes.graders.AdLibsQuizAdapter;
import org.teachingkidsprogramming.recipes.quizzes.graders.AdLibsQuizGrader;
import org.teachingkidsprogramming.recipes.quizzes.graders.TreeQuizGrader;

@UseReporter({DelayedClipboardReporter.class, FileLauncherReporter.class})
public class SimpleBubbleQuizTest extends TestCase
{
  public static class AdLibsCorrectQuiz extends AdLibsQuizAdapter
  {
    public void question1(String letter1, String letter3)
    {
      //set current value of word1 to be letter1 + 'o' + letter3
      word1 = letter1 + "o" + letter3;
    }
    public void question2(String letter1)
    {
      //add the letter1 to the end of word2 
      word2 += letter1;
    }
    public void question3(String templateText, Object model)
    {
      //use the parser to combine the template and the model as word3
      word3 = Parser.parse(templateText, model);
    }
    public void question4(Pieces pieces)
    {
      //set template4 to the template which does'g' + pieces.middle + 'e'
      template4 = "g{middle}e";
    }
  }
  public void testCorrect() throws Exception
  {
    TreeQuizGrader.TURTLE_SPEED = Turtle.TEST_SPEED;
    new AdLibsQuizGrader().grade(new AdLibsCorrectQuiz());
    TortoiseUtils.verifyForOs();
  }
  public static class AdLibsIncorrectQuiz extends AdLibsQuizAdapter
  {
    public void question1(String letter1, String letter3)
    {
    }
    public void question2(String letter1)
    {
    }
    public void question3(String templateText, Object model)
    {
    }
    public void question4(Pieces pieces)
    {
    }
  }
  public void testIncorrect() throws Exception
  {
    TreeQuizGrader.TURTLE_SPEED = Turtle.TEST_SPEED;
    new AdLibsQuizGrader().grade(new AdLibsIncorrectQuiz());
    TortoiseUtils.verifyForOs();
  }
}
