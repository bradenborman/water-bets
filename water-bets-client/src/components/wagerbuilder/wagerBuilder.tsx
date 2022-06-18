import React from "react";

export interface WagerBuilderProps {}

export const WagerBuilder: React.FC<WagerBuilderProps> = (
  props: WagerBuilderProps
) => {
  return (
    <div id="wager-builder">
      <h2>Wager Builder</h2>
      <form>
        To:
        <select>
          <option>Justin Nunn</option>
          <option>Erik Meyer</option>
          <option>Sean Noble</option>
          <option>Josh Huges</option>
          <option>Brendan Borman</option>
          <option>Zane Lavy</option>
        </select>
        <br />
        <textarea placeholder={"Jamar Chase will have 5 rec and 130 yards"} />
        <div className="risks">
          <div className="title">Winner's Payout</div>
          <div className="risk">
            Myself
            <br />
            $<input size={4} maxLength={4} />
          </div>
          <div className="risk">
            Them
            <br />
            $<input size={4} maxLength={4} />
          </div>
        </div>
        <button type="submit">Send Offer</button>
      </form>
    </div>
  );
};
