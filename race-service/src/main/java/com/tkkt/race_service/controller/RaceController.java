package com.tkkt.race_service.controller;

import com.tkkt.race_service.dto.request.CreateRaceRequest;
import com.tkkt.race_service.dto.request.UpdateRaceRequest;
import com.tkkt.race_service.entity.Race;
import com.tkkt.race_service.service.RaceService;
import com.tkkt.race_service.dto.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/race/")
public class RaceController {
    private  final  RaceService raceService;

    @GetMapping("seasons/{seasonId}")
    public ApiResponse<List<Race>> getAllRaceBySeasonId(@PathVariable("seasonId") Long seasonId) {
        return ApiResponse.<List<Race>>builder()
                .code(200)
                .message("Lấy thông tin giải đua theo mùa giải thành công")
                .result(raceService.findAllRaceBySeasonId(seasonId))
                .build();
    }

    @GetMapping("{raceId}")
    public ApiResponse<Race> getRaceById(@PathVariable("raceId") Long raceId) {
        return ApiResponse.<Race>builder()
                .code(200)
                .message("Lấy thông tin chặng đua thành công")
                .result(raceService.getRaceById(raceId))
                .build();
    }

    @PostMapping("create-race")
    public ApiResponse<Race> createRace(@RequestBody CreateRaceRequest createRaceRequest) {
        return ApiResponse.<Race>builder()
                .code(201)
                .message("Tạo chặng đua thành công")
                .result(raceService.createRace(createRaceRequest))
                .build();
    }

    @PostMapping("update-race/{raceId}")
    public ApiResponse<Race> updateRace(@PathVariable("raceId") Long raceId ,
                                        @RequestBody UpdateRaceRequest updateRaceRequest) {
        return ApiResponse.<Race>builder()
                .code(200)
                .message("Cập nhật chặng đua thành công")
                .result(raceService.updateRace(raceId ,updateRaceRequest))
                .build();
    }

    @DeleteMapping("delete-race/{raceId}")
    public ApiResponse<Race> deleteRace(@PathVariable("raceId") Long raceId) {
        return ApiResponse.<Race>builder()
                .code(200)
                .message("Xóa chặng đua thành công")
                .result(raceService.deleteRace(raceId))
                .build();
    }
}
