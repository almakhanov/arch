package kz.example.arch.data.exceptions

class SessionExpiredException: RuntimeException {

    constructor() : super() {}

    constructor(message: String) : super(message) {}

    constructor(message: String, cause: Throwable) : super(message, cause) {}
}