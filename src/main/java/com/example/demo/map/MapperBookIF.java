package com.example.demo.map;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.demo.dto.CreateBookInfoRequest;
import com.example.demo.entity.BookInfo;

@Mapper(componentModel = "spring")
public interface MapperBookIF {
	
	@Mapping(target = "createDate", ignore = true)
	@Mapping(target = "isDisable", ignore = true)
	@Mapping(target = "modifyDate", ignore = true)
	@Mapping(target = "modifiedUser", ignore = true)
	@Mapping(target = "createUser", ignore = true)
	@Mapping(target = "modifyAction", ignore = true)
	@Mapping(target = "id", ignore = true)
	BookInfo getBookInfoFromCreateBookInfoRequest(CreateBookInfoRequest request);

}
