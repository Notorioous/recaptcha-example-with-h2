package am.itspace.recaptchaexamplewithh2.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CaptchaDto {

    private boolean isSuccess;

    private double score;

    private String action;

    @JsonProperty("challenge_ts")
    private String challengeTs;

    private String hostname;
}
