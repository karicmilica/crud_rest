package rs.mk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.mk.model.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {
	
}
