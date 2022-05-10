package org.iiitb.pushd.services;

import java.util.List;

import org.iiitb.pushd.models.Section;

public interface SectionService {
	public List<Section> getResponses(String username);

	public Section addEntry(Section response);

}
