package vs.gatewayservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("world-microservices")
public class WorldMicroservicesController {

    @Value("${country.service}")
    String countryService;

    WebClient webClient = WebClient.create();

    @GetMapping("countries")
    public List<Country> countries() {

        String countryServiceURL = UriComponentsBuilder
                .fromUriString(countryService)
                .path("/countries")
                .build()
                .toUriString();

        return webClient
                .get()
                .uri(countryServiceURL)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Country>>() {})
                .block();

    }

    @GetMapping("countries/details")
    public void countryDetails() {

    }

}
