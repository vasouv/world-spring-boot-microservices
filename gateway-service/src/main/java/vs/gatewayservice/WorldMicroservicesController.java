package vs.gatewayservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("world-microservices")
public class WorldMicroservicesController {

    RestTemplate restTemplate = new RestTemplate();

    @Value("${country.service}")
    String countryService;

    @GetMapping("countries")
    public ResponseEntity<List<Country>> countries() {

        String uri = UriComponentsBuilder
                .fromUriString(countryService)
                .path("/countries")
                .build()
                .toUriString();

        return restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<>() {
        });

    }

}
