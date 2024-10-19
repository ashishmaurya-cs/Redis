package com.ashish.services;

import java.util.List;
import java.util.UUID;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ashish.entities.Notes;
import com.ashish.repositories.NotesRepository;

@Service
public class NotesService {
	private NotesRepository notesRepository;

	public NotesService(NotesRepository notesRepository) {
		this.notesRepository = notesRepository;
	}

	public Notes saveNotes(Notes notes) {
		notes.setId(UUID.randomUUID().toString());
		return notesRepository.save(notes);
	}

	public List<Notes> getAllNotes() {
		return notesRepository.findAll();
	}
	@Cacheable(value = "users", key = "#noteID")
	public Notes getNoteById(String noteID) {
		return notesRepository.findById(noteID).orElseThrow(() -> new RuntimeException("Not found"));
	}

	public Notes updateNotes(String noteId, Notes notes) {
		Notes notes2 = notesRepository.findById(noteId).orElseThrow(() -> new RuntimeException("Not found"));
		notes2.setTitle(notes.getTitle());
		notes2.setContent(notes.getContent());
		notes2.setLive(notes.isLive());

		return notesRepository.save(notes2);

	}

	public void deleteNotes(String noteId) {
		Notes notes2 = notesRepository.findById(noteId).orElseThrow(() -> new RuntimeException("Not found"));

		notesRepository.delete(notes2);

	}

}
