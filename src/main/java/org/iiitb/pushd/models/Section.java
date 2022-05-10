package org.iiitb.pushd.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
@Table(name = "sections")
@IdClass(SectionId.class)
public class Section {
	@Column(name = "entryId", unique = true, nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer entryId;

	@Id
	@Column(name = "username", length = 100, nullable = false)
	private String username;

	@Id
	@Column(name = "sectionId", length = 100, nullable = false)
	private String sectionId;

	@Column(name = "responseTime", length = 100, nullable = false)
	private LocalDateTime responseTime;

	@Column(name = "response", length = 10000, nullable = false)
	private String response;
}
