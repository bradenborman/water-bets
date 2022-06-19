import React from "react";
import {
  BrowserRouter as ReactRouter,
  Route as ReactRoute
} from "react-router-dom";

import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Button from "react-bootstrap/Button";
import Card from "react-bootstrap/Card";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faHelmetSafety } from "@fortawesome/free-solid-svg-icons";

import { LoggedInNavbar } from "../navbar/loggedInNavbar";

export interface LoginProps {}

export const Login: React.FC<LoginProps> = (props: LoginProps) => {
  return (
    <>
      <Container fluid="md">
        <br />
        <br />
        <Row>
          <Col>
            <Card>
              <Card.Header>
                <FontAwesomeIcon
                  className="fa-helmet-safety"
                  icon={faHelmetSafety}
                />{" "}
                Under Contruction
              </Card.Header>
              <Card.Body>
                <Card.Title>Coming Soon..</Card.Title>
                <Card.Text>
                  <br />
                  Water Bets is a platform that enables groups of people to send
                  friendly no risk bets on anything they want.
                  <br />
                  <br />
                  Each user has 'droplets' as thier value. Users can create a
                  bet and choose to offer to anyone else in the group, where
                  from there the receiver of the bet may accept or decline. Bets
                  are entered in a free form text, along with the droplets on
                  the line. This is like setting your own odds as you set how
                  much each player must wager. The Winner is decided when both
                  users agree on the same player - otherwise, it is thrown to
                  the group to settle.
                </Card.Text>
              </Card.Body>
            </Card>
          </Col>
        </Row>
      </Container>
    </>
  );
};
