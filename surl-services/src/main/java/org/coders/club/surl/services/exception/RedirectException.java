package org.coders.club.surl.services.exception;

/**
 * 换个名字
 */
public class RedirectException extends RuntimeException {
    public RedirectException(String message) {
        super(message);
    }
}
