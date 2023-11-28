package going.web;

import going.web.interceptor.CartAddInterceptor;
import going.web.interceptor.LoginCheckInterceptor;
import going.web.resolver.LoginResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginCheckInterceptor())
                .order(1)
                .addPathPatterns("/myPage/**")
                .excludePathPatterns("/myPage/register");

        registry.addInterceptor(new CartAddInterceptor())
                .order(1)
                .addPathPatterns("/item/cart/add");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new LoginResolver());
    }
}
