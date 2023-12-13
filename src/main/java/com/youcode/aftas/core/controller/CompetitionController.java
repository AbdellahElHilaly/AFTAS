package com.youcode.aftas.core.controller;


import com.youcode.aftas.core.dao.model.dto.CompetitionDto;
import com.youcode.aftas.core.dao.model.entity.Competition;
import com.youcode.aftas.core.service.app_service.CompetitionService;
import com.youcode.aftas.core.utils.pipe.mapper.ResponseFormat;
import com.youcode.aftas.core.utils.pipe.vm.CompetitionVm;
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
@RequestMapping(AppEndpoints.COMPETITION)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CompetitionController {

    private final CompetitionService competitionService;
    private final ModelMapper modelMapper;
    private final ResponseFormat<List<CompetitionVm>> responseFormatList;
    private final ResponseFormat<CompetitionVm> responseFormat;
    private final ResponseFormat<Void> responseFormatVoid;


    @GetMapping
    public ResponseEntity<ResponseFormat<List<CompetitionVm>>> getAll() {
        return ResponseEntity.ok(
                responseFormatList.format(
                        competitionService.getAll(),
                        "Competitions retrieved successfully"
                ));
    }



    @PostMapping
    public ResponseEntity<ResponseFormat<CompetitionVm>> save(@Valid @RequestBody CompetitionDto competitionDto) {
        return ResponseEntity.ok(responseFormat.format(
                competitionService.save(modelMapper.map(competitionDto, Competition.class)),
                "Competition saved successfully"
        ));
    }



    @GetMapping("/{id}")
    public ResponseEntity<ResponseFormat<CompetitionVm>> getVmById(@PathVariable UUID id) {
        return ResponseEntity.ok(responseFormat.format(
                competitionService.findById(id),
                "Competition retrieved successfully"
        ));
    }


    @PutMapping("/{id}")
    public ResponseEntity<ResponseFormat<CompetitionVm>> update(@Valid @RequestBody CompetitionDto competitionDto, @PathVariable UUID id) {
        return ResponseEntity.ok(responseFormat.format(
                competitionService.update(modelMapper.map(competitionDto, Competition.class), id),
                "Competition updated successfully"
        ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseFormat<Void>> deleteById(@PathVariable UUID id) {
        competitionService.deleteById(id);
        return ResponseEntity.ok(responseFormatVoid.format(
                "Competition deleted successfully"
        ));
    }

    @DeleteMapping
    public ResponseEntity<ResponseFormat<Void>> deleteAll() {
        competitionService.deleteAll();
        return ResponseEntity.ok(responseFormatVoid.format(
                "Competition deleted successfully"
        ));
    }

}
