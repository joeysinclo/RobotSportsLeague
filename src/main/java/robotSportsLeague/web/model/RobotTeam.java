package robotSportsLeague.web.model;

import lombok.Data;

import java.util.Date;

@Data
public class RobotTeam {

    private int id;
    private String teamName;
    private String ownerFirstName;
    private String ownerLastName;
    private Date createDate;
    private Date lastUpdatedDate;

    public RobotTeam(int id, String teamname, String ownerfirstname, String ownerlastname, Date createDate, Date lastUpdatedDate) {
        this.id = id;
        this.teamName = teamname;
        this.ownerFirstName = ownerfirstname;
        this.ownerLastName = ownerlastname;
        this.createDate = createDate;
        this.lastUpdatedDate = lastUpdatedDate;
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
    public Object getCreateDate() {
        return createDate;
    }
    public Object getLastUpdatedDate() {
        return lastUpdatedDate;
    }
}
