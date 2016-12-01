package de.appsist.service.cns.utils;

import de.appsist.service.cns.model.ContentStructure;

/**
 * Created by glenn on 23.09.15.
 */
public class ContentStructureReader {


    /**
     * this method reads a content structure (json or bpmn or BT) from file and
     * creates, returns a contentStructure-Instance
     *
     * content structure files are somehow stored in file system, files are referenced by
     * their processId
     *
     * @param processId
     * @return
     */
    public static ContentStructure getContentStructureFromFile( String processId ) {

        ContentStructure contentStructure = new ContentStructure( processId );
        String pId = processId.substring(processId.lastIndexOf("/") + 1);
        contentStructure.appendContentNode(pId, "APPsist Wissen");
        
        return contentStructure;
    }

}
