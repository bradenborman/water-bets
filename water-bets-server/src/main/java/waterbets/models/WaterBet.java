package waterbets.models;

import waterbets.models.enums.AcceptanceStatus;
import waterbets.models.enums.BetStatus;
import waterbets.utilities.DateTimeUtility;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class WaterBet {

    private int groupId;
    private int offeringUsersId;
    private int receiversUserId;
    private String bet;
    private int wagerAmount;
    private AcceptanceStatus acceptanceStatus;
    private BetStatus betStatus;
    private String offeredTime;
    private String acceptByExpirationDate;
    private List<WaterBetComment> comments = new ArrayList<>();

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getOfferingUsersId() {
        return offeringUsersId;
    }

    public void setOfferingUsersId(int offeringUsersId) {
        this.offeringUsersId = offeringUsersId;
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

    public int getWagerAmount() {
        return wagerAmount;
    }

    public void setWagerAmount(int wagerAmount) {
        this.wagerAmount = wagerAmount;
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
            waterBet.setAcceptanceStatus(AcceptanceStatus.NOT_ACKNOWLEDGE);
        }

    }

}
