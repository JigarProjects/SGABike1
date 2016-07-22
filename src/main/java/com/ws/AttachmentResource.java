package com.ws;

import com.core.Attachment;
import com.core.AttachmentService;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by Jigar on 7/21/2016.
 */
@Path("attachment")
@Produces(MediaType.APPLICATION_JSON)
public class AttachmentResource {
    AttachmentService attachmentService = new AttachmentService();

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Attachment attachBike(Attachment newAttachment) {
        System.out.println("hit there ");
        attachmentService.attachBike(newAttachment);
        return  new Attachment(0,0);
    }

    /*@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Attachment> getBikes() {
        return attachmentService.getBikes();
    }
*/
}
