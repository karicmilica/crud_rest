package rs.mk.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "document")
public class Document {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name="code")
	private String code;

	@CreationTimestamp
	@Column(name="date")
	private Date date;

	@NotNull
	@Column(name="name")
	private String name;

	// @JsonIgnore
	@OneToMany(fetch=FetchType.LAZY,
			mappedBy="document",
			cascade = CascadeType.ALL, 
			orphanRemoval = true
			)
	private List<DocumentItem> documentItems = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<DocumentItem> getDocumentItems() {
		return documentItems;
	}

	public void setDocumentItems(List<DocumentItem> documentItems) {
		this.documentItems = documentItems;
		System.out.println("SET DOCUMENT ITEMSSSSSSSSS ");
		if(documentItems != null) {
			for (Iterator iterator = documentItems.iterator(); iterator.hasNext();) {
				DocumentItem documentItem = (DocumentItem) iterator.next();
				documentItem.setDocument(this);
			}
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Document)) return false;
		Document doc = (Document) o;
		return Objects.equals(getId(), doc.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}

}
