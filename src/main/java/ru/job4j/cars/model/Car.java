package ru.job4j.cars.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
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
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder(builderMethodName = "of")
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
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

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "owners_history",
            joinColumns = {@JoinColumn(name = "car_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "owner_id", nullable = false, updatable = false)}
    )
    private Set<Owner> owners = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
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

    public Car(int id) {
        this.id = id;
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