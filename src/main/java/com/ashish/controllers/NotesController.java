package com.ashish.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashish.entities.Notes;
import com.ashish.services.NotesService;

@RestController
@RequestMapping("/api/v1/notes")
public class NotesController {
	
	@Autowired
	private NotesService notesService;
	
	//for creating notes
	
	@PostMapping
	public ResponseEntity<Notes> create(@RequestBody Notes notes){
		return ResponseEntity.status(HttpStatus.CREATED).body(notesService.saveNotes(notes));
	}
	
	@GetMapping
	public ResponseEntity<List<Notes>> getAllNotes(){
		return ResponseEntity.ok(notesService.getAllNotes());
	}
	
	@GetMapping("/{noteId}")
	public ResponseEntity<Notes> getSingleNotes(@PathVariable String noteId){
		return ResponseEntity.ok(notesService.getNoteById(noteId));
	}
	

}
