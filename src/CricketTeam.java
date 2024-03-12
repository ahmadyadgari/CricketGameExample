public class CricketTeam {
    private String countryCode; // For example "IND", "AUS", "ENG", etc.
    private int wins;
    private int losses;

    public CricketTeam(String countryCode) {
        this.countryCode = countryCode;
        this.wins = 0;
        this.losses = 0;
    }

    public void recordWin() {
        wins++;
    }

    public void recordLoss() {
        losses++;
    }

    public String getRecord() {
        return countryCode + " " + wins + "W " + losses + "L";
    }

    public String getWinPercentage() {
        int totalGames = wins + losses;
        return totalGames > 0 ? String.format("%s Win%%: %.2f", countryCode, (100.0 * wins / totalGames))
                : countryCode + " Win%: N/A";
    }

    public String getCountryCode() {
        return countryCode;
    }
}
