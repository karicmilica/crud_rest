package rs.mk;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

@SpringBootApplication
public class CrudRestApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CrudRestApplication.class, args);
	}
	
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }

    private static Class<CrudRestApplication> applicationClass = CrudRestApplication.class;
	
	@Bean
	public Module hibernate4Module()
	{
	    return new Hibernate4Module();
	}
	
}
