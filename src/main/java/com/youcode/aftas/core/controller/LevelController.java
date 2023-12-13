package com.youcode.aftas.core.controller;

import com.youcode.aftas.core.dao.model.dto.LevelDto;
import com.youcode.aftas.core.dao.model.entity.Level;
import com.youcode.aftas.core.service.app_service.LevelService;
import com.youcode.aftas.core.utils.pipe.mapper.ResponseFormat;
import com.youcode.aftas.shared.Const.AppEndpoints;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(AppEndpoints.LEVEL)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LevelController {

    private final LevelService LevelService;
    private final ModelMapper modelMapper;
    private final ResponseFormat<List<Level>> responseFormatList;
    private final ResponseFormat<Level> responseFormat;
    private final ResponseFormat<Void> responseFormatVoid;


    @GetMapping
    public ResponseEntity<ResponseFormat<List<Level>>> getAll() {
        return ResponseEntity.ok(
                responseFormatList.format(
                        LevelService.getAll(),
                        "Level list retrieved successfully"
                ));
    }

    @PostMapping
    public ResponseEntity<ResponseFormat<Level>> save(@Valid @RequestBody LevelDto LevelDto) {
        return ResponseEntity.ok(responseFormat.format(
                LevelService.save(modelMapper.map(LevelDto, Level.class)),
                "Level saved successfully"
        ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseFormat<Level>> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(responseFormat.format(
                LevelService.getById(id),
                "Level retrieved successfully"
        ));
    }


    @PutMapping("/{id}")
    public ResponseEntity<ResponseFormat<Level>> update(@Valid @RequestBody LevelDto LevelDto, @PathVariable UUID id) {
        return ResponseEntity.ok(responseFormat.format(
                LevelService.update(modelMapper.map(LevelDto, Level.class), id),
                "Level updated successfully"
        ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseFormat<Void>> deleteById(@PathVariable UUID id) {
        LevelService.deleteById(id);
        return ResponseEntity.ok(responseFormatVoid.format(
                "Level deleted successfully"
        ));
    }

    @DeleteMapping
    public ResponseEntity<ResponseFormat<Void>> deleteAll() {
        LevelService.deleteAll();
        return ResponseEntity.ok(responseFormatVoid.format(
                "Level deleted successfully"
        ));
    }

}
