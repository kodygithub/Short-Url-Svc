package org.coders.club.surl.services.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.coders.club.surl.common.SUrlInfo;

import java.util.List;

@Mapper
public interface ShortUrlInfoMapper {

    List<SUrlInfo> list();

    SUrlInfo queryWithShortCode(@Param("shortCode") String shortCode);

}
