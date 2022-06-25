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
import { OffersReceived } from "./offertabs/offersReceived";
import { OffersSent } from "./offertabs/offersSent";

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
              {<OffersSent />}
            </Tab>
            <Tab eventKey="helpSettle" title={<>Settle</>}></Tab>
          </Tabs>
        </Col>
      </Row>
    </Page>
  );
};
