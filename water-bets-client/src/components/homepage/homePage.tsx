import React from "react";
import { Page } from "../page/page";
import { Nav, Badge, Row, Col, ListGroup } from "react-bootstrap";

export interface LandingPageProps {
  userSignedIn?: string;
}

export const HomePage: React.FC<LandingPageProps> = (
  props: LandingPageProps
) => {
  return (
    <Page id="home-page" topPadding={false}>
      <Nav className="justify-content-end" activeKey="/home">
        <Nav.Item>
          <Nav.Link href="/how-to-play" eventKey="htp">
            How to Play
          </Nav.Link>
        </Nav.Item>
        <Nav.Item>
          <Nav.Link href="/group-search" eventKey="gs">
            Group Search
          </Nav.Link>
        </Nav.Item>
        <Nav.Item>
          <Nav.Link href="/user/logout" eventKey="logout">
            Logout
          </Nav.Link>
        </Nav.Item>
      </Nav>
      <Row>
        <Col md={6}></Col>
      </Row>
    </Page>
  );
};
