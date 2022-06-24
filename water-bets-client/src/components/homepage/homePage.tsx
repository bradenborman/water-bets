import React from "react";
import { Page } from "../page/page";
import { Row, Col, Tabs, Tab, Table, Badge } from "react-bootstrap";
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
                  <span className="number-badge">1</span>
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
                  <span className="number-badge">3</span>
                </>
              }
            >
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
            <Tab eventKey="helpSettle" title={<>Help Settle</>}></Tab>
          </Tabs>
        </Col>
      </Row>
    </Page>
  );
};
