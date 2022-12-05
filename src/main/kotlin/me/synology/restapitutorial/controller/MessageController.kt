package me.synology.restapitutorial.controller

import me.synology.restapitutorial.data.Message
import me.synology.restapitutorial.service.MessageService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class MessageController(
    val messageService: MessageService
) {

    @GetMapping("/")
    fun index(@RequestParam("name") name: String) = "Hello, $name!"

    @GetMapping("/index")
    fun index() = listOf(
        Message("1", "Hello!"),
        Message("2", "안녕하세요!@#!$#"),
        Message("3", "Privet!"),
    )

    @GetMapping("/messages")
    fun indexList(): List<Message> = messageService.findMessage()

    @PostMapping("/messages")
    fun post(@RequestBody message: Message) {
        messageService.save(message)
    }
}
