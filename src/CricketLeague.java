import java.util.ArrayList;
import java.util.List;

public class CricketLeague {
    private List<CricketTeam> teams;

    public CricketLeague() {
        teams = new ArrayList<>();
        teams.add(new CricketTeam("IND")); // Team India
        teams.add(new CricketTeam("ENG")); // Team England
        teams.add(new CricketTeam("AUS")); // Team Australia
        teams.add(new CricketTeam("PAK")); // Team Pakistan
        teams.add(new CricketTeam("BAN")); // Team Bangladesh
        teams.add(new CricketTeam("ZIM")); // Team Zimbabwe
        teams.add(new CricketTeam("AFG")); // Team Afghanistan
        teams.add(new CricketTeam("IRE")); // Team Ireland
        teams.add(new CricketTeam("SRI")); // Team Sri Lanka
        teams.add(new CricketTeam("NEP")); // Team Nepal
        // Add any additional teams as needed.
    }

    public void recordWin(String countryCode) {
        for (CricketTeam team : teams) {
            if (team.getCountryCode().equalsIgnoreCase(countryCode)) {
                team.recordWin();
                return;
            }
        }
        System.out.println("Team not found: " + countryCode);
    }

    public void recordLoss(String countryCode) {
        for (CricketTeam team : teams) {
            if (team.getCountryCode().equalsIgnoreCase(countryCode)) {
                team.recordLoss();
                return;
            }
        }
        System.out.println("Team not found: " + countryCode);
    }

    public String getWinLossRecord(String countryCode) {
        for (CricketTeam team : teams) {
            if (team.getCountryCode().equalsIgnoreCase(countryCode)) {
                return team.getRecord();
            }
        }
        return "Team not found: " + countryCode;
    }

    public String getWinPercentage(String countryCode) {
        for (CricketTeam team : teams) {
            if (team.getCountryCode().equalsIgnoreCase(countryCode)) {
                return team.getWinPercentage();
            }
        }
        return "Team not found: " + countryCode;
    }
}
