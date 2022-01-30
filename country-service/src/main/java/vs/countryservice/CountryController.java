package vs.countryservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("countries")
public class CountryController {

    final CountryRepository countryRepository;

    public CountryController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @GetMapping
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @GetMapping("{code}")
    public Country findByCountryCode(@PathVariable("code") String countryCode) {
        return countryRepository.findByCountryCode(countryCode);
    }
}
