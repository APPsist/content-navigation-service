package de.appsist.service.cns.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by glenn on 23.09.15.
 *
 * in this initial step this structure holds lists of content ids
 *
 * in the future this stucture represents a process structure like
 *  - a BPMN can express, or
 *  - a Behavoiur Tree
 *
 *
 */
public class ContentStructure {


    private String processId;

    private List<ContentNode> contentNodes;

    private ContentNode currentNode;

    private ContentNode firstNode;



    public ContentStructure( String processId ) {

        this.processId = processId;
        contentNodes = new ArrayList<ContentNode>();

    }

    public void appendContentNode( String contentId, String title ) {

        ContentNode contentNode = new ContentNode( contentId, title );

        if ( contentNodes.size() == 0 ) {

            firstNode = contentNode;
            currentNode = contentNode;

        } else {

            ContentNode previousNode = contentNodes.get( contentNodes.size() - 1 );
            contentNode.setPreviousNode( previousNode );
            previousNode.setNextNode( contentNode );

        }
        contentNodes.add( contentNode );

    }

    public ContentNode getCurrentNode() {
        return currentNode;
    }

    public ContentNode getNextContentNode() {
        return currentNode.getNextNode();
    }

    public ContentNode getPreviousContentNode() {
        return currentNode.getPreviousNode();
    }

    public ContentNode getFirstContentNode() {
        return firstNode;
    }



    public void setContentNodeAsDone( ContentNode node ) {

        if ( node != null ) {

            node.setDone( true );

            if ( node.hasNext() ) {
                currentNode = node.getNextNode();
            } else {
                currentNode = null;
            }


            while ( node.hasPrevious() ) {

                node = node.getPreviousNode();
                node.setDone( true );

            }

        }

    }

    public void stepBackToFirstNod() {
        stepBackToNode( firstNode );
    }

    public void stepBackToNode( ContentNode node ) {

        node.setDone( false );

        currentNode = node;

        while ( node.hasNext() ) {

            node = node.getNextNode();
            node.setDone( false );

        }

    }





}
