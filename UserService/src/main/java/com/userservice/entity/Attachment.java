package com.userservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * The Class Attachment.
 */
@Entity
@Table(name="attachment")
@javax.persistence.SequenceGenerator(name="SEQ_STORE",sequenceName="ATTACHMENT_UPLOAD_SEQ", allocationSize=1
)
public class Attachment {

    /** The document id. */
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_STORE")
    @Column(name = "document_id", length = 10)
    private int documentId;
    
    /** The document name. */
    @Column(name = "document_name", length = 100)
    private String documentName;
    
    /** The document size. */
    @Column(name = "document_size", length = 20)
    private long documentSize;
    
    /** The content type. */
    @Column(name = "content_type", length = 20)
    private String contentType;
    
    /** The file content. */
    @Column(name = "file_content")
    @Lob
    private byte[] fileContent;

    /**
     * Gets the document id.
     * 
     * @return the document id
     */
    public int getDocumentId() {
        return documentId;
    }

    /**
     * Sets the document id.
     * 
     * @param documentId the new document id
     */
    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    /**
     * Gets the document name.
     * 
     * @return the document name
     */
    public String getDocumentName() {
        return documentName;
    }

    /**
     * Sets the document name.
     * 
     * @param documentName the new document name
     */
    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    /**
     * Gets the document size.
     * 
     * @return the document size
     */
    public long getDocumentSize() {
        return documentSize;
    }

    /**
     * Sets the document size.
     * 
     * @param documentSize the new document size
     */
    public void setDocumentSize(long documentSize) {
        this.documentSize = documentSize;
    }

    /**
     * Gets the content type.
     * 
     * @return the content type
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * Sets the content type.
     * 
     * @param contentType the new content type
     */
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    /**
     * Gets the file content.
     * 
     * @return the file content
     */
    public byte[] getFileContent() {
        return fileContent;
    }

    /**
     * Sets the file content.
     * 
     * @param fileContent the new file content
     */
    public void setFileContent(byte[] fileContent) {
        this.fileContent = fileContent;
    }

}
