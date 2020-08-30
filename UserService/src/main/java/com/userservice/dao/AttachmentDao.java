package com.userservice.dao;

import java.util.List;

import com.userservice.entity.Attachment;

public interface AttachmentDao {

	/**
	 * Gets the List of documents.
	 * 
	 * @return the List of documents
	 */
	List<Attachment> getListofDocuments();

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
}
