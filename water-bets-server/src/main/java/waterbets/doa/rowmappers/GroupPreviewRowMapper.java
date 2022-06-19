package waterbets.doa.rowmappers;

import org.springframework.jdbc.core.RowMapper;
import waterbets.models.GroupsPreview;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupPreviewRowMapper implements RowMapper<GroupsPreview.GroupPreview> {

    @Override
    public GroupsPreview.GroupPreview mapRow(ResultSet rs, int rowNum) throws SQLException {
        GroupsPreview.GroupPreview groupPreview = new GroupsPreview.GroupPreview();
        groupPreview.setGroupId(rs.getInt("group_id"));
        groupPreview.setGroupName(rs.getString("groupName"));
        return groupPreview;
    }

}