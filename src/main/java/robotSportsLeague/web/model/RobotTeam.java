package robotSportsLeague.web.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RobotTeam {

    private Integer id;
    private String teamName;
    private String ownerFirstName;
    private String ownerLastName;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdatedDate;

    public RobotTeam() {
    }

    public RobotTeam(Integer id, String teamName, String ownerFirstName, String ownerLastName, LocalDateTime createDate, LocalDateTime lastUpdatedDate) {
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
    public LocalDateTime getCreateDate() {
        return createDate;
    }
    public LocalDateTime getLastUpdatedDate() {
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
    public void setCreateDate(LocalDateTime createDate){
        this.createDate = createDate;
    }
    public void setLastUpdatedDate(LocalDateTime lastUpdatedDate){
        this.lastUpdatedDate = lastUpdatedDate;
    }

}
