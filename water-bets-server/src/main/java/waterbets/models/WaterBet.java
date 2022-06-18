package waterbets.models;

import waterbets.models.enums.AcceptanceStatus;
import waterbets.models.enums.BetStatus;
import waterbets.models.enums.WaterBetWinner;
import waterbets.utilities.DateTimeUtility;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class WaterBet {

    private int waterBetId;
    private int groupId;
    private int offerersUsersId;
    private int receiversUserId;
    private String bet;
    private int offerersDropletsOnTheLine;
    private int recipientDropletsOnTheLine;
    private AcceptanceStatus acceptanceStatus;
    private BetStatus betStatus;
    private String offeredTime;
    private String acceptByExpirationDate;

    private WaterBetWinner offerersPick;
    private WaterBetWinner receiversPick;
    private WaterBetWinner decidedWinner;

    private List<WaterBetComment> comments = new ArrayList<>();

    public int getWaterBetId() {
        return waterBetId;
    }

    public void setWaterBetId(int waterBetId) {
        this.waterBetId = waterBetId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getOfferersUsersId() {
        return offerersUsersId;
    }

    public void setOfferersUsersId(int offerersUsersId) {
        this.offerersUsersId = offerersUsersId;
    }

    public int getReceiversUserId() {
        return receiversUserId;
    }

    public void setReceiversUserId(int receiversUserId) {
        this.receiversUserId = receiversUserId;
    }

    public String getBet() {
        return bet;
    }

    public void setBet(String bet) {
        this.bet = bet;
    }

    public int getOfferersDropletsOnTheLine() {
        return offerersDropletsOnTheLine;
    }

    public void setOfferersDropletsOnTheLine(int offerersDropletsOnTheLine) {
        this.offerersDropletsOnTheLine = offerersDropletsOnTheLine;
    }

    public int getRecipientDropletsOnTheLine() {
        return recipientDropletsOnTheLine;
    }

    public int getTotalDropletsOnTheLine() {
        return recipientDropletsOnTheLine + offerersDropletsOnTheLine;
    }

    public void setRecipientDropletsOnTheLine(int recipientDropletsOnTheLine) {
        this.recipientDropletsOnTheLine = recipientDropletsOnTheLine;
    }

    public AcceptanceStatus getAcceptanceStatus() {
        return acceptanceStatus;
    }

    public void setAcceptanceStatus(AcceptanceStatus acceptanceStatus) {
        this.acceptanceStatus = acceptanceStatus;
    }

    public BetStatus getBetStatus() {
        return betStatus;
    }

    public void setBetStatus(BetStatus betStatus) {
        this.betStatus = betStatus;
    }

    public String getOfferedTime() {
        return offeredTime;
    }

    public void setOfferedTime(String offeredTime) {
        this.offeredTime = offeredTime;
    }

    public String getAcceptByExpirationDate() {
        return acceptByExpirationDate;
    }

    public void setAcceptByExpirationDate(String acceptByExpirationDate) {
        this.acceptByExpirationDate = acceptByExpirationDate;
    }

    public WaterBetWinner getOfferersPick() {
        return offerersPick;
    }

    public void setOfferersPick(WaterBetWinner offerersPick) {
        this.offerersPick = offerersPick;
    }

    public WaterBetWinner getReceiversPick() {
        return receiversPick;
    }

    public void setReceiversPick(WaterBetWinner receiversPick) {
        this.receiversPick = receiversPick;
    }

    public WaterBetWinner getDecidedWinner() {
        return decidedWinner;
    }

    public void setDecidedWinner(WaterBetWinner decidedWinner) {
        this.decidedWinner = decidedWinner;
    }

    public List<WaterBetComment> getComments() {
        return comments;
    }

    public void setComments(List<WaterBetComment> comments) {
        this.comments = comments;
    }

    public void addComment(WaterBetComment comment) {
        comments.add(comment);
    }

    public WaterBetInitializer initializer() {
        return new WaterBetInitializer(this);
    }

    public static class WaterBetInitializer {

        private final WaterBet waterBet;

        public WaterBetInitializer(WaterBet waterBet) {
            this.waterBet = waterBet;
        }

        public void initializeNewWaterBet() {
            initializeOfferedTime();
            initializeBetStatus();
            initializeAcceptanceStatusTime();
        }

        private void initializeOfferedTime() {
            waterBet.setOfferedTime(DateTimeUtility.toStandardStorageFormat(LocalDateTime.now()));
        }

        private void initializeBetStatus() {
            waterBet.setBetStatus(BetStatus.OPEN);
        }

        private void initializeAcceptanceStatusTime() {
            waterBet.setAcceptanceStatus(AcceptanceStatus.NOT_ACKNOWLEDGED);
        }

    }

}
