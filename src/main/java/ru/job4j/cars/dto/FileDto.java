package ru.job4j.cars.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;

/**
 * File dto
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
public class FileDto {

    @Include
    private String name;

    private byte[] content;

}
