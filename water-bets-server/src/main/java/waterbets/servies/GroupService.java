package waterbets.servies;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import waterbets.models.Group;
import waterbets.models.UserPreview;

import java.util.Arrays;

@Service
public class GroupService {

    private static final Logger logger = LoggerFactory.getLogger(GroupService.class);


    public boolean doesPasswordMatch(String password, int groupIdToCheck) {
        return true;
    }

    public void addUserToGroup(UserPreview user) {

    }

    public Group findGroupByGroupId(int groupId) {
        Group testGroup = new Group();
        testGroup.setGroupId(groupId);
        testGroup.setGroupName("Not Not Arizona State");
        testGroup.setPasswordToJoin("Ross");

        UserPreview brendan = new UserPreview();
        brendan.setUserId(1);
        brendan.setFirstName("Brendan");
        brendan.setLastName("Borman");
        brendan.setTotalPoolValue(100);

        UserPreview erik = new UserPreview();
        erik.setUserId(12);
        erik.setFirstName("Erik");
        erik.setLastName("Meyer");
        erik.setTotalPoolValue(100);

        UserPreview zane = new UserPreview();
        zane.setUserId(2);
        zane.setFirstName("Zane");
        zane.setLastName("Lavy");
        zane.setTotalPoolValue(100);

        UserPreview josh = new UserPreview();
        josh.setUserId(22);
        josh.setFirstName("Josh");
        josh.setLastName("Hughes");
        josh.setTotalPoolValue(100);

        UserPreview sean = new UserPreview();
        sean.setUserId(32);
        sean.setFirstName("Sean");
        sean.setLastName("Noble");
        sean.setTotalPoolValue(100);


        UserPreview tedd = new UserPreview();
        tedd.setUserId(42);
        tedd.setFirstName("Tedd");
        tedd.setLastName("Mudd");
        tedd.setTotalPoolValue(100);

        testGroup.setMembers(Arrays.asList(brendan, erik, zane, josh, sean, tedd));

        return testGroup;
    }

}