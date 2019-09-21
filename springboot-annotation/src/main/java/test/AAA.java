package test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableServer(type = Server.Type.FTP)
public class AAA {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AAA.class);
        context.refresh();
        Server server = context.getBean(Server.class);
        server.start();
        server.stop();
    }
}
