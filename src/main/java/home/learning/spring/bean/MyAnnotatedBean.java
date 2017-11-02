package home.learning.spring.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

/**
 * home.learning.spring.bean
 * Created by vorsicht on 01/11/17.
 */
@Service
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class MyAnnotatedBean {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
