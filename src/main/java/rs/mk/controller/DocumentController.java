package rs.mk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rs.mk.controller.vm.ResponseWrapper;
import rs.mk.exception.CustomNotFoundException;
import rs.mk.model.Document;
import rs.mk.model.DocumentItem;
import rs.mk.service.DocumentService;

@RestController
@RequestMapping("/api")
public class DocumentController {

	@Autowired
	private DocumentService documentService;

	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public String test1() {
		return "test";
	}

	@RequestMapping(value = "/documents", method = RequestMethod.GET)
	public ResponseEntity<?> loadAll() {
		List<Document> res = documentService.loadAll();
		return new ResponseEntity(new ResponseWrapper(res), HttpStatus.OK);
	}

	
	@RequestMapping(value= "/documents" , method = RequestMethod.POST)
	ResponseEntity<?> add(@RequestBody Document input) {
		//		this.validateUser(docId);
		Document doc = this.documentService.create(input);
		return new ResponseEntity<>(new ResponseWrapper(doc), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/documents/{id}", method = RequestMethod.PUT)
	ResponseEntity<?> update(@PathVariable Long id, @RequestBody Document input) throws Exception {
		//		this.validateUser(docId);
		if (input.getId() == null || !documentService.exists(input.getId())) {
			throw new CustomNotFoundException("NOT FOUND");
		}
		Document doc = this.documentService.update(input);
		return new ResponseEntity<>(new ResponseWrapper(doc), HttpStatus.OK);
	}

	@RequestMapping(value = "/documents/{id}", method = RequestMethod.DELETE)
	ResponseEntity<?> delete(@PathVariable Long id) throws Exception {
		//		this.validateUser(docId);
		if (!documentService.exists(id)) {
			throw new CustomNotFoundException("NOT FOUND");
		}
		this.documentService.delete(id);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	@RequestMapping(value = "/documents/{id}", method = RequestMethod.GET)
	ResponseEntity<?> findById(@PathVariable Long id) throws Exception {
		if (id == null || !documentService.exists(id)) {
			throw new CustomNotFoundException("NOT FOUND");
		}
		Document doc = this.documentService.findById(id);
		return new ResponseEntity<>(new ResponseWrapper(doc), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/documents/{id}/addItem", method = RequestMethod.POST)
	ResponseEntity<?> addItem(@PathVariable Long id, @RequestBody DocumentItem documentItem) throws Exception {
		if (id == null || !documentService.exists(id)) {
			throw new CustomNotFoundException("NOT FOUND");
		}
		Document doc = this.documentService.addItem(id, documentItem);
		return new ResponseEntity<>(new ResponseWrapper(doc), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/documents/{id}/removeItem/{docItemId}", method = RequestMethod.DELETE)
	ResponseEntity<?> removeItem(@PathVariable Long id, @PathVariable Long docItemId) throws Exception {
		if (id == null || !documentService.exists(id)) {
			throw new CustomNotFoundException("NOT FOUND");
		}
		Document doc = this.documentService.removeItem(id, docItemId);
		return new ResponseEntity<>(new ResponseWrapper(doc), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/documents/{id}/updateItem/{docItemId}", method = RequestMethod.PUT)
	ResponseEntity<?> updateItem(@PathVariable Long id, @PathVariable Long docItemId, @RequestBody DocumentItem documentItem) throws Exception {
		if (id == null || !documentService.exists(id)) {
			throw new CustomNotFoundException("NOT FOUND");
		}
		Document doc = this.documentService.updateItem(id, documentItem);
		return new ResponseEntity<>(new ResponseWrapper(doc), HttpStatus.OK);
	}

}
