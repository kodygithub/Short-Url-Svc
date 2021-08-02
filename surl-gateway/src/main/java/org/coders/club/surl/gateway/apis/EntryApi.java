package org.coders.club.surl.gateway.apis;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/apis")
public class EntryApi {

    @GetMapping(value = "/entry/{params}")
    public void entry(@PathVariable("params") String params,
                      HttpServletRequest request,
                      HttpServletResponse response) throws IOException {
        System.out.println("Yes");
        response.sendRedirect("http://www.baidu.com");
    }

}
