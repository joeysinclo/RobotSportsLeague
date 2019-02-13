package robotSportsLeague.web.model;

import lombok.Data;

@Data
public class RobotTeam {

    private int id;
    private String teamName;
    private String ownerFirstName;
    private String ownerLastName;

    public RobotTeam(int id, String teamname, String ownerfirstname, String ownerlastname) {
        this.id = id;
        this.teamName = teamname;
        this.ownerFirstName = ownerfirstname;
        this.ownerLastName = ownerlastname;
    }

    public String getId() {
        return String.valueOf(id);
    }
    public Object getTeamName() {
        return teamName;
    }
    public Object getOwnerFirstName() {
        return ownerFirstName;
    }
    public Object getOwnerLastName() {
        return ownerLastName;
    }
}
