import UserPreview from "./userPreview";

export default interface Group {
  groupId: Number;
  groupName: string;
  maxDropletBet: Number;
  members: UserPreview[];
}
