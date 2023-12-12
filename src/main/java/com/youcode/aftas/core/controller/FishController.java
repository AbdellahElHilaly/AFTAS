package com.youcode.aftas.core.controller;

import com.youcode.aftas.core.dao.model.dto.FishDto;
import com.youcode.aftas.core.dao.model.entity.Fish;
import com.youcode.aftas.core.service.app_service.FishService;
import com.youcode.aftas.core.utils.pipe.ResponseFormat;
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
@RequestMapping(AppEndpoints.FISH)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class FishController {

    private final FishService FishService;
    private final ModelMapper modelMapper;
    private final ResponseFormat<List<Fish>> responseFormatList;
    private final ResponseFormat<Fish> responseFormat;
    private final ResponseFormat<Void> responseFormatVoid;


    @GetMapping
    public ResponseEntity<ResponseFormat<List<Fish>>> getAll() {
        return ResponseEntity.ok(
                responseFormatList.format(
                        FishService.getAll(),
                        "Fish list retrieved successfully"
                ));
    }

    @PostMapping
    public ResponseEntity<ResponseFormat<Fish>> save(@Valid @RequestBody FishDto FishDto) {
        return ResponseEntity.ok(responseFormat.format(
                FishService.save(modelMapper.map(FishDto, Fish.class)),
                "Fish saved successfully"
        ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseFormat<Fish>> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(responseFormat.format(
                FishService.getById(id),
                "Fish retrieved successfully"
        ));
    }


    @PutMapping("/{id}")
    public ResponseEntity<ResponseFormat<Fish>> update(@Valid @RequestBody FishDto FishDto, @PathVariable UUID id) {
        return ResponseEntity.ok(responseFormat.format(
                FishService.update(modelMapper.map(FishDto, Fish.class), id),
                "Fish updated successfully"
        ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseFormat<Void>> deleteById(@PathVariable UUID id) {
        FishService.deleteById(id);
        return ResponseEntity.ok(responseFormatVoid.format(
                "Fish deleted successfully"
        ));
    }

    @DeleteMapping
    public ResponseEntity<ResponseFormat<Void>> deleteAll() {
        FishService.deleteAll();
        return ResponseEntity.ok(responseFormatVoid.format(
                "Fish deleted successfully"
        ));
    }

}
