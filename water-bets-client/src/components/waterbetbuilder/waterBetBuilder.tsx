import React, { useState } from "react";
import { Page } from "../page/page";
import {
  InputGroup,
  DropdownButton,
  Dropdown,
  Form,
  Row,
  Col
} from "react-bootstrap";

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
        variant="outline-dark"
        title="Prefixes"
        id="prefixes-dropdown-1"
      >
        {items}
      </DropdownButton>
    );
  };

  const handleSubmit = (e: any): void => {
    e.preventDefault();
    alert(activePrefix + userDefinedWaterBet);
  };

  return (
    <Page id="water-bet-builder" topPadding={true}>
      <Form onSubmit={handleSubmit}>
        <Row>
          <Col md={10}>
            <InputGroup className="mb-3">
              {buildPrefixDropDownItems()}
              <InputGroup.Text id="basic-addon2">
                {activePrefix}
              </InputGroup.Text>
              <Form.Control
                as="textarea"
                aria-label="user-defined-water-bet"
                required
                type="textarea"
                value={userDefinedWaterBet}
                onChange={e => setUserDefinedWaterBet(e.target.value)}
              />
            </InputGroup>
          </Col>
          <Col md={2}>
            Set offer to Expire:{" "}
            <Form.Control
              type="date"
              id="start"
              name="trip-start"
              value="2018-07-22"
              min="2018-01-01"
              max="2018-12-31"
            ></Form.Control>
          </Col>
        </Row>
      </Form>
    </Page>
  );
};
