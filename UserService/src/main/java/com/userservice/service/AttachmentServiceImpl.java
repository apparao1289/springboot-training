package com.userservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.userservice.dao.AttachmentDao;
import com.userservice.entity.Attachment;

@Service
public class AttachmentServiceImpl implements AttachmentService {

	@Autowired
	private AttachmentDao attachmentDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ctl.dcma.service.UserService#getListofDocuments()
	 */
	public List<Attachment> getListofDocuments() {
		return attachmentDao.getListofDocuments();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ctl.dcma.service.UserService#getPreviewAttachment(java.lang.Long)
	 */
	public Attachment getPreviewAttachment(int documentId) {
		return attachmentDao.getPreviewAttachment(documentId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ctl.dcma.service.UserService#saveDocument(com.ctl.dcma.model.Attachment)
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
	public boolean saveDocument(Attachment attachment) {
		return attachmentDao.saveDocument(attachment);
	}
}
