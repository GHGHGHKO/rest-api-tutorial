package me.synology.restapitutorial

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RestApiTutorialApplication

fun main(args: Array<String>) {
	runApplication<RestApiTutorialApplication>(*args)
}
