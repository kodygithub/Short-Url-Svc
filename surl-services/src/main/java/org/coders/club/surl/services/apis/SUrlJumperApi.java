package org.coders.club.surl.services.apis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/jumper")
public class SUrlJumperApi {

    @GetMapping("/jump/{params}")
    public void doJump(@PathVariable("params") String params,
                            HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("https://www.baidu.com");
    }


}
