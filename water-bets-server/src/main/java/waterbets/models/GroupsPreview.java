package waterbets.models;

import java.util.List;

public class GroupsPreview {

    private List<GroupPreview> groupsUserMember;
    private List<GroupPreview> groupsUserAbsentOf;

    public List<GroupPreview> getGroupsUserMember() {
        return groupsUserMember;
    }

    public void setGroupsUserMember(List<GroupPreview> groupsUserMember) {
        this.groupsUserMember = groupsUserMember;
    }

    public List<GroupPreview> getGroupsUserAbsentOf() {
        return groupsUserAbsentOf;
    }

    public void setGroupsUserAbsentOf(List<GroupPreview> groupsUserAbsentOf) {
        this.groupsUserAbsentOf = groupsUserAbsentOf;
    }

    public static class GroupPreview {

        int groupId;
        String groupName;

        public int getGroupId() {
            return groupId;
        }

        public void setGroupId(int groupId) {
            this.groupId = groupId;
        }

        public String getGroupName() {
            return groupName;
        }

        public void setGroupName(String groupName) {
            this.groupName = groupName;
        }

    }

}