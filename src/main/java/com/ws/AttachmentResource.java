package com.ws;

import com.core.Attachment;
import com.core.AttachmentService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Jigar on 7/21/2016.
 */
@Path("attachment")
@Produces(MediaType.APPLICATION_JSON)
public class AttachmentResource {
    AttachmentService attachmentService = new AttachmentService();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Attachment attachBike(Attachment newAttachment) {
        //System.out.println("hit there ");
        attachmentService.attachBike(newAttachment);
        return (new Attachment(0, 0));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Attachment> getAttachments() {
        return attachmentService.getAttachments();
    }

    @DELETE
    @Path("/{attachmentID}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteAttachment(@PathParam("attachmentID") int deletedId) {
        System.out.println("detechment intiation" + deletedId);
        attachmentService.deleteAttachment(deletedId);
    }

    @PUT
    @Path("/{attachmentID}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Attachment updateAttachment(Attachment updatedAttachment) {

        //return bs.updateBike(updatedBike);
        return new Attachment(0, 0);
    }

}
