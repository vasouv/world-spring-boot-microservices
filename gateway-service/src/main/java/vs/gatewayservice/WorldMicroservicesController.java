package vs.gatewayservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("world-microservices")
public class WorldMicroservicesController {

    @GetMapping
    public String gateway() {
        return "World Microservices";
    }

}
