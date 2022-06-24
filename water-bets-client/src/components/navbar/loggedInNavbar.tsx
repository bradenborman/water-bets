import React from "react";
import Container from "react-bootstrap/Container";
import Navbar from "react-bootstrap/Navbar";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faGlassWaterDroplet } from "@fortawesome/free-solid-svg-icons";
import { faUserCircle } from "@fortawesome/free-solid-svg-icons";
import { Nav, Dropdown, NavItem, NavLink, NavDropdown } from "react-bootstrap";
import { Link } from "react-router-dom";

export interface LoggedInNavbarProps {
  userSignedIn?: string;
}

export const LoggedInNavbar: React.FC<LoggedInNavbarProps> = (
  props: LoggedInNavbarProps
) => {
  const signedInText = (): JSX.Element => {
    if (props.userSignedIn == undefined || props.userSignedIn == null) {
      return <Navbar.Text>...</Navbar.Text>;
    }
    return (
      <Navbar.Text>
        {" "}
        <FontAwesomeIcon className="fa-user-alt" icon={faUserCircle} />{" "}
        {props.userSignedIn}
      </Navbar.Text>
    );
  };

  return (
    <>
      <Navbar id="navbar">
        <Container>
          <Navbar.Brand href="/">
            <FontAwesomeIcon
              className="fa-water-icon"
              icon={faGlassWaterDroplet}
            />{" "}
            Water Bets
          </Navbar.Brand>
          <Navbar.Toggle />
          <Navbar.Collapse className="justify-content-end">
            {signedInText()}
          </Navbar.Collapse>
        </Container>
      </Navbar>
      <Container>
        <Nav justify variant="tabs">
          <Nav.Item>
            <Nav.Link href="/home">Open Bets</Nav.Link>
          </Nav.Item>
          <Nav.Item>
            <Nav.Link href="/create-water-bet">Create Water Bet</Nav.Link>
          </Nav.Item>
          <Nav.Item>
            <Nav.Link href="/leaderboard">Leaderboards</Nav.Link>
          </Nav.Item>
          <NavDropdown title="More" id="nav-dropdown">
            <NavDropdown.Item href="/how-to-play">How to Play</NavDropdown.Item>
            <NavDropdown.Item href="/group-search">
              Group Search
            </NavDropdown.Item>
            <NavDropdown.Item href="/closed-bets">Closed Bets</NavDropdown.Item>
            <NavDropdown.Divider />
            <NavDropdown.Item href="/logout">Logout</NavDropdown.Item>
          </NavDropdown>
        </Nav>
      </Container>
    </>
  );
};
