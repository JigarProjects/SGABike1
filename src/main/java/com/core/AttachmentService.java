package com.core;

import com.SGALogger;
import com.db.AttachmentDAO;

import java.util.List;

/**
 * Created by Jigar on 7/21/2016.
 */
public class AttachmentService extends SGALogger {

    public AttachmentService() {
        System.out.println("Attachement Service test class called");
    }

    public void attachBike(Attachment newAttachment) {
        _log.info("hit attachment api " + newAttachment);

        AttachmentDAO attachmentDAO = new AttachmentDAO();
        attachmentDAO.attachBike(newAttachment);
    }

    public List<Attachment> getAttachments() {

        AttachmentDAO attachmentDAO = new AttachmentDAO();
        return (List<Attachment>) attachmentDAO.listAttachments();
    }

    public void deleteAttachment(int deletedId) {
        System.out.println("in delete attachment from service");
        AttachmentDAO attachmentDAO = new AttachmentDAO();
        attachmentDAO.detachBike(deletedId);
    }
}
