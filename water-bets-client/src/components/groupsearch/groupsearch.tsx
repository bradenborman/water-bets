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
import Loader from "react-loader-spinner";
import { CreateGroupModal } from "./createGroupModal";

export interface GroupSearchProps {}

export const GroupSearch: React.FC<GroupSearchProps> = (
  props: GroupSearchProps
) => {
  const [groupNameToSearch, setGroupNameToSearch] = useState<string>("");
  const [groupResultsFound, setGoupResultsFound] = useState<any>();

  //Create Group Modal
  const [show, setShow] = useState<boolean>(false);

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
      },
      {
        groupId: 3,
        groupName: "G-Unit",
        passwordProtected: false,
        membersCount: 5
      },
      {
        groupId: 4,
        groupName: "Taco tacks",
        passwordProtected: true,
        membersCount: 4
      }
    ]);
  };

  const handleJoinGroup = (e: any): void => {
    alert("Attempting to join: " + e.groupName);
  };

  const searchResults = (): JSX.Element => {
    const preSearchHelp = (): JSX.Element => {
      return (
        <div id="preSearchHelp">
          Please use the input above to search for an existing group
        </div>
      );
    };

    const groupSearchLoading = (): JSX.Element => {
      return (
        <div id="groupSearchLoading">
          <Loader type="ThreeDots" color="#00BFFF" height={80} width={80} />
        </div>
      );
    };

    const buildTable = (): JSX.Element => {
      const tableRows = groupResultsFound.map((_row: any, index: any) => {
        return (
          <tr key={index}>
            <td width={"50%"}>{_row.groupName}</td>
            <td>{_row.membersCount}</td>
            <td className="text-warn">
              {_row.passwordProtected ? "Password Required" : ""}
            </td>
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
    };

    if (groupResultsFound != undefined && groupResultsFound != null)
      return buildTable();
    else if (false) return groupSearchLoading();
    else return preSearchHelp();
  };

  return (
    <Page id="group-search-page" topPadding={true}>
      <Row id="createGroupRow">
        <Col md="12">
          Don't see your group?
          <Button variant="success" size="sm" onClick={e => setShow(!show)}>
            Create
          </Button>
          {<CreateGroupModal show={show} setShow={setShow}></CreateGroupModal>}
        </Col>
      </Row>
      <Row id="groupSearchRow">
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
        <Col>{searchResults()}</Col>
      </Row>
    </Page>
  );
};
