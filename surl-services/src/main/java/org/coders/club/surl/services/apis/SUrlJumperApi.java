package org.coders.club.surl.services.apis;

import com.alibaba.fastjson.JSON;
import org.coders.club.surl.common.SUrlInfo;
import org.coders.club.surl.services.exception.RedirectException;
import org.coders.club.surl.services.mapper.ShortUrlInfoMapper;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@RestController
@RequestMapping("/jumper")
public class SUrlJumperApi {

    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    private ShortUrlInfoMapper shortUrlInfoMapper;

    @GetMapping("/jump/{params}")
    public void doJump(@PathVariable("params") String params,
                       HttpServletRequest request,
                       HttpServletResponse response) throws Exception {

        //Todo: params validate

        //todo: 1、bloom filter

        //2、cache hit
        RBucket<String> slMappingBk = redissonClient.getBucket(params);

        if (slMappingBk.isExists()) {
            SUrlInfo o = JSON.parseObject(slMappingBk.get(), SUrlInfo.class);
            //Todo: 这里还需要判断短链接的有效状态
            response.sendRedirect(o.getTargetUrl());
            return;
        }

        //3、DB hit
        SUrlInfo sUrlFromDB = shortUrlInfoMapper.queryWithShortCode(params);
        if (Objects.isNull(sUrlFromDB)) {
            throw new RedirectException(String.format("Invalid params `code`: %s . No mapping.", params));
        }

        //Todo: 这里还需要判断短链接的有效状态
        response.sendRedirect(sUrlFromDB.getTargetUrl());

        //write back to the cache
        redissonClient.getBucket(sUrlFromDB.getShortCode()).set(JSON.toJSONString(sUrlFromDB));

        throw new RedirectException("Something wrong on the server.");
    }

}
