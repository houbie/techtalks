package betterjavac.groovy

import groovy.transform.CompileStatic

/**
 * @author Ivo Houbrechts
 */
@CompileStatic
class Order {
    List<OrderLine> orderLines
}

@CompileStatic
class OrderLine{
    double amount
    Address address
}