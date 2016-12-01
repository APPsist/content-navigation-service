package de.appsist.test.cns.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.appsist.service.cns.model.ContentStructure;

/**
 * Created by glenn on 24.09.15.
 */
public class ContentStructureTests {

    @Before
    public void setUp() throws Exception {



    }

    @After
    public void tearDown() throws Exception {

    }



    @Test
    public void testNavigation() throws Exception {

        ContentStructure sevenSteps = new ContentStructure( "ProcessId-1" );
        sevenSteps.appendContentNode( "FirstStepId", "First Step" );
        sevenSteps.appendContentNode( "SecondStepId", "Second Step" );
        sevenSteps.appendContentNode( "ThirdStepId", "Third Step" );
        sevenSteps.appendContentNode( "FourthStepId", "Fourth Step" );


        assert sevenSteps.getCurrentNode().getContentId().equals( "FirstStepId" );
        assert sevenSteps.getCurrentNode().getPreviousNode() == null;
        assert sevenSteps.getFirstContentNode().getContentId().equals( "FirstStepId" );

        // step ahead
        sevenSteps.setContentNodeAsDone(sevenSteps.getCurrentNode());
        assert sevenSteps.getCurrentNode().getContentId().equals( "SecondStepId" );
        assert sevenSteps.getFirstContentNode().getContentId().equals( "FirstStepId" );

        // step back
        sevenSteps.stepBackToNode(sevenSteps.getCurrentNode().getPreviousNode());
        assert sevenSteps.getCurrentNode().getContentId().equals( "FirstStepId" );

        // step ahead
        sevenSteps.setContentNodeAsDone(sevenSteps.getCurrentNode());
        assert sevenSteps.getCurrentNode().getContentId().equals( "SecondStepId" );

        // step ahead
        sevenSteps.setContentNodeAsDone( sevenSteps.getCurrentNode() );
        assert sevenSteps.getCurrentNode().getContentId().equals( "ThirdStepId" );

        // step ahead
        sevenSteps.setContentNodeAsDone( sevenSteps.getCurrentNode() );
        assert sevenSteps.getCurrentNode().getContentId().equals( "FourthStepId" );

        // step ahead
        sevenSteps.setContentNodeAsDone( sevenSteps.getCurrentNode() );
        assert sevenSteps.getCurrentNode() == null;

        // step ahead
        sevenSteps.setContentNodeAsDone( sevenSteps.getCurrentNode() );
        assert sevenSteps.getCurrentNode() == null;


        // step back to second
        sevenSteps.stepBackToNode(sevenSteps.getFirstContentNode().getNextNode());
        assert sevenSteps.getCurrentNode().getContentId().equals( "SecondStepId" );

    }

    @Test
    public void testNullNavigation() throws Exception {

        ContentStructure zero = new ContentStructure( "Hua!" );

        assert zero.getCurrentNode() == null;
        assert zero.getFirstContentNode() == null;

    }



}
