package org.iiitb.pushd.services.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.iiitb.pushd.models.Section;
import org.iiitb.pushd.repositories.SectionRepository;
import org.iiitb.pushd.services.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SectionServiceImpl implements SectionService{

	@Autowired
	private SectionRepository sr;

	@Override
	public List<Section> getResponses(String username) {
		return sr.findByUsername(username);
	}

	@Override
	public Section addEntry(Section response) {
		response.setResponseTime(LocalDateTime.now());
		return sr.save(response);
	}



}
