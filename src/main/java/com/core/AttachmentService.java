package com.core;

import com.SGALogger;
import com.db.AttachmentDAO;

import java.util.List;

/**
 * Created by Jigar on 7/21/2016.
 */
public class AttachmentService extends SGALogger {

    public void attachBike(Attachment newAttachment){
        _log.info("hit attachment api "+newAttachment);
        AttachmentDAO attachmentDAO = new AttachmentDAO();
        attachmentDAO.attachBike(newAttachment);
    }

    /*public List<Bike> getAttachments() {
        AttachmentDAO attachmentDAO = new AttachmentDAO();
        return (List<Bike>) attachmentDAO.listAttachments();
    }*/

}
