import React from "react";
import { WagerBuilder } from "../wagerbuilder/wagerBuilder";
import { WagerReviewCard } from "../wagerreview/wagerReviewCard";
import { WaterBetViewer } from "../wagebetviewer/WaterBetViewer";

require("./app.scss");

export interface AppProps {}

export const App: React.FC<AppProps> = (props: AppProps) => {
  return (
    <>
      {/* <WagerBuilder /> */}
      <WaterBetViewer>
        <WagerReviewCard
          cost={100}
          payout={1000}
          from={"Zane Lavy"}
          bet={
            "Jamar Chase will have 2 tds and 100 rec-yards AND Tom Brady will throw for 5 tds"
          }
          actionDate="12/4/22"
        />
        <WagerReviewCard
          cost={500}
          payout={500}
          from={"Erik Meyer"}
          bet={"Tua will throw for 200 yards. Rush for 45"}
          actionDate="12/4/22"
        />
      </WaterBetViewer>
    </>
  );
};
