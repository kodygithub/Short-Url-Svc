package org.coders.club.surl.services.apis;

import org.coders.club.surl.common.SUrlInfo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shortener")
public class SUrlShortenApi {

    @PostMapping("/shorten")
    public SUrlInfo shorten(@RequestBody SUrlInfo params) {
        SUrlInfo sUrlInfo = new SUrlInfo();
        sUrlInfo.setDeleted(false);
        sUrlInfo.setShortCode("Bjd7sQ");
        sUrlInfo.setTargetUrl("https://spring.io/");
        return sUrlInfo;
    }

}
