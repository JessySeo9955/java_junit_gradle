package junit.gradle.unit;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import org.mockito.junit.jupiter.MockitoExtension;

import junit.gradle.Game;
import junit.gradle.HighScoreService;

import org.mockito.Mock;
import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class MockTest {
	private Game gameUnderTest;
	
	@Mock
    HighScoreService mockHighScoreService;
	
    // Sample high score lists for mocking
    private final List<String> firstHighScoreList = Arrays.asList("Alice", "Bob", "Charlie", "Dave", "Elizabeth");
    private final List<String> secondHighScoreList = Arrays.asList("Fred", "Georgia", "Helen", "Ian", "Jane");

    
    
    // Setup method that runs before each test
    @BeforeEach
    public void setUp() {
        // Stubbing the behavior of the mock
        when(mockHighScoreService.getTopFivePlayers())
                .thenReturn(firstHighScoreList)
                .thenReturn(secondHighScoreList);

        // Initialize the Game object with the mocked HighScoreService
        this.gameUnderTest = new Game(mockHighScoreService);
    }
    
    
    @Test
    public void highScoreDisplay() {
        // Expected outputs for the first and second calls
    	   final String firstExpectedPlayerList =
                   "Alice" +
                   "Bob" +
                   "Charlie" +
                   "Dave" +
                   "Elizabeth";

    	   final String secondExpectedPlayerList =
                   "Fred" +
                   "Georgia" +
                   "Helen" +
                   "Ian" +
                   "Jane";

        // Actual calls to displayHighScores(), which will use the mock
        final String firstCall = gameUnderTest.displayHighScores();
        final String secondCall = gameUnderTest.displayHighScores();

        // Assert that the returned player lists are correct
        assertEquals(firstExpectedPlayerList, firstCall);
        assertEquals(secondExpectedPlayerList, secondCall);

        assertThat(firstCall).isEqualTo(firstExpectedPlayerList); // more readable ways
        assertThat(secondCall).isEqualTo(secondExpectedPlayerList);
        
        // Verify that getTopFivePlayers was called exactly twice
        verify(mockHighScoreService, times(2)).getTopFivePlayers();
    }
    
}
