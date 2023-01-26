package ru.job4j.cars.controller;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.job4j.cars.dto.FileDto;
import ru.job4j.cars.service.FileService;

import java.util.Optional;

/**
 * File controller
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
@Controller
@RequestMapping("/files")
@AllArgsConstructor
@ThreadSafe
public class FileController {

    private final FileService fileService;

    /**
     * Returns FileDto content by id
     *
     * @param id FileDto id
     * @return Status 200 with file's content or status 404
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getFileDtoById(@PathVariable int id) {
        Optional<FileDto> contentOptional = fileService.getFileById(id);
        if (contentOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contentOptional.get().getContent());
    }

}
