import React from "react";
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import { WaterBetsNavbar } from "../navbar/waterBetsNavbar";

require("./app.scss");

export interface AppProps {}

export const App: React.FC<AppProps> = (props: AppProps) => {
  return (
    <>
      <WaterBetsNavbar userSignedIn="Braden Borman" />
      <Container fluid="md">
        <Row>
          <Col></Col>
        </Row>
      </Container>
    </>
  );
};
