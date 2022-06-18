import React from "react";

export interface WaterBetViewerProps {
  children: any;
}

export const WaterBetViewer: React.FC<WaterBetViewerProps> = (
  props: WaterBetViewerProps
) => {
  return <div id="water-bet-viewer">{props.children}</div>;
};
