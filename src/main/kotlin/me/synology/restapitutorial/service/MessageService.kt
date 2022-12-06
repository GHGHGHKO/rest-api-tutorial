package me.synology.restapitutorial.service

import me.synology.restapitutorial.data.Message
import me.synology.restapitutorial.repository.MessageRepository
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class MessageService(val db: MessageRepository) {
    fun findMessage(): List<Message> = db.findAll().toList()

    fun findMessageById(id: String): List<Message> = db.findById(id).toList()

    fun save(message: Message) {
        db.save(message)
    }

    fun <T : Any> Optional<out T>.toList(): List<T> =
        if (isPresent) listOf(get()) else emptyList()
}
