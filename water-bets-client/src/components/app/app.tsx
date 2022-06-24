import React from "react";
import {
  BrowserRouter as ReactRouter,
  Route as ReactRoute
} from "react-router-dom";

import { Login } from "../login/login";
import { HomePage } from "../homepage/homePage";
import { HowToPlay } from "../howtoplay/howtoplay";
import { GroupSearch } from "../groupsearch/groupsearch";
import { WaterBetBuilder } from "../waterbetbuilder/waterBetBuilder";
import { LeaderBoard } from "../leaderboard/leaderBoard";

require("./app.scss");

export interface AppProps {}

export const App: React.FC<AppProps> = (props: AppProps) => {
  return (
    <ReactRouter>
      <ReactRoute path="/login" component={Login} />
      <ReactRoute exact path={["/", "/home"]} component={HomePage} />
      <ReactRoute exact path="/how-to-play" component={HowToPlay} />
      <ReactRoute exact path="/group-search" component={GroupSearch} />
      <ReactRoute exact path="/create-water-bet" component={WaterBetBuilder} />
      <ReactRoute exact path="/leaderboard" component={LeaderBoard} />
    </ReactRouter>
  );
};
