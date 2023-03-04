package com.lsz.persistence.user;

import com.lsz.user.User;
import com.lsz.framework.valueobject.Password;
import com.lsz.framework.valueobject.UserId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @ClassName UserDoConverter
 * @Description TODO
 * @Author lishuzeng
 * @Date 2023/3/2 下午11:23
 * @Version 1.0.0
 **/
@Mapper(imports = {UserId.class, Password.class})
public interface UserDoConverter {

    UserDoConverter INSTANCE = Mappers.getMapper(UserDoConverter.class);


    @Mapping(target = "userId", expression = "java(UserId.of(userDo.getUserId()))")
    @Mapping(target = "password", expression = "java(Password.of(userDo.getPassword(), userDo.getSalt()))")
    @Mapping(target = "gmtCreate", expression = "java(Day.of(userDo.getGmtCreate()))")
    @Mapping(target = "gmtModified", expression = "java(Day.of(userDo.getGmtModified()))")
    User toEntity(UserDo userDo);

    @Mapping(target = "userId", source = "user.userId.id")
    @Mapping(target = "password", source = "user.password.password")
    @Mapping(target = "salt", source = "user.password.salt")
    @Mapping(target = "gmtCreate", source = "user.gmtCreate.date")
    @Mapping(target = "gmtModified", source = "user.gmtModified.date")
    UserDo toDo(User user);


}
