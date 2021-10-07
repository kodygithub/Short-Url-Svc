package org.coders.club.surl.services.apis;

import com.alibaba.fastjson.JSON;
import org.coders.club.surl.common.SUrlInfo;
import org.coders.club.surl.common.constant.RedisKeys;
import org.coders.club.surl.services.mapper.ShortUrlInfoMapper;
import org.coders.club.surl.services.svcs.ShortCodeGenerator;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//Todo: to move & delete
@RestController
@RequestMapping("/cache")
public class SUrlCacheApi {

    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    private ShortUrlInfoMapper shortUrlInfoMapper;

    @GetMapping("/doCache")
    public String doCache() {
        List<SUrlInfo> list = shortUrlInfoMapper.list();
        for (SUrlInfo sl : list) {
            System.out.println(JSON.toJSONString(sl));
            redissonClient.getBucket(sl.getShortCode()).set(JSON.toJSONString(sl));
        }
        return "Ok!";
    }

}
