import React from "react";
import {
  BrowserRouter as ReactRouter,
  Route as ReactRoute
} from "react-router-dom";

import { Login } from "../login/login";

require("./app.scss");

export interface AppProps {}

export const App: React.FC<AppProps> = (props: AppProps) => {
  return (
    <ReactRouter>
      <ReactRoute path={"/"}>
        <ReactRoute path={"login"} component={Login} />
      </ReactRoute>
    </ReactRouter>
  );
};
