package jp.classmethod.devio;

import com.amazonaws.xray.AWSXRay;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBlogApplication {

	public static void main(String[] args) {
		AWSXRay.beginSegment("startup");
		SpringApplication.run(SpringBlogApplication.class, args);
	}
}
