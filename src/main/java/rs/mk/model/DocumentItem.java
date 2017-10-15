package rs.mk.model;


import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "document_item")
public class DocumentItem {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name="name")
	private String name;
	
	@Column(name="price")
	private Double price;
	
	// @JsonIgnore
//	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	@ManyToOne()
    @JoinColumn(name = "doc_id")
    private Document document;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DocumentItem)) return false;
        DocumentItem docItem = (DocumentItem) o;
        return Objects.equals(getId(), docItem.getId());
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
	
}
