package com.youcode.aftas.core.controller;

import com.youcode.aftas.core.dao.model.dto.RankingDto;
import com.youcode.aftas.core.dao.model.entity.Ranking;
import com.youcode.aftas.core.service.app_service.RankingService;
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
@RequestMapping(AppEndpoints.RANKING)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RankingController {

    private final RankingService RankingService;
    private final ModelMapper modelMapper;
    private final ResponseFormat<List<Ranking>> responseFormatList;
    private final ResponseFormat<Ranking> responseFormat;
    private final ResponseFormat<Void> responseFormatVoid;


    @GetMapping
    public ResponseEntity<ResponseFormat<List<Ranking>>> getAll() {
        return ResponseEntity.ok(
                responseFormatList.format(
                        RankingService.getAll(),
                        "Ranking list retrieved successfully"
                ));
    }

    @PostMapping
    public ResponseEntity<ResponseFormat<Ranking>> save(@Valid @RequestBody RankingDto RankingDto) {
        return ResponseEntity.ok(responseFormat.format(
                RankingService.save(modelMapper.map(RankingDto, Ranking.class)),
                "Ranking saved successfully"
        ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseFormat<Ranking>> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(responseFormat.format(
                RankingService.getById(id),
                "Ranking retrieved successfully"
        ));
    }


    @PutMapping("/{id}")
    public ResponseEntity<ResponseFormat<Ranking>> update(@Valid @RequestBody RankingDto RankingDto, @PathVariable UUID id) {
        return ResponseEntity.ok(responseFormat.format(
                RankingService.update(modelMapper.map(RankingDto, Ranking.class), id),
                "Ranking updated successfully"
        ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseFormat<Void>> deleteById(@PathVariable UUID id) {
        RankingService.deleteById(id);
        return ResponseEntity.ok(responseFormatVoid.format(
                "Ranking deleted successfully"
        ));
    }

    @DeleteMapping
    public ResponseEntity<ResponseFormat<Void>> deleteAll() {
        RankingService.deleteAll();
        return ResponseEntity.ok(responseFormatVoid.format(
                "Ranking deleted successfully"
        ));
    }

}
