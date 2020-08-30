package com.userservice.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.userservice.entity.Attachment;
import com.userservice.repository.AttachmentRepository;

@Repository
public class AttachmentDaoImpl implements AttachmentDao {

	@Autowired
	private AttachmentRepository attachmentRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ctl.dcma.dao.UserDao#getListofDocuments()
	 */
	public List<Attachment> getListofDocuments() {

		return attachmentRepository.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ctl.dcma.dao.UserDao#getPreviewAttachment(java.lang.Long)
	 */
	public Attachment getPreviewAttachment(int documentId) {

		Optional<Attachment> attachment = attachmentRepository.findById(documentId);

		return attachment.get();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ctl.dcma.dao.UserDao#saveDocument(com.ctl.dcma.model.Attachment)
	 */
	public boolean saveDocument(Attachment attachment) {

		attachmentRepository.save(attachment);

		return true;
	}

}
