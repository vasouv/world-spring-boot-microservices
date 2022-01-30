package vs.cityservice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class City {

    @Id
    @Column(name = "id")
    public Integer id;

    @Column(name = "name")
    public String name;

    @Column(name = "country_code")
    public String countryCode;

    @Column(name = "district")
    public String district;

    @Column(name = "population")
    public Integer population;

    public City() {
    }

}
