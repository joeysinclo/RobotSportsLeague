package robotSportsLeague.db;

import org.springframework.data.repository.CrudRepository;
import robotSportsLeague.web.model.RobotTeam;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RobotTeamRepository extends CrudRepository<RobotTeam, Integer> {

    RobotTeam mapRowToTable(ResultSet rs, int rowNum)
            throws SQLException;

}
