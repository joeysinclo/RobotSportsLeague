package robotSportsLeague;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import robotSportsLeague.config.JPAConfig;
import robotSportsLeague.db.JdbcRobotTeamRepository;
import robotSportsLeague.web.model.RobotTeam;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {JPAConfig.class}, loader = AnnotationConfigContextLoader.class)
@DataJpaTest
public class MySQLTests {

    @Autowired
    private JdbcTemplate jdbc = new JdbcTemplate();

    @Resource
    JdbcRobotTeamRepository jdbcRobotTeamRepo = new JdbcRobotTeamRepository(jdbc);

    @Test(expected = DuplicateKeyException.class)
    public void preventDuplicateTeamNames(){
        RobotTeam insertEntry = new RobotTeam();
        insertEntry.setTeamName("Team Name");
        insertEntry.setOwnerFirstName("First Name");
        insertEntry.setOwnerLastName("Last Name");
        jdbcRobotTeamRepo.save(insertEntry);
        jdbcRobotTeamRepo.save(insertEntry);
    }

//    @Test(expected = DataIntegrityViolationException.class)
//    public void preventNullId(){
//        RobotTeam insertEntry = new RobotTeam();
//        insertEntry.setId(null);
//        insertEntry.setTeamName("Team Name");
//        insertEntry.setOwnerFirstName("First Name");
//        insertEntry.setOwnerLastName("Last Name");
//        jdbc.update("INSERT INTO SportsTeam (id, teamname, ownerfirstname, ownerlastname) " +
//                        "VALUES (?, ?, ?, ?)",
//                insertEntry.getId(),
//                insertEntry.getTeamName(),
//                insertEntry.getOwnerFirstName(),
//                insertEntry.getOwnerLastName());
//    }

    @Test(expected = DataIntegrityViolationException.class)
    public void preventNullTeamName(){
        RobotTeam insertEntry = new RobotTeam();
        insertEntry.setTeamName(null);
        insertEntry.setOwnerFirstName("First Name");
        insertEntry.setOwnerLastName("Last Name");
        jdbcRobotTeamRepo.save(insertEntry);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void preventNullFirstName(){
        RobotTeam insertEntry = new RobotTeam();
        insertEntry.setTeamName("Team Name");
        insertEntry.setOwnerFirstName(null);
        insertEntry.setOwnerLastName("Last Name");
        jdbcRobotTeamRepo.save(insertEntry);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void preventNullLastName(){
        RobotTeam insertEntry = new RobotTeam();
        insertEntry.setTeamName("Team Name");
        insertEntry.setOwnerFirstName("First Name");
        insertEntry.setOwnerLastName(null);
        jdbcRobotTeamRepo.save(insertEntry);
    }

//    @Test
//    public void createDateOnInsert(){
//        RobotTeam insertEntry = new RobotTeam();
//        insertEntry.setTeamName("Team Name");
//        insertEntry.setOwnerFirstName("First Name");
//        insertEntry.setOwnerLastName("Last Name");
//        jdbcRobotTeamRepo.save(insertEntry);
//    }

//    @Test
//    public void updateDateOnUpdate(){
//        RobotTeam insertEntry1 = new RobotTeam();
//        insertEntry1.setTeamName("Team Name");
//        insertEntry1.setOwnerFirstName("First Name");
//        insertEntry1.setOwnerLastName("Last Name");
//
//        RobotTeam insertEntry2 = new RobotTeam();
//        insertEntry2.setTeamName("Team Name");
//        insertEntry2.setOwnerFirstName("New First Name");
//        insertEntry2.setOwnerLastName("New Last Name");
//
//        jdbcRobotTeamRepo.save(insertEntry1);
//        insertEntry1.setOwnerFirstName("New First Name");
//        insertEntry1.setOwnerLastName("New Last Name");
//
//        jdbc.update("UPDATE SportsTeam SET ownerfirstname = ?, ownerlastname = ? " +
//                        "WHERE teamname = ?",
//                insertEntry2.getTeamName(),
//                insertEntry2.getOwnerFirstName(),
//                insertEntry2.getOwnerLastName());
//    }
}
