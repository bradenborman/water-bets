import React, { useState, useRef } from "react";
import classNames from "classnames";

export interface WagerReviewProps {
  cost: number;
  payout: number;
  bet: string;
  from: string;
  actionDate: string;
}

/*
  might add a card footer and move all that down to bottom of card
*/

export const WagerReviewCard: React.FC<WagerReviewProps> = (
  props: WagerReviewProps
) => {
  const [acknowledge, setAcknowledge] = useState<boolean>(false);
  const [accepted, setAccepted] = useState<boolean>(false);

  const handleClick = (userAcceptedWager: boolean) => {
    setAccepted(userAcceptedWager);
    setAcknowledge(true);
  };

  const offer = (): JSX.Element => {
    const message = (): string => {
      if (acknowledge) {
        return `You've ${accepted ? "accpeted" : "declined"} ${
          props.from
        }'s offer!`;
      }
      return "You've recived a wager offer!";
    };

    return (
      <div
        className={classNames(
          "card",
          { acknowledged: acknowledge },
          { accepted: accepted }
        )}
      >
        <h2>{message()}</h2>
        <div>
          <span className="offerer">{props.from} offered:</span>
          <div className="bet">{props.bet}</div>
          <div className="money-details">
            <span className="spotlight cost">Cost:</span> $
            {props.cost.toLocaleString()}
            <br />
            <span className="spotlight payout">Payout:</span> $
            {props.payout.toLocaleString()}
          </div>
          <div className="warning-message">
            *If you accept this wager, ${props.cost.toLocaleString()} will be
            withdrawn from you reserves.
          </div>
        </div>
        <br />
        <button onClick={e => handleClick(true)}>Accept</button>
        <button onClick={e => handleClick(false)}>Decline</button>
        <div className="cash-animation">- ${props.cost}</div>
      </div>
    );
  };

  return <div className="water-bet-card">{offer()}</div>;
};
