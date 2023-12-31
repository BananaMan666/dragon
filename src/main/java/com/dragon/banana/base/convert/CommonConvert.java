package com.dragon.banana.base.convert;

import com.dragon.banana.controller.dto.RegisterDto;
import com.dragon.banana.entity.AuthUser;
import org.mapstruct.Mapper;

/**
 * @author liulongxiang
 * @Date 2023/9/11 10:04
 * @Description 实体映射转换
 */
@Mapper(componentModel = "spring", uses = {TypeConversionWorker.class})
public interface CommonConvert {
    /**
     * registerDto to authUser
     * @param registerDto
     * @return
     */
    AuthUser registerDtoToAuthUser(RegisterDto registerDto);
}
