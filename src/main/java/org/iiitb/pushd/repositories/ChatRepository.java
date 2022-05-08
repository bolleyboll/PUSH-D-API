package org.iiitb.pushd.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.iiitb.pushd.models.Chat;

//JpaRepository<Course(give entity name), Long(what is the type of primary key)>
public interface ChatRepository extends JpaRepository<Chat, Long>{
	//@Query("FROM Chat WHERE receiverId = ?1")
    List<Chat> findByReceiverId(String receiverId);
	
	
}
