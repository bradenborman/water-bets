import React, { useState } from "react";
import { Page } from "../page/page";
import {
  InputGroup,
  DropdownButton,
  Dropdown,
  Form,
  Row,
  Col,
  Button,
  Card
} from "react-bootstrap";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faGlassWaterDroplet,
  faDroplet
} from "@fortawesome/free-solid-svg-icons";
import Group from "../../models/group";
import isValidWagerInput from "../../utilities/validWagerEntryUtility";
import {
  threeHoursFromNow,
  rightNow,
  weekFromNow
} from "../../utilities/dataTimeUtility";

var data: Group[] = require("./test-data.json");

export interface WaterBetBuilderProps {}

export const WaterBetBuilder: React.FC<WaterBetBuilderProps> = (
  props: WaterBetBuilderProps
) => {
  const prefixes: string[] = [
    "I Believe that ",
    "The following team will: ",
    "The following player will: ",
    "By the end of the day, the following will happen: ",
    "By the end of the week, the following will happen: "
  ];

  const [activePrefix, setActivePrefix] = useState<string>(prefixes[0]);
  const [userDefinedWaterBet, setUserDefinedWaterBet] = useState<string>();

  const [groupData, setGroupData] = useState<Group[]>(data);

  const [selectedGroupId, setSelectedGroupId] = useState<string>(
    "defaultValue"
  );
  const [selectedUserId, setSelectedUserId] = useState<string>("defaultValue");

  const [offerersWagerAmount, setOfferersWagerAmount] = useState<string>("0");
  const [receiversWagerAmount, setReceiversWagerAmount] = useState<string>("0");
  const [offerExpires, setOfferExpires] = useState<string>(threeHoursFromNow());

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
        variant="secondary"
        title="Prefixes"
        id="prefixes-dropdown-1"
      >
        {items}
      </DropdownButton>
    );
  };

  const buildGroupSelect = (): JSX.Element => {
    const selectOptions = (): JSX.Element[] | JSX.Element | null => {
      if (groupData != undefined && groupData != null && selectedGroupId)
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
      if (
        selectedGroupId != undefined &&
        selectedGroupId != null &&
        selectedGroupId != "defaultValue"
      ) {
        const groupMatch: Group = groupData.find(
          x => x.groupId == Number.parseInt(selectedGroupId)
        );
        return groupMatch.members.map((member, index) => {
          return (
            <option key={index} value={member.userId.toString()}>
              {`${member.userFullName} \(${member.totalPoolValue})`}
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
      >
        <option value="defaultValue" disabled>
          Select a User
        </option>
        {selectOptions()}
      </Form.Select>
    );
  };

  const handleOfferersWagerChange = (e: any): void => {
    if (isValidWagerInput(e.target.value)) {
      setOfferersWagerAmount(e.target.value);
    }
  };

  const handleRecieversWagerChange = (e: any): void => {
    if (e.target.value.length == 0) setReceiversWagerAmount("");

    //Null safe due to disabled on input
    const groupMatch: Group = groupData.find(
      x => x.groupId == Number.parseInt(selectedGroupId)
    );
    const maxUserHasToWager: Number = groupMatch.members.find(
      y => y.userId == Number.parseInt(selectedUserId)
    ).totalPoolValue;

    //Valid chars && user has at least that much
    if (
      isValidWagerInput(e.target.value) &&
      maxUserHasToWager >= Number.parseInt(e.target.value)
    ) {
      setReceiversWagerAmount(e.target.value);
    }
  };

  const handleSubmit = (e: any): void => {
    e.preventDefault();
  };

  return (
    <Page id="water-bet-builder" topPadding={true}>
      <Form onSubmit={handleSubmit}>
        <Row className="mt-3">
          <Col>
            <InputGroup>
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
        <Row className="mt-3">
          <Col md={4}>
            Group
            {buildGroupSelect()}
          </Col>
          <Col md={4}>
            Offer Water Bet to
            {buildUserSelect()}
          </Col>
          <Col md={3}>
            Set offer to Expire:{" "}
            <Form.Control
              required
              type="datetime-local"
              id="expirationDatetime"
              min={rightNow()}
              max={weekFromNow()}
              value={offerExpires}
              onChange={e => {
                setOfferExpires(e.target.value);
              }}
            ></Form.Control>
          </Col>
        </Row>
        <Row className="mt-3">
          <Col md={4}>
            <Form.Label>Droplets I want to wager</Form.Label>
            <InputGroup>
              <InputGroup.Text id="my-wager">
                <FontAwesomeIcon className="fa-droplet" icon={faDroplet} />
              </InputGroup.Text>
              <Form.Control
                className="wager-input"
                type="text"
                value={offerersWagerAmount}
                onChange={handleOfferersWagerChange}
                aria-label="Droplets I want to wager"
                aria-describedby="my-wager"
              />
            </InputGroup>
          </Col>
          <Col md={4}>
            <Form.Label>Droplets I would win</Form.Label>
            <InputGroup>
              <InputGroup.Text id="their-wager">
                <FontAwesomeIcon className="fa-droplet" icon={faDroplet} />
              </InputGroup.Text>
              <Form.Control
                className="wager-input"
                type="text"
                disabled={!(Number.parseInt(selectedUserId) > 0)}
                value={receiversWagerAmount}
                onChange={handleRecieversWagerChange}
                aria-label="Droplets I would win"
                aria-describedby="their-wager"
              />
            </InputGroup>
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
