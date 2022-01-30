package vs.countrylanguageservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("countrylanguage")
public class CountryLanguageController {

    final CountryLanguageRepository countryLanguageRepository;

    public CountryLanguageController(CountryLanguageRepository countryLanguageRepository) {
        this.countryLanguageRepository = countryLanguageRepository;
    }

    @GetMapping
    public List<CountryLanguage> findAll() {
        return countryLanguageRepository.findAll();
    }

    @GetMapping("{countryCode}/{language}")
    public CountryLanguage findByCountryCodeAndLanguage(@PathVariable("countryCode") String countryCode, @PathVariable("language") String language) {
        return countryLanguageRepository.findByCountryCodeAndLanguage(countryCode, language);
    }

}
