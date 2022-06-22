import React, { useState } from "react";
import { Page } from "../page/page";
import {
  Col,
  Row,
  FloatingLabel,
  Form,
  InputGroup,
  FormControl,
  Button,
  Table
} from "react-bootstrap";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faSearch } from "@fortawesome/free-solid-svg-icons";

export interface GroupSearchProps {}

export const GroupSearch: React.FC<GroupSearchProps> = (
  props: GroupSearchProps
) => {
  const [groupNameToSearch, setGroupNameToSearch] = useState<string>("");
  const [groupResultsFound, setGoupResultsFound] = useState<any>();

  const handleGroupSearch = (e: any) => {
    e.preventDefault();

    //call the API and get results that match
    setGoupResultsFound([
      {
        groupId: 1,
        groupName: "Not Arizona State",
        passwordProtected: true,
        membersCount: 6
      },
      {
        groupId: 2,
        groupName: "Geek Squad University",
        passwordProtected: false,
        membersCount: 8
      }
    ]);
  };

  const handleJoinGroup = (e: any): void => {
    alert("Attempting to join: " + e.groupName);
  };

  const buildTable = (): JSX.Element => {
    if (groupResultsFound != undefined && groupResultsFound != null) {
      const tableRows = groupResultsFound.map((_row: any, index: any) => {
        return (
          <tr>
            <td width={"50%"}>{_row.groupName}</td>
            <td>{_row.membersCount}</td>
            <td>{_row.passwordProtected ? "Password Required" : ""}</td>
            <td className="joinGroupTd">
              <Button
                variant="link"
                onClick={e => {
                  handleJoinGroup(_row);
                }}
              >
                Join Group
              </Button>
            </td>
          </tr>
        );
      });
      return (
        <Table id="results-table" bordered hover size="md">
          <thead>
            <tr>
              <th>Group Name</th>
              <th>Member Count</th>
              <th>Password Protected?</th>
              <th>Join</th>
            </tr>
          </thead>
          <tbody>{tableRows}</tbody>
        </Table>
      );
    }
  };

  return (
    <Page id="group-search-page" topPadding={true}>
      <Row>
        <Col md="6">
          <Form onSubmit={handleGroupSearch}>
            <InputGroup>
              <InputGroup.Text id="groupNameSearch">
                <FontAwesomeIcon icon={faSearch} />
              </InputGroup.Text>
              <FormControl
                onChange={e => setGroupNameToSearch(e.target.value)}
                placeholder="Group Name"
                aria-label="Group Name"
                aria-describedby="groupNameSearch"
              />
              <Button
                type="submit"
                variant="outline-secondary"
                id="button-addon2"
              >
                Search
              </Button>
            </InputGroup>
          </Form>
        </Col>
      </Row>
      <Row>
        <Col>{buildTable()}</Col>
      </Row>
    </Page>
  );
};
