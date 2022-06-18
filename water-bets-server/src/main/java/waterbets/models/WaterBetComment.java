package waterbets.models;

public class WaterBetComment {

    private int commentId;

    private int authorUserId;
    private String author;
    private String comment;
    private String commentTimeStamp;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getComment() {
        return comment;
    }

    public int getAuthorUserId() {
        return authorUserId;
    }

    public void setAuthorUserId(int authorUserId) {
        this.authorUserId = authorUserId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCommentTimeStamp() {
        return commentTimeStamp;
    }

    public void setCommentTimeStamp(String commentTimeStamp) {
        this.commentTimeStamp = commentTimeStamp;
    }

}