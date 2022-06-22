import React, { useState } from "react";
import { Page } from "../page/page";
import {
  InputGroup,
  DropdownButton,
  Dropdown,
  Form,
  Row,
  Col,
  Button
} from "react-bootstrap";
import Group from "../../models/group";
import UserPreview from "../../models/userPreview";

var data: Group[] = require("./test-data.json");

export interface WaterBetBuilderProps {}

export const WaterBetBuilder: React.FC<WaterBetBuilderProps> = (
  props: WaterBetBuilderProps
) => {
  const prefixes: string[] = [
    "I Believe that ",
    "The following team will: ",
    "The following player will: ",
    "This will happen by the end of the day: ",
    "This will happen by the end of the week: "
  ];

  const [activePrefix, setActivePrefix] = useState<string>(prefixes[0]);
  const [userDefinedWaterBet, setUserDefinedWaterBet] = useState<string>();

  const [groupData, setGroupData] = useState<Group[]>(data);
  const [selectedGroupId, setSelectedGroupId] = useState<string>();
  const [selectedUserId, setSelectedUserId] = useState<string>();

  const buildPrefixDropDownItems = (): JSX.Element => {
    const items = prefixes.map((text, index) => (
      <Dropdown.Item
        onClick={e => {
          setActivePrefix(text);
        }}
        key={index}
      >
        {text}
      </Dropdown.Item>
    ));
    return (
      <DropdownButton
        variant="outline-secondary"
        title="Prefixes"
        id="prefixes-dropdown-1"
      >
        {items}
      </DropdownButton>
    );
  };

  const buildGroupSelect = (): JSX.Element => {
    const selectOptions = (): JSX.Element[] | JSX.Element | null => {
      if (groupData != undefined && groupData != null)
        return groupData.map((group, index) => {
          return (
            <option key={index} value={group.groupId.toString()}>
              {group.groupName}
            </option>
          );
        });
      return null;
    };

    return (
      <Form.Select
        onChange={e => {
          setSelectedGroupId(e.target.value);
          setSelectedUserId("defaultValue");
        }}
        defaultValue={"defaultValue"}
      >
        <option value="defaultValue" disabled>
          Select a Group
        </option>
        {selectOptions()}
      </Form.Select>
    );
  };

  const buildUserSelect = (): JSX.Element => {
    const selectOptions = (): JSX.Element[] | JSX.Element | null => {
      if (selectedGroupId != undefined && selectedGroupId != null) {
        const groupMatch: Group = groupData.find(
          x => x.groupId == Number.parseInt(selectedGroupId)
        );
        return groupMatch.members.map((member, index) => {
          return (
            <option key={index} value={member.userId.toString()}>
              {member.userFullName}
            </option>
          );
        });
      }
      return null;
    };

    return (
      <Form.Select
        onChange={e => {
          setSelectedUserId(e.target.value);
        }}
        value={selectedUserId != undefined ? selectedUserId.toString() : null}
        defaultValue={"defaultValue"}
      >
        <option value="defaultValue" disabled>
          Select a User
        </option>
        {selectOptions()}
      </Form.Select>
    );
  };

  const handleSubmit = (e: any): void => {
    e.preventDefault();
  };

  return (
    <Page id="water-bet-builder" topPadding={true}>
      <Form onSubmit={handleSubmit}>
        <Row>
          <Col>
            <InputGroup className="mb-3">
              {buildPrefixDropDownItems()}
              <InputGroup.Text id="basic-addon2">
                {activePrefix}
              </InputGroup.Text>
              <Form.Control
                // as="textarea"
                aria-label="user-defined-water-bet"
                required
                type="text"
                value={userDefinedWaterBet}
                onChange={e => setUserDefinedWaterBet(e.target.value)}
              />
            </InputGroup>
          </Col>
        </Row>
        <Row>
          <Col md={4}>
            Group
            {buildGroupSelect()}
          </Col>
          <Col md={4}>
            Offer Water Bet to
            {buildUserSelect()}
          </Col>
          <Col md={2}>
            Set offer to Expire:{" "}
            <Form.Control
              type="date"
              id="start"
              name="trip-start"
              value="2022-06-25"
              min="2022-06-23"
              max="2022-12-31"
              onChange={e => {}}
            ></Form.Control>
          </Col>
        </Row>
        <Row>
          <Col className="submitCol">
            <Button id="submitBtn" type="submit">
              Send Offer
            </Button>
          </Col>
        </Row>
      </Form>
    </Page>
  );
};
