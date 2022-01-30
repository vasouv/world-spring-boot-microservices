package vs.cityservice;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cities")
public class CityController {

    final CityRepository cityRepository;

    public CityController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @GetMapping
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @GetMapping("/{countryCode}")
    public List<City> findAllByCountryCode(@PathVariable("countryCode") String countryCode) {
        return cityRepository.findAllByCountryCode(countryCode);
    }

}
