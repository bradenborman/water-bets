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
          <Nav.Link href="/user/logout" eventKey="htp">
            {" "}
            Logout
          </Nav.Link>
        </Nav.Item>
      </Nav>
      <Row>
        <Col md={6}>
          <ListGroup as="ol">
            <ListGroup.Item className="d-flex justify-content-between align-items-start">
              <div className="ms-2 me-auto">
                <div className="fw-bold">Not Arizona State</div>
                <span className="attention-needed">Attention is needed</span>
              </div>
              <Badge bg="warning" pill>
                5
              </Badge>
            </ListGroup.Item>
            <ListGroup.Item className="d-flex justify-content-between align-items-start">
              <div className="ms-2 me-auto">
                <div className="fw-bold">Shelter - Piano Man</div>
                <span className="attention-needed">Attention is needed</span>
              </div>
              <Badge bg="warning" pill>
                4
              </Badge>
            </ListGroup.Item>
            <ListGroup.Item className="d-flex justify-content-between align-items-start">
              <div className="ms-2 me-auto">
                <div className="fw-bold">Geek Squad</div>
                All caught up
              </div>
              <Badge bg="success" pill>
                0
              </Badge>
            </ListGroup.Item>
          </ListGroup>
        </Col>
      </Row>
    </Page>
  );
};
