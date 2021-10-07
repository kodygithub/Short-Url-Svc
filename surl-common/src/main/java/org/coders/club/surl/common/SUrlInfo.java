package org.coders.club.surl.common;

import lombok.Data;

@Data
public class SUrlInfo {
    private String shortCode;
    private String targetUrl;
    private Boolean deleted;
}
