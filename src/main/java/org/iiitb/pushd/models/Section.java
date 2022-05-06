package org.iiitb.pushd.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
@Table(name = "sections")
public class Section {
	@Id
	@Column(name = "entryId", unique = true, nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer entryId;

	@Column(name = "username", length = 100, nullable = false)
	private String username;

	@Column(name = "sectionId", length = 100, nullable = false)
	private String sectionId;

	@Column(name = "responseTime", length = 100, nullable = false)
	private Date responseTime;

	@Column(name = "response", length = 10000, nullable = false)
	private String response;
}
