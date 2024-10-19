package com.ashish.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashish.entities.Notes;

public interface NotesRepository extends JpaRepository<Notes, String>{

}
