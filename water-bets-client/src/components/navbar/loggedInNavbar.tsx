import React from "react";
import Container from "react-bootstrap/Container";
import Navbar from "react-bootstrap/Navbar";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faGlassWaterDroplet } from "@fortawesome/free-solid-svg-icons";
import { faUserCircle } from "@fortawesome/free-solid-svg-icons";

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
  );
};
