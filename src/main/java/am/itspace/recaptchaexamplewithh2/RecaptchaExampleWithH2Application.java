package am.itspace.recaptchaexamplewithh2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RecaptchaExampleWithH2Application {

    public static void main(String[] args) {
        SpringApplication.run(RecaptchaExampleWithH2Application.class, args);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
