package robotSportsLeague;

import org.junit.Ignore;
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
import org.junit.Assert;
import robotSportsLeague.config.JPAConfig;
import robotSportsLeague.db.JdbcRobotTeamRepository;
import robotSportsLeague.web.model.RobotTeam;

import javax.annotation.Resource;
import java.time.LocalDate;

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

    @Test
    public void createDateOnInsert(){
        RobotTeam insertEntry = new RobotTeam();
        LocalDate date = LocalDate.now();

        insertEntry.setTeamName("Team Name");
        insertEntry.setOwnerFirstName("First Name");
        insertEntry.setOwnerLastName("Last Name");

        jdbcRobotTeamRepo.save(insertEntry);
        String insertResult = insertEntry.getTeamName();
        Assert.assertEquals("'createdate' is invalid", date.toString(), jdbcRobotTeamRepo.findOne(insertResult).getCreateDate().toString());
    }

    @Ignore
    @Test
    public void updateDateOnUpdate(){
        RobotTeam insertEntry = new RobotTeam();
        insertEntry.setTeamName("Team Name");
        insertEntry.setOwnerFirstName("First Name");
        insertEntry.setOwnerLastName("Last Name");
        jdbcRobotTeamRepo.save(insertEntry);

        insertEntry.setOwnerFirstName("New First Name");
        insertEntry.setOwnerLastName("New Last Name");

        jdbc.update("UPDATE SportsTeam SET ownerfirstname = ?, ownerlastname = ? " +
                        "WHERE teamname = ?",
                insertEntry.getOwnerFirstName(),
                insertEntry.getOwnerLastName(),
                insertEntry.getTeamName());
    }
}
