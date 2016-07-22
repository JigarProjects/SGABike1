package com.core;

import com.SGALogger;
import com.db.AttachmentDAO;

import java.util.List;

/**
 * Created by Jigar on 7/21/2016.
 */
public class AttachmentService extends SGALogger {

    public AttachmentService()
    {
        System.out.println("Attachement Service test class called");
    }
    public void attachBike(Attachment newAttachment){
        _log.info("hit attachment api "+newAttachment);

        AttachmentDAO attachmentDAO = new AttachmentDAO();
        attachmentDAO.attachBike(newAttachment);
    }

    public void getAttachments() {
        System.out.println("teste");
        /*AttachmentDAO attachmentDAO = new AttachmentDAO();
        return (List<Bike>) attachmentDAO.listAttachments();*/
    }

}
