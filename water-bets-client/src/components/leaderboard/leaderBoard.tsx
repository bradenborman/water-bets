import React from "react";
import { Page } from "../page/page";

export interface LeaderBoardProps {}

export const LeaderBoard: React.FC<LeaderBoardProps> = (
  props: LeaderBoardProps
) => {
  return <Page id="leaderboard-page" topPadding={true}></Page>;
};
