package robotSportsLeague.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import robotSportsLeague.web.model.RobotTeam;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcRobotTeamRepository implements RobotTeamRepository {

    private JdbcTemplate jdbc;

    @Autowired
    public JdbcRobotTeamRepository (JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }

    @Override
    public Iterable<RobotTeam> findAll() {
        return jdbc.query("SELECT id, teamname, ownerfirstname, ownerlastname" +
                                "FROM SportsTeam", this::mapRowToTable);
    }

    @Override
    public RobotTeam findTeamById(String id) {
        return jdbc.queryForObject("SELECT id, teamname, ownerfirstname, ownerlastname " +
                                "FROM SportsTeam " +
                                "WHERE id = ?", this::mapRowToTable, id);
    }

    public RobotTeam createTeam(RobotTeam robotTeam){
        jdbc.update(robotTeam.getId(),
                    robotTeam.getTeamName(),
                    robotTeam.getOwnerFirstName(),
                    robotTeam.getOwnerLastName());
        return robotTeam;
    }

    @Override
    public RobotTeam mapRowToTable(ResultSet rs, int rowNum) throws SQLException {
        return new RobotTeam(rs.getInt(rowNum),
                             rs.getString("teamname"),
                             rs.getString("ownerfirstname"),
                             rs.getString("ownerlastname"));
    }
}
