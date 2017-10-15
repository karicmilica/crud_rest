package rs.mk.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.mk.model.Document;
import rs.mk.model.DocumentItem;
import rs.mk.repository.DocumentRepository;

@Service
public class DocumentService {
	
	@Autowired
	private DocumentRepository documentRepository;

	@Transactional(readOnly=true)
	public List<Document> loadAll()
	{
		List<Document> res = documentRepository.findAll();
		return res;
	}
	
	@Transactional
	public Document create(Document Document)
	{
		Document doc = documentRepository.save(Document);
		return doc;
	}
	
	@Transactional
	public Document update(Document Document)
	{
		Document doc = documentRepository.save(Document);
		return doc;
	}
	
	@Transactional
	public void delete(Long id)
	{
		documentRepository.delete(id);
	}
	
	@Transactional(readOnly=true)
	public Document findById(Long id)
	{
		Document doc = documentRepository.findOne(id);
		return doc;
	}
	
	@Transactional(readOnly=true)
	public boolean exists(Long id)
	{
		boolean doc = documentRepository.exists(id);
		return doc;
	}

	@Transactional
	public Document addItem(Long id, DocumentItem documentItem) {
		Document doc = documentRepository.findOne(id);
		if(doc.getDocumentItems() == null) {
			doc.setDocumentItems(new ArrayList<DocumentItem>());
		}
		doc.getDocumentItems().size();
		documentItem.setDocument(doc);
		doc.getDocumentItems().add(documentItem);
		documentRepository.save(doc);
		doc = documentRepository.findOne(id);
		return doc;
	}
	
	@Transactional
	public Document removeItem(Long id, Long docItemId) {
		Document doc = documentRepository.findOne(id);
		if(doc.getDocumentItems() != null) {
			doc.getDocumentItems().size();
			for (int i = 0; i < doc.getDocumentItems().size(); i++) {
				DocumentItem di = doc.getDocumentItems().get(i);
				if(docItemId.longValue() == di.getId().longValue()) {
					doc.getDocumentItems().remove(i);
					di.setDocument(null);
				}
			}
			documentRepository.save(doc);
			doc = documentRepository.findOne(id);
		}
		return doc;
	}
	
	@Transactional
	public Document updateItem(Long id, DocumentItem documentItem) {
		Document doc = documentRepository.findOne(id);
		if(doc.getDocumentItems() != null) {
			doc.getDocumentItems().size();
			for (int i = 0; i < doc.getDocumentItems().size(); i++) {
				DocumentItem di = doc.getDocumentItems().get(i);
				if(documentItem.getId().longValue() == di.getId().longValue()) {
					documentItem.setDocument(doc);
					di.setDocument(null);
					doc.getDocumentItems().set(i, documentItem);
				}
			}
			System.out.println("updateItem " + doc.getDocumentItems().size());
			documentRepository.save(doc);
			doc = documentRepository.findOne(id);
		}
		return doc;
	}
	
}
