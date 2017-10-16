package rs.mk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.mk.model.Document;
import rs.mk.model.DocumentItem;

public interface DocumentItemRepository extends JpaRepository<DocumentItem, Long> {
	
}
