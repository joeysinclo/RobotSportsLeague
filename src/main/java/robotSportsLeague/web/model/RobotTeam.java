package robotSportsLeague.web.model;

import lombok.Data;

import java.util.Date;

@Data
public class RobotTeam {

    private Integer id;
    private String teamName;
    private String ownerFirstName;
    private String ownerLastName;
    private Date createDate;
    private Date lastUpdatedDate;

    public RobotTeam(Integer id, String teamName, String ownerFirstName, String ownerLastName, Date createDate, Date lastUpdatedDate) {
        this.id = id;
        this.teamName = teamName;
        this.ownerFirstName = ownerFirstName;
        this.ownerLastName = ownerLastName;
        this.createDate = createDate;
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public Integer getId() {
        return id;
    }
    public String getTeamName() {
        return teamName;
    }
    public String getOwnerFirstName() {
        return ownerFirstName;
    }
    public String getOwnerLastName() {
        return ownerLastName;
    }
    public Date getCreateDate() {
        return createDate;
    }
    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }
}
