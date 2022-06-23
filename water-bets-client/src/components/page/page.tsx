import React, { useState, useEffect } from "react";
import { LoggedInNavbar } from "../navbar/loggedInNavbar";
import Container from "react-bootstrap/Container";
import classNames from "classnames/bind";

export interface PageProps {
  id: string;
  topPadding: boolean;
  children: any;
}

export const Page: React.FC<PageProps> = (props: PageProps) => {
  const [userFullName, setUserFullName] = useState<string>();

  useEffect(() => {
    setUserFullName("Logged in user");
  }, []);

  return (
    <>
      <LoggedInNavbar userSignedIn={userFullName} />
      <Container
        className={classNames("page", { "top-padding": props.topPadding })}
        id={props.id}
      >
        {props.children}
      </Container>
    </>
  );
};
