package me.synology.restapitutorial.repository

import me.synology.restapitutorial.data.Message
import org.springframework.data.repository.CrudRepository

interface MessageRepository: CrudRepository<Message, String>
