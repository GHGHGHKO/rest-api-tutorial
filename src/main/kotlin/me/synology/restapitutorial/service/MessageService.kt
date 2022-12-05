package me.synology.restapitutorial.service

import me.synology.restapitutorial.data.Message
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class MessageService(val db: JdbcTemplate) {
    fun findMessage(): List<Message> = db.query("select * from messages") {
        response, _ ->
        Message(response.getString("id"), response.getString("text"))
    }

    fun save(message: Message) {
        val id = message.id ?: UUID.randomUUID().toString()
        db.update("insert into messages values ( ?, ? )",
            id, message.text)
    }
}
