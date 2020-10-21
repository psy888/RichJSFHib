package richjsf.configuration;

import com.google.common.collect.ImmutableMap;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import richjsf.entity.CoffeeType;
import richjsf.view.mBeanScope.ViewScope;

@Configuration
public class BeanConfiguration {

    @Bean(name = "sessionF")
    public static SessionFactory getSessionFactory() {
        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration().configure().addAnnotatedClass(CoffeeType.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        return configuration.buildSessionFactory(builder.build());
//        return new AnnotationConfiguration().
//                configure().
//                addPackage("richjsf.entity"). //add package if used.
//                        addAnnotatedClass(CoffeeType.class).
//        buildSessionFactory();
    }

    @Bean
    public static CustomScopeConfigurer viewScope() {
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        configurer.setScopes(
                new ImmutableMap.Builder<String, Object>().put("view", new ViewScope()).build());
        return configurer;
    }
}
