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
import { Login } from "../login/login";

require("./app.scss");

export interface AppProps {}

export const App: React.FC<AppProps> = (props: AppProps) => {
  return (
    <>
      <ReactRouter>
        <ReactRoute path={"/"} exact>
          <>test</>
        </ReactRoute>
        <ReactRoute path={"/login"} component={Login} />
      </ReactRouter>
    </>
  );
};
