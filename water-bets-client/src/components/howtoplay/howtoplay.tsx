import React from "react";
import { Page } from "../page/page";
import { Row, Col, Accordion } from "react-bootstrap";
import HowToPlayItem from "../../models/howToPlayItem";

var data: HowToPlayItem[] = require("./how-to-play-items.json");

export const HowToPlay: React.FC<any> = (props: {}) => {
  const howToPlayAccordionItems: JSX.Element[] = data.map((item, index) => {
    return (
      <Accordion.Item eventKey={index.toString()}>
        <Accordion.Header>{item.title}</Accordion.Header>
        <Accordion.Body>{item.value}</Accordion.Body>
      </Accordion.Item>
    );
  });

  return (
    <Page id="how-to-play-page" topPadding={true}>
      <Row>
        <Col>
          <h2 id="how-to-play-header">How to play</h2>
          <Accordion defaultActiveKey="0">{howToPlayAccordionItems}</Accordion>
        </Col>
      </Row>
    </Page>
  );
};
