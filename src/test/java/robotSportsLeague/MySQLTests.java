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
import java.time.LocalDateTime;

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
        // Get current date & time
        LocalDateTime dateTime = LocalDateTime.now();

        // Reformat current date & time to exclude nanoseconds
        LocalDateTime dateTimeFormat = LocalDateTime.of(dateTime.getYear(), dateTime.getMonth(),
                dateTime.getDayOfMonth(), dateTime.getHour(),
                dateTime.getMinute(), dateTime.getSecond());

        // Execute INSERT query to database
        RobotTeam insertEntry = new RobotTeam();
        insertEntry.setTeamName("Team Name");
        insertEntry.setOwnerFirstName("First Name");
        insertEntry.setOwnerLastName("Last Name");

        jdbcRobotTeamRepo.save(insertEntry);

        // Retrieve data from 'createdate' column of the INSERT query above
        String getInsertedTeamName = insertEntry.getTeamName();
        String getInsertedCreateDate = jdbcRobotTeamRepo.findOne(getInsertedTeamName).getCreateDate().toString();

        // Verify that createDate was generated upon insert (excluding nanoseconds)
        Assert.assertTrue("'createdate' is invalid", getInsertedCreateDate.contains(dateTimeFormat.toString()));
    }

    @Ignore
    @Test
    public void updateDateOnUpdate() throws InterruptedException{
        // Get current date & time
        LocalDateTime dateTime1 = LocalDateTime.now();

        // Reformat current date & time to exclude nanoseconds
        LocalDateTime dateTimeFormat1 = LocalDateTime.of(dateTime1.getYear(), dateTime1.getMonth(),
                dateTime1.getDayOfMonth(), dateTime1.getHour(),
                dateTime1.getMinute(), dateTime1.getSecond());

        RobotTeam insertEntry = new RobotTeam();
        insertEntry.setTeamName("Team Name");
        insertEntry.setOwnerFirstName("First Name");
        insertEntry.setOwnerLastName("Last Name");
        jdbcRobotTeamRepo.save(insertEntry);

        // Retrieve data from 'createdate' column of the INSERT query above
        String getInsertedTeamName1 = insertEntry.getTeamName();
        String getInsertedCreateDate1 = jdbcRobotTeamRepo.findOne(getInsertedTeamName1).getCreateDate().toString();
        String getInsertedUpdateDate1 = jdbcRobotTeamRepo.findOne(getInsertedTeamName1).getLastUpdatedDate().toString();

        // Verify that createDate and updateDate were generated upon insert (excluding nanoseconds)
        Assert.assertTrue("'createdate' is invalid", getInsertedCreateDate1.contains(dateTimeFormat1.toString()));
        Assert.assertTrue("'lastupdateddate' is invalid", getInsertedUpdateDate1.contains(dateTimeFormat1.toString()));

        System.out.println(jdbcRobotTeamRepo.findAll().toString());

        // Wait for a little while
        Thread.sleep(1500);

        // Get current date & time
        LocalDateTime dateTime2 = LocalDateTime.now();

        // Reformat current date & time to exclude nanoseconds
        LocalDateTime dateTimeFormat2 = LocalDateTime.of(dateTime2.getYear(), dateTime2.getMonth(),
                dateTime2.getDayOfMonth(), dateTime2.getHour(),
                dateTime2.getMinute(), dateTime2.getSecond());

        insertEntry.setOwnerFirstName("New First Name");
        insertEntry.setOwnerLastName("New Last Name");

        jdbc.update("UPDATE SportsTeam SET ownerfirstname = ?, ownerlastname = ? " +
                        "WHERE teamname = ?",
                insertEntry.getOwnerFirstName(),
                insertEntry.getOwnerLastName(),
                insertEntry.getTeamName());

        System.out.println(insertEntry.getOwnerFirstName());
        System.out.println(insertEntry.getOwnerLastName());
        System.out.println(dateTimeFormat1.toString());
        System.out.println(dateTimeFormat2.toString());
        System.out.println(jdbcRobotTeamRepo.findAll().toString());

        // Retrieve data from 'createdate' column of the INSERT query above
        String getInsertedTeamName2 = insertEntry.getTeamName();
        String getInsertedCreateDate2 = jdbcRobotTeamRepo.findOne(getInsertedTeamName2).getCreateDate().toString();
        String getInsertedUpdateDate2 = jdbcRobotTeamRepo.findOne(getInsertedTeamName2).getLastUpdatedDate().toString();

        // Verify that createDate remained the same, but that new updateDate was generated upon update (excluding nanoseconds)
        Assert.assertTrue("'createdate' is invalid", getInsertedCreateDate2.contains(getInsertedCreateDate1));
        Assert.assertTrue("'lastupdateddate' is invalid", getInsertedUpdateDate2.contains(dateTimeFormat2.toString()));
    }
}
