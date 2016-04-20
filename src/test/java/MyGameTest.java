import org.junit.*;
import static org.junit.Assert.*;

public class MyGameTest {
  @Test
  public void GameTest_shouldCheckIfWordsAreReplaced_true() {
    MyGame testGame = new MyGame();
    String expected = testGame.findAndReplace("hello world", "world", "universe");
    assertEquals(expected, "hello universe");
  }
}
