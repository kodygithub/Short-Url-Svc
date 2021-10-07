package org.coders.club.surl.services.apis;

import org.coders.club.surl.common.SUrlInfo;
import org.coders.club.surl.services.svcs.ShortCodeGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shortener")
public class SUrlShortenApi {

    private static Logger logger = LoggerFactory.getLogger(SUrlShortenApi.class);

    @Autowired
    private ShortCodeGenerator shortCodeGenerator;

    @PostMapping("/shorten")
    public SUrlInfo shorten(@RequestBody SUrlInfo params) {

        String code = shortCodeGenerator.generate();

        SUrlInfo sUrlInfo = new SUrlInfo();
        sUrlInfo.setDeleted(false);
        sUrlInfo.setShortCode(code);
        sUrlInfo.setTargetUrl("https://spring.io/");
        return sUrlInfo;
    }

}
