package ohtu;

public class TennisGame {

    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;
    int pointsToWin = 4; 

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name)) {
            player1Score += 1;
        } else {
            player2Score += 1;
        }
    }

    private String pointToText(int points) {
        switch (points) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
        }
        return "";
    }

    private String tieUnderWinPoints() {
        return pointToText(player1Score) + "-All";
    }

    private String playerAtOrOverWinPoints() {
        if (player1Score == player2Score) {
            return "Deuce";
        }
        if (player1Score > player2Score)
            return advantageOrWin(player1Name);
        else
            return advantageOrWin(player2Name);
    }
    
    private String advantageOrWin(String player) {
        if (Math.abs(player1Score-player2Score) == 1){
            return "Advantage " + player;
        } else {
            return "Win for " + player;
        }
    }
    
    private String differenceUnderWinPoints(){
        return pointToText(player1Score) + "-" + pointToText(player2Score);
    }

    public String getScore() {
        if (player1Score >= pointsToWin || player2Score >= pointsToWin) {
            return playerAtOrOverWinPoints();
        } else if (player1Score == player2Score) {
            return tieUnderWinPoints();
        } else {
            return differenceUnderWinPoints();
        }
    }
}
