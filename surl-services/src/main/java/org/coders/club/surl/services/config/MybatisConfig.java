package org.coders.club.surl.services.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("rg.coders.club.surl.services.mapper")
public class MybatisConfig {
}
