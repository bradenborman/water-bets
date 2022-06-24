import React from "react";
import { Page } from "../page/page";
import {
  Nav,
  Badge,
  Row,
  Col,
  ListGroup,
  Tabs,
  Tab,
  Table
} from "react-bootstrap";

export interface LandingPageProps {
  userSignedIn?: string;
}

export const HomePage: React.FC<LandingPageProps> = (
  props: LandingPageProps
) => {
  return (
    <Page id="home-page" topPadding={true}>
      <Row>
        <Col md={12}>
          <Tabs
            defaultActiveKey="myOffers"
            transition={false}
            id="noanim-tab-example"
            className="mb-3"
          >
            <Tab eventKey="myOffers" title="Offered to Me">
              <Table striped bordered hover>
                <thead>
                  <tr>
                    <th>#</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Username</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>1</td>
                    <td>Mark</td>
                    <td>Otto</td>
                    <td>@mdo</td>
                  </tr>
                  <tr>
                    <td>2</td>
                    <td>Jacob</td>
                    <td>Thornton</td>
                    <td>@fat</td>
                  </tr>
                  <tr>
                    <td>3</td>
                    <td colSpan={2}>Larry the Bird</td>
                    <td>@twitter</td>
                  </tr>
                </tbody>
              </Table>
            </Tab>
            <Tab eventKey="mineSent" title="Offers I sent">
              <Table striped bordered hover>
                <thead>
                  <tr>
                    <th>#</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Username</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>1</td>
                    <td>Mark</td>
                    <td>Otto</td>
                    <td>@mdo</td>
                  </tr>
                </tbody>
              </Table>
            </Tab>
            <Tab eventKey="helpSettle" title="Help Settle">
              <h3>
                Please review the water bets below as they two parties involved
                disagreed on the winner.
              </h3>
            </Tab>
          </Tabs>
        </Col>
      </Row>
    </Page>
  );
};
