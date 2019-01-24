package com.timecoder.web;

import com.timecoder.service.SseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@RequiredArgsConstructor
public class SseController {

    private final SseService sseService;

    @RequestMapping(value = "/stream", method = RequestMethod.GET, produces =  MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter getNotifications() {
        return sseService.registerEmitter(new SseEmitter());
    }
}
