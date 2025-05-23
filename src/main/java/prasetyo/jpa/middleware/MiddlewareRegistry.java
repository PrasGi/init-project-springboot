package prasetyo.jpa.middleware;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MiddlewareRegistry {

    private final ApplicationContext context;

    private final Map<String, Middleware> middlewareMap = new HashMap<>();

    @Autowired
    public void init() {
        Map<String, Middleware> beans = context.getBeansOfType(Middleware.class);
        beans.forEach((name, bean) -> middlewareMap.put(name, bean));
    }

    public Middleware get(String name) {
        return middlewareMap.get(name);
    }
}