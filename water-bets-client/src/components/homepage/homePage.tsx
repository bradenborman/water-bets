import React, { useState, useEffect } from "react";
import { Page } from "../page/page";
import { Row, Col, Tabs, Tab, Placeholder } from "react-bootstrap";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faMailForward, faMailBulk } from "@fortawesome/free-solid-svg-icons";
import { OffersReceived } from "./offertabs/offersReceived";
import { OffersSent } from "./offertabs/offersSent";
import { simulateWait } from "../../utilities/mockUtility";
import Loader from "react-loader-spinner";

export interface LandingPageProps {
  userSignedIn?: string;
}

export const HomePage: React.FC<LandingPageProps> = (
  props: LandingPageProps
) => {
  const [isLoading, setIsLoading] = useState<boolean>(false);

  //Load data via api
  useEffect(() => {
    setIsLoading(true);
    simulateWait(600).then(() => setIsLoading(false));
  }, []);

  const tabSections = (): JSX.Element => {
    if (isLoading)
      return (
        <div className="groupSearchLoading">
          <Loader type="ThreeDots" color="#00BFFF" height={80} width={80} />
        </div>
      );

    return (
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
    );
  };

  return (
    <Page id="home-page" topPadding={true}>
      <Row>
        <Col md={12}>{tabSections()}</Col>
      </Row>
    </Page>
  );
};
