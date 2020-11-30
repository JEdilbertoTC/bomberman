import java.util.Objects;

public class GameRecord {
    private String playerName;
    private int score;
    private static GameRecord referenciaGameRecord;
    
    public static GameRecord getReferencia(){
        if(referenciaGameRecord == null){
            return new GameRecord();
        }
        return referenciaGameRecord;
    }
    public GameRecord(int score, String playerName) {
        this.playerName = playerName;
        this.score = score;
    }

    public GameRecord() {
        
    }

    public static void setPlayerName(String playerName) {
        playerName = playerName;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public String getPlayerName() {
        return playerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameRecord record = (GameRecord) o;
        return score == record.score &&
                Objects.equals(playerName, record.playerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerName, score);
    }

    @Override
    public String toString() {
        return "GameRecord{" +
                "playerName='" + playerName + '\'' +
                ", score=" + score +
                '}';
    }
}
