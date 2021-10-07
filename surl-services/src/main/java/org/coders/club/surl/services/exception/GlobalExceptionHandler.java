package org.coders.club.surl.services.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @Value("${sl.default.redirectTo:'https://spring.io/'}")
    private String DEFAULT_URL;

    //也可考虑自定义页面，讲返回类型改为 model view
    @ExceptionHandler(RedirectException.class)
    public void redirectExceptionHandle(HttpServletRequest req, HttpServletResponse rsp, Exception e) throws IOException {
        rsp.sendRedirect(DEFAULT_URL);
    }
}
