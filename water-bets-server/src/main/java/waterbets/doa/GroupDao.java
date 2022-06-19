package waterbets.doa;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import waterbets.doa.rowmappers.GroupPreviewRowMapper;
import waterbets.doa.sql.SqlParameterFactory;
import waterbets.doa.sql.SqlStatement;
import waterbets.models.GroupsPreview;

import java.util.List;

@Repository
public class GroupDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public GroupDao(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }


    //TODO -> Create a one to many table for user<->groups and update SQL
    public List<GroupsPreview.GroupPreview> selectGroupPreviews(int userId, boolean userBelongs) {
        return namedParameterJdbcTemplate.query(
                userBelongs ? SqlStatement.SELECT_GROUP_PREVIEWS_BY_USER_ID : SqlStatement.SELECT_GROUP_PREVIEWS_USER_NOT_MEMBER,
                SqlParameterFactory.buildGroupPreviewsWithUser(userId),
                new GroupPreviewRowMapper()
        );
    }
}