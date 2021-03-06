package be.ixor.techtalk.springboot

@Grab('spring-boot-starter-data-jpa')
@Grab('spring-boot-starter-data-rest')
@Grab('spring-boot-starter-actuator')

@Grab('h2')

//javascript webjars
@Grab( 'org.webjars.npm:babel-standalone:1.0.0')
@Grab( 'org.webjars.npm:react:0.14.7')
@Grab( 'org.webjars.npm:react-dom:0.14.7')
@Grab( 'org.webjars.npm:superagent:1.5.0')
@GrabExclude('org.webjars.npm:cookiejar:2.0.1')
@GrabExclude('org.webjars.npm:reduce-component')
@GrabExclude('org.webjars.npm:through')

import org.springframework.boot.context.embedded.ServletRegistrationBean
import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

import org.h2.server.web.WebServlet

@Entity
class Todo {
    @Id
    @GeneratedValue
    Long id
    String text
    boolean done
}

@RepositoryRestResource(collectionResourceRel = "todo", path = "todo")
interface TodoRepository extends CrudRepository<Todo, Long> {}



@Configuration
public class H2Console {
    @Bean
    ServletRegistrationBean h2servletRegistration(){
        def bean = new ServletRegistrationBean( new WebServlet())
        bean.addUrlMappings("/console/*")
        return bean
    }
}