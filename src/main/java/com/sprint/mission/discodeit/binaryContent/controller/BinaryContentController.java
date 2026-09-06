package com.sprint.mission.discodeit.binaryContent.controller;

import com.sprint.mission.discodeit.binaryContent.dto.BinaryContentDownloadResponse;
import com.sprint.mission.discodeit.binaryContent.dto.BinaryContentResponseDto;
import com.sprint.mission.discodeit.binaryContent.application.BinaryContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriUtils;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/binaryContents")
public class BinaryContentController {

    private final BinaryContentService binaryContentService;

    @GetMapping
    public List<BinaryContentResponseDto> findAllByIds(@RequestParam List<UUID> binaryContentIds ){
        return binaryContentService.findAllByIdIn(binaryContentIds );
    }

    @GetMapping(value = "/{binaryContentId}")
    public BinaryContentResponseDto findById(@PathVariable UUID binaryContentId){
        return binaryContentService.find(binaryContentId);
    }

    @GetMapping(value = "/{binaryContentId}/download")
    public ResponseEntity<byte[]> downloadById(@PathVariable UUID binaryContentId){
        BinaryContentDownloadResponse download = binaryContentService.download(binaryContentId);

        String encodingName = UriUtils.encode(download.filename(), StandardCharsets.UTF_8);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + encodingName + "\"")
                .body(download.bytes());
    }

}
