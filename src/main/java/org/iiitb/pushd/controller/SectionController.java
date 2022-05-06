package org.iiitb.pushd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private SectionService cs;

	@GetMapping("get/{username}")
	public List<Section> getResponses(@PathVariable String username) {

		return this.cs.getResponses(username);
	}

	@PostMapping("save")
	public Section addEntry(@RequestBody Section response) {

		return this.cs.addEntry(response);
	}
}
