package robotSportsLeague.db;

import robotSportsLeague.web.model.RobotTeam;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RobotTeamRepository {

    Iterable<RobotTeam> findAll();

    RobotTeam findTeamById(String id);

    RobotTeam createTeam(RobotTeam robotTeam);

    RobotTeam mapRowToTable(ResultSet rs, int rowNum)
            throws SQLException;

}
