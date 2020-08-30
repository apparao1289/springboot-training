package com.userservice.controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.userservice.entity.Attachment;
import com.userservice.form.UploadForm;
import com.userservice.service.AttachmentService;

@Controller
public class AttachmentController {

	private static final Logger logger = Logger.getLogger(AttachmentController.class);

	@Autowired
	private AttachmentService attachmentService;

	@RequestMapping("/previewDocument")
	public void download(@RequestParam("documentId") int documentId, HttpServletResponse response) {

		logger.info("DOCUMENT ID ::" + documentId);
		OutputStream out = null;
		try {
			Attachment doc = attachmentService.getPreviewAttachment(documentId);
			response.setHeader("Content-Disposition", "attachment;filename=" + doc.getDocumentName());
			response.setContentType(doc.getContentType());
			out = response.getOutputStream();
			FileCopyUtils.copy(doc.getFileContent(), out);
		} catch (Exception e) {
			logger.error("Exception occurred in download::" + e.getMessage());
		} finally {
			try {
				if (out != null) {
					out.flush();
					out.close();
				}
			} catch (Exception e) {
				logger.error("Exception occurred in finally::" + e.getMessage());
			}

		}

	}

	@RequestMapping(value = "/saveAttachments", method = RequestMethod.POST)
	public ModelAndView saveSCdocRequiredAttachment(@RequestParam("UploadDocumentFile") MultipartFile file) {

		Attachment attachment = new Attachment();
		UploadForm uploadForm = new UploadForm();
		try {
			logger.info("File name:" + file.getOriginalFilename());
			logger.info("File type:" + file.getContentType());
			logger.info("File size:" + file.getSize());
			logger.info("File size:" + file.getBytes());

			InputStream fileStreamContent = file.getInputStream();
			attachment.setDocumentName(file.getOriginalFilename());
			attachment.setFileContent(FileCopyUtils.copyToByteArray(fileStreamContent));
			attachment.setContentType(file.getContentType());
			attachment.setDocumentSize(file.getSize());

			// Invoke the service layer and save attachment.
			attachmentService.saveDocument(attachment);

			// Get the list of attachments.
			List<Attachment> attachments = attachmentService.getListofDocuments();
			uploadForm.setAttachmentList(attachments);

		} catch (Exception e) {
			logger.error("Exception occurred in saveSCdocRequiredAttachment::" + e.getMessage());
		}

		return new ModelAndView("attachmentList", "uploadForm", uploadForm);
	}
}
