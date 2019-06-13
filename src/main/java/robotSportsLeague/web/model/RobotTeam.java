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

    public RobotTeam() {
    }

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
    public void setId(Integer id){
        this.id = id;
    }
    public void setTeamName(String teamName){
        this.teamName = teamName;
    }
    public void setOwnerFirstName(String ownerFirstName){
        this.ownerFirstName = ownerFirstName;
    }
    public void setOwnerLastName(String ownerLastName){
        this.ownerLastName = ownerLastName;
    }
    public void setCreateDate(Date createDate){
        this.createDate = createDate;
    }
    public void setLastUpdatedDate(Date lastUpdatedDate){
        this.lastUpdatedDate = lastUpdatedDate;
    }

}
