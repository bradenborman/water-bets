import React from "react";
import { Page } from "../page/page";

export interface ClosedBetsProps {}

export const ClosedBets: React.FC<ClosedBetsProps> = (
  props: ClosedBetsProps
) => {
  return (
    <Page id="closed-bets-page" topPadding={true}>
      <h2>Closed Bets</h2>
    </Page>
  );
};
