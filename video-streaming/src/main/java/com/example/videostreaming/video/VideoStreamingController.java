package com.example.videostreaming.video;

import com.example.videostreaming.service.VideoStreamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "video")
public class VideoStreamingController {

    @Autowired
    private VideoStreamingService videoStreamingService;

    @GetMapping(value = "/{title}", produces = "videos/mp4")
    public Mono<Resource> getVideo(@PathVariable("title") String title, @RequestHeader("Range") String range) {
        System.out.println("Range in bytes() " +  range);
        return videoStreamingService.getVideo(title);
    }


}
