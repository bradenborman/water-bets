import React from "react";
import { LoggedInNavbar } from "../navbar/loggedInNavbar";
import Container from "react-bootstrap/Container";

export interface PageProps {
  id: string;
  children: any;
}

export const Page: React.FC<PageProps> = (props: PageProps) => {
  return (
    <>
      <LoggedInNavbar userSignedIn="Braden Borman" />
      <Container className="page" id={props.id}>
        {props.children}
      </Container>
    </>
  );
};
