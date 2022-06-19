package waterbets.controllers.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import waterbets.models.Group;
import waterbets.models.GroupsPreview;
import waterbets.servies.GroupService;

import java.util.List;


@RestController
@RequestMapping("/api/group")
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/{groupId}")
    public ResponseEntity<Group> betsByUser(@PathVariable int groupId) {
        return ResponseEntity.ok(groupService.fullGroupDetails(groupId));
    }

    @GetMapping("/user-groups")
    public ResponseEntity<GroupsPreview> groupsUserBelongsTo() {
        GroupsPreview groupsPreview = groupService.fillGroupPreview();
        return ResponseEntity.ok(groupsPreview);
    }

}