package am.itspace.recaptchaexamplewithh2.util;

import am.itspace.recaptchaexamplewithh2.dto.CaptchaDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class CaptchaUtil {

    @Value("${google.req.url}")
    private String url;
    @Value("${private.key}")
    private String privateKey;

    private final RestTemplate restTemplate;

    public CaptchaUtil(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CaptchaDto getCaptcha(String response) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("secret", privateKey)
                .queryParam("response", response);

        return restTemplate.getForObject(builder.toUriString(),CaptchaDto.class);
    }
}
