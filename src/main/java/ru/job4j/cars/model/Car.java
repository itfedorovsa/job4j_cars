package ru.job4j.cars.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Car model
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 08.01.23
 */
@Getter
@Setter
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id")
    private Model model;

    private String vin;

    private int mileage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "body_id")
    private Body body;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "colour_id")
    private Colour colour;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "year_id")
    private ReleaseYear releaseYear;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "engine_volume_id")
    private EngineVolume engineVolume;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "owners_history",
            joinColumns = {@JoinColumn(name = "car_id")},
            inverseJoinColumns = {@JoinColumn(name = "owner_id")}
    )
    private Set<Owner> owners = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drivetrain_id")
    private Drivetrain drivetrain;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transmission_id")
    private Transmission transmission;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fuel_type_id")
    private FuelType fuelType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "door_count_id")
    private DoorCount doorCount;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return id == car.id && mileage == car.mileage && Objects.equals(brand, car.brand)
                && Objects.equals(model, car.model) && Objects.equals(vin, car.vin) && Objects.equals(body, car.body) && Objects.equals(colour, car.colour) && Objects.equals(releaseYear, car.releaseYear)
                && Objects.equals(engineVolume, car.engineVolume) && Objects.equals(owners, car.owners)
                && Objects.equals(owner, car.owner) && Objects.equals(drivetrain, car.drivetrain)
                && Objects.equals(transmission, car.transmission) && Objects.equals(fuelType, car.fuelType)
                && Objects.equals(doorCount, car.doorCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Car{"
                + "id=" + id
                + ", brand=" + brand
                + ", model=" + model
                + ", vin='" + vin + '\''
                + ", mileage=" + mileage
                + ", body=" + body
                + ", colour=" + colour
                + ", releaseYear=" + releaseYear
                + ", engineVolume=" + engineVolume
                + ", owner=" + owner
                + ", drivetrain=" + drivetrain
                + ", transmission=" + transmission
                + ", fuelType=" + fuelType
                + ", doorCount=" + doorCount
                + '}';
    }

}