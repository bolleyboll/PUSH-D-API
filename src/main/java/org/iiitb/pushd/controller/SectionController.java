package org.iiitb.pushd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.iiitb.pushd.models.Section;
import org.iiitb.pushd.services.SectionService;

@RestController
@RequestMapping("section")
public class SectionController {
	private static final String ORIGIN_URL = "http://localhost:3000";

	@Autowired
	private SectionService ss;

	@CrossOrigin(origins = ORIGIN_URL)
	@GetMapping("get/{username}")
	public List<Section> getResponses(@PathVariable String username) {

		return this.ss.getResponses(username);
	}

	@CrossOrigin(origins = ORIGIN_URL)
	@PostMapping("save")
	public Section addEntry(@RequestBody Section response) {

		return this.ss.addEntry(response);
	}


}
