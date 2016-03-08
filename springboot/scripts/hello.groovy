@RestController
class Hello {
    @RequestMapping('/')
    def hello() { 'Hello Ixor' }
}