package org.iiitb.pushd.repositories;

import java.util.List;

import org.iiitb.pushd.models.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepository extends JpaRepository<Section, Integer> {
	List<Section> findByUsername(String username);
}
