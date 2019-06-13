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
        RobotTeam insertEntry1 = new RobotTeam();
        insertEntry1.setTeamName("Team Name");
        insertEntry1.setOwnerFirstName("First Name");
        insertEntry1.setOwnerLastName("Last Name");
        jdbcRobotTeamRepo.save(insertEntry1);
        jdbcRobotTeamRepo.save(insertEntry1);
    }

//    @Test(expected = DataIntegrityViolationException.class)
//    public void preventNullId(){
//        RobotTeam insertEntry1 = new RobotTeam();
//        insertEntry1.setId(null);
//        insertEntry1.setTeamName("Team Name");
//        insertEntry1.setOwnerFirstName("First Name");
//        insertEntry1.setOwnerLastName("Last Name");
//        jdbc.update("INSERT INTO SportsTeam (id, teamname, ownerfirstname, ownerlastname) " +
//                        "VALUES (?, ?, ?, ?)",
//                insertEntry1.getId(),
//                insertEntry1.getTeamName(),
//                insertEntry1.getOwnerFirstName(),
//                insertEntry1.getOwnerLastName());
//    }

    @Test(expected = DataIntegrityViolationException.class)
    public void preventNullTeamName(){
        RobotTeam insertEntry1 = new RobotTeam();
        insertEntry1.setTeamName(null);
        insertEntry1.setOwnerFirstName("First Name");
        insertEntry1.setOwnerLastName("Last Name");
        jdbcRobotTeamRepo.save(insertEntry1);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void preventNullFirstName(){
        RobotTeam insertEntry1 = new RobotTeam();
        insertEntry1.setTeamName("Team Name");
        insertEntry1.setOwnerFirstName(null);
        insertEntry1.setOwnerLastName("Last Name");
        jdbcRobotTeamRepo.save(insertEntry1);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void preventNullLastName(){
        RobotTeam insertEntry1 = new RobotTeam();
        insertEntry1.setTeamName("Team Name");
        insertEntry1.setOwnerFirstName("First Name");
        insertEntry1.setOwnerLastName(null);
        jdbcRobotTeamRepo.save(insertEntry1);
    }

//    @Test
//    public void createDateOnInsert(){
//        RobotTeam insertEntry1 = new RobotTeam();
//        insertEntry1.setTeamName("Team Name");
//        insertEntry1.setOwnerFirstName("First Name");
//        insertEntry1.setOwnerLastName("Last Name");
//        jdbcRobotTeamRepo.save(insertEntry1);
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
