package guru.springframework.blog;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import guru.springframework.blog.componentscan.example.demopackageA.DemoBeanA;
import guru.springframework.blog.componentscan.example.demopackageB.DemoBeanB;
import guru.springframework.blog.componentscan.example.demopackageB.DemoBeanB2;
import guru.springframework.blog.componentscan.example.demopackageB.DemoBeanB3;

//@SpringBootApplication

@ComponentScan(
		excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = DemoBeanB2.class)
    )
public class BlogPostsApplication  implements ApplicationRunner, CommandLineRunner{
	public static void main(String args[]) {
		ApplicationContext  ac = SpringApplication.run(BlogPostsApplication.class,args);
		System.out.println("Contains A : " + ac.containsBeanDefinition("demoBeanA"));
		System.out.println("Contains B : " + ac.containsBeanDefinition("demoBeanB"));
		System.out.println("Contains B2 : " + ac.containsBeanDefinition("demoBeanB2"));
		System.out.println("Contains B3 : " + ac.containsBeanDefinition("demoBeanB3"));
		System.out.println("Contains C : " + ac.containsBeanDefinition("demoBeanC"));
		System.out.println("Contains D : " + ac.containsBeanDefinition("demoBeanD"));
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Called the ApplicationRunner after Spring Boot Started");
		
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Called the CommandLineRunner after Spring Boot Started");
		
	}
}
