package test;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(ServerImportSelector.class)
public @interface EnableServer {

    Server.Type type();
}
