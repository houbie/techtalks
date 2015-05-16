package betterjavac.groovy

import groovy.json.JsonSlurper
import groovy.xml.MarkupBuilder
import spock.lang.Specification

/**
 * @author Ivo Houbrechts
 */
class JsonSpec extends Specification {

    def "how to build xml"() {
        def writer = new StringWriter()
        def builder = new MarkupBuilder(writer)
        builder.order {
            for (item in ['TV', 'HIFI']) {
                'order-item' {
                    product item
                    quantity 2
                }
            }
        }

        def expected = '''<order>
  <order-item>
    <product>TV</product>
    <quantity>2</quantity>
  </order-item>
  <order-item>
    <product>HIFI</product>
    <quantity>2</quantity>
  </order-item>
</order>'''

        expect:
        writer.toString() == expected
    }

    def "how to parse json"() {
        def json = '''{"order": {
        "order-items": [
            {"product": "TV","quantity": 1},
            {"product": "HIFI","quantity": 2}
        ]
}}'''
        def order = new JsonSlurper().parseText(json).order
//        order.'order-items'*.product
        expect:
        order.'order-items'.findAll {it.quantity > 1} *.product == ['HIFI']
    }

}
