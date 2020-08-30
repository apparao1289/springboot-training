package com.userservice.service;

import java.util.List;

import com.userservice.entity.Attachment;

public interface AttachmentService {

	/**
	 * Gets the preview attachment.
	 * 
	 * @param documentId the document id
	 * @return the preview attachment
	 */
	Attachment getPreviewAttachment(int documentId);

	/**
	 * Save document.
	 * 
	 * @param attachment the attachment
	 * @return true, if successful
	 */
	boolean saveDocument(Attachment attachment);

	/**
	 * Gets the List of documents.
	 * 
	 * @return the List of documents
	 */
	List<Attachment> getListofDocuments();

}
