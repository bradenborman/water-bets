import React from "react";
import { Page } from "../page/page";
import {
  Row,
  Col,
  Tabs,
  Tab,
  Table,
  Badge,
  DropdownButton,
  ButtonGroup,
  Dropdown
} from "react-bootstrap";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faMailForward, faMailBulk } from "@fortawesome/free-solid-svg-icons";
import { OffersReceived } from "./offerTable/offersReceived";

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
            transition={true}
            id="noanim-tab-example"
          >
            <Tab
              eventKey="myOffers"
              title={
                <>
                  <FontAwesomeIcon icon={faMailBulk} /> Offers Received{" "}
                  <span className="number-badge">3</span>
                </>
              }
            >
              {<OffersReceived />}
            </Tab>
            <Tab
              eventKey="mineSent"
              title={
                <>
                  <FontAwesomeIcon icon={faMailForward} /> Offers I sent{" "}
                  <span className="number-badge">1</span>
                </>
              }
            >
              <Table striped bordered hover>
                <thead>
                  <tr>
                    <th>To</th>
                    <th>Water Bet</th>
                    <th>My Cost</th>
                    <th>To Win</th>
                    <th>Expires</th>
                    <th></th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>Brendan Borman</td>
                    <td>Gabe Davis will be a pro bowler in 2022/23</td>
                    <td>5</td>
                    <td>5</td>
                    <td>21 Days</td>
                    <td>
                      <DropdownButton
                        as={ButtonGroup}
                        variant="link"
                        title="Reply"
                        id="bg-vertical-dropdown-1"
                      >
                        <Dropdown.Item eventKey="1">Accept Offer</Dropdown.Item>
                        <Dropdown.Item eventKey="2">Deline Offer</Dropdown.Item>
                      </DropdownButton>
                    </td>
                  </tr>
                </tbody>
              </Table>
            </Tab>
            <Tab eventKey="helpSettle" title={<>Help Settle</>}></Tab>
          </Tabs>
        </Col>
      </Row>
    </Page>
  );
};
