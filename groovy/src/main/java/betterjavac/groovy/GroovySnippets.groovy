package betterjavac.groovy

import groovy.transform.CompileStatic
import org.springframework.beans.factory.xml.DefaultBeanDefinitionDocumentReader

import java.awt.*
import java.util.List
import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * @author Ivo Houbrechts
 */
@CompileStatic
class GroovySnippets {
    static int calculateScore(){
        return 0
    }

    static DefaultBeanDefinitionDocumentReader createDocumentReader(){
        return new DefaultBeanDefinitionDocumentReader()
    }

    static void main(String... args) {
        String string = ""
        Object object = new Object()
        int number = 0
        Collection collection = []

        User user = [firstName: "Ivo", lastName: "Houbrechts"]

        //tag::semicolon[]
        int x = 1
        double sinus = Math.sin(x)
        //end::semicolon[]

        String message=
        //tag::stringInterpolation[]
        "Hello $user.firstName , your score is ${calculateScore()} points."
        //end::stringInterpolation[]

        //tag::stringEscapes[]
        String html = '<div class="ruler"/>'
        String regexp = /\\"/
        //end::stringEscapes[]

        //tag::stringMultiline[]
        String multiLine = """<note>
    <to>Tove</to>
    <from>Jani</from>
    <heading>Reminder</heading>
    <body>Don't forget me this weekend!</body>
</note>"""
        //end::stringMultiline[]

        //tag::nullsafe[]
        String city = user?.address?.city
        //end::nullsafe[]

        //tag::default[]
        String s = user?.userName ?: "default"
        //end::default[]

        //tag::literal[]
        List<Integer> numbers = [1, 2, 3]
        Map<String, Integer> scores = [Groovy: 9, Java: 7]
        List emptyList = []
        Map emptyMap = [:]
        //end::literal[]

        //tag::namedArguments[]
        User ivo = new User(userName: "houbie", firstName: "Ivo",
                lastName: "Houbrechts", enabled: true, provisioned: false)
        //end::namedArguments[]

        String type= ""
        String lhs= ""
        String rhs= ""
        //tag::equals[]
        //null-safe equals operator
        if (type == "TOP") {}

        if (lhs != rhs) {}

        //identity, null-safe
        if (lhs.is(rhs)) {}
        //end::equals[]

        //tag::truth[]
        if (object) {}

        if (string) {}

        if (collection) {}

        if (number) {}
        //end::truth[]
        List<OrderLine> orderLines = [new OrderLine(address: new Address(street: 'street'))]
        Order order = new Order(orderLines: orderLines)
        List<Order> orders = [order]
        //tag::spread[]
        double amount = (double) order.orderLines*.amount.sum()

        Collection deliveryAddresses =
                orders*.orderLines*.address.flatten().unique()
        //end::spread[]

        //tag::regexp[]
        Pattern pattern = ~/(\d)+/
        Matcher matcher = '2.0.12' =~ /(\d)+/
        boolean matches = '2.0.12' ==~ /(\d)+/
        //end::regexp[]

        String text
        //tag::switch[]
        switch (object) {
            case Number: text = "it's a number"
                break
            case ~/(\d)+/: text = "it matches the pattern"
                break
            case ["Java", "JavaScript"]: text = "it's in the list"
                break
        }
        //end::switch[]

        Mail mail = new Mail(message: new Message(subject: 'subject'))
        //tag::properties[]
        String subject = mail.message.subject
        mail.message.body = "Hello"
        //end::properties[]

        //tag::range[]
        for (count in 1..10){
            //do stuff
        }
        //end::range[]

        //tag::rangeUses[]
        List integers= [0, 1, 2, 3]

        integers[0..2] //[0, 1, 2]

        "Hello Groovy"[-6..-1] //"Groovy"
        //end::rangeUses[]
        def allUsers=[]
        def enabledUsers=[]
        def disabledUsers
        //tag::operator1[]
        disabledUsers = allUsers - enabledUsers
        //end::operator1[]

        def stringBuilder= new StringBuilder()
        def map= [:]
        def list= []
        //tag::operator2[]
        stringBuilder << "Hello " << user << '!'

        map["foo"] = "bar"
        map["foo"]
        map.foo

        list[3] = "bazz"
        list[3]

        user["firstName"]
        //end::operator2[]

        //tag::inference[]
        Point point = [10, 33]

        def documentReader= new DefaultBeanDefinitionDocumentReader()
        def defaultBeanDefinitionDocumentReader= createDocumentReader()

        if (object instanceof User){
            user.getFirstName() //even pre java 7
        }
        //end::inference[]

        //tag::traits[]
        new FileInputStream(new File("text"))
        //end::traits[]

        int size
        int[] array
        def predicate= {}
        //tag::fix[]
        array.size()
        string.size()
        collection.size()

        collection.find(predicate)
        collection.min()
        collection.max()
        collection.sum()
        //end::fix[]
    }

    //tag::defaultArguments[]
    void save(String format = "csv", boolean minify = false,
              boolean prettify = false) {
        //implementation
    }
    //end::defaultArguments[]

    void noThrows() {
        //tag::exceptions[]
        new FileInputStream(new File("text"))
        //end::exceptions[]
    }

    void functional() {
        List<User> allUsers = []
        //tag::functional[]
        Closure func = { User user ->
            return user.enabled
        }

        allUsers.findAll(func)

        allUsers.collect({User user -> "$user.fullName: $user.enabled"})
        //end::functional[]
    }

}
