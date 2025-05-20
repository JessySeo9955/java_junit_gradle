package junit.gradle;

import java.util.List;

public class Game {
	private final HighScoreService highScoreService;

    public Game(HighScoreService highScoreService) {
        this.highScoreService = highScoreService;
    }

    public String displayHighScores() {
        final List<String> topFivePlayers =
                highScoreService.getTopFivePlayers();
        final StringBuilder sb = new StringBuilder();

        for (int i = 0; i < topFivePlayers.size(); i++) {
            String player = topFivePlayers.get(i);
            sb.append(player);
        }

        return sb.toString();
    }
}
