package waterbets.servies;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import waterbets.config.security.SecurityContextService;
import waterbets.doa.GroupDao;
import waterbets.models.Group;
import waterbets.models.GroupsPreview;
import waterbets.models.UserPreview;
import waterbets.models.WaterBet;
import waterbets.models.enums.WaterBetRetrievalStrategy;

import java.util.Arrays;
import java.util.List;

@Service
public class GroupService {

    private static final Logger logger = LoggerFactory.getLogger(GroupService.class);

    private final WaterBetService waterBetService;
    private final GroupDao groupDao;


    public GroupService(WaterBetService waterBetService, GroupDao groupDao) {
        this.waterBetService = waterBetService;
        this.groupDao = groupDao;
    }

    public boolean doesPasswordMatch(String password, int groupIdToCheck) {
        return true;
    }

    public void addUserToGroup(UserPreview user) {

    }


    public Group fullGroupDetails(int groupId) {
        Group group = findGroupByGroupId(groupId);

        int userId = SecurityContextService.accessLoggedInUser().getUserId();

        List<WaterBet> bets = waterBetService.selectWaterBetsByStrategy(WaterBetRetrievalStrategy.USER_OFFERED, userId);
        group.setWaterBets(bets);


        return group;
    }

    public Group findGroupByGroupId(int groupId) {
        Group testGroup = new Group();
        testGroup.setGroupId(groupId);
        testGroup.setGroupName("Not Not Arizona State");
        testGroup.setPasswordToJoin("Ross");

        UserPreview brendan = new UserPreview();
        brendan.setUserId(1);
        brendan.setUserFullName("Brendan Borman");
        brendan.setTotalPoolValue(100);

        UserPreview erik = new UserPreview();
        erik.setUserId(12);
        erik.setUserFullName("Erik Meyer");
        erik.setTotalPoolValue(100);

        UserPreview zane = new UserPreview();
        zane.setUserId(2);
        zane.setUserFullName("Zane Lavy");
        zane.setTotalPoolValue(100);

        UserPreview josh = new UserPreview();
        josh.setUserId(22);
        josh.setUserFullName("Josh Hughes");
        josh.setTotalPoolValue(100);

        UserPreview sean = new UserPreview();
        sean.setUserId(32);
        sean.setUserFullName("Sean Noble");
        sean.setTotalPoolValue(100);

        UserPreview tedd = new UserPreview();
        tedd.setUserId(42);
        tedd.setUserFullName("Tedd Mudd");
        tedd.setTotalPoolValue(100);

        testGroup.setMembers(Arrays.asList(brendan, erik, zane, josh, sean, tedd));

        return testGroup;
    }

    public GroupsPreview fillGroupPreview() {
        int userId = SecurityContextService.accessLoggedInUser().getUserId();

        GroupsPreview groupsPreview = new GroupsPreview();
        List<GroupsPreview.GroupPreview> groupsUserBelongs = groupDao.selectGroupPreviews(userId, true);
        List<GroupsPreview.GroupPreview> groupsUserNotMember = groupDao.selectGroupPreviews(userId, false);

        groupsPreview.setGroupsUserMember(groupsUserBelongs);
        groupsPreview.setGroupsUserAbsentOf(groupsUserNotMember);
        return groupsPreview;
    }
}