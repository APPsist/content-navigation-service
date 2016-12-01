package de.appsist.service.cns.model;

/**
 * Created by glenn on 24.09.15.
 */
public class ContentNode {


    private String contentId;
    private String title;

    private boolean done;

    private ContentNode nextNode;
    private ContentNode previousNode;


    public ContentNode( String contentId, String title ) {

        this.contentId = contentId;
        this.title = title;

        done = false;

    }


    public String getTitle() {
        return title;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public ContentNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(ContentNode nextNode) {
        this.nextNode = nextNode;
    }

    public ContentNode getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(ContentNode previousNode) {
        this.previousNode = previousNode;
    }

    public boolean hasPrevious() {
        return previousNode != null;
    }

    public boolean hasNext() {
        return nextNode != null;
    }
}
