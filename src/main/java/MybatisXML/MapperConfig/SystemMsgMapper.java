package MybatisXML.MapperConfig;

import MybatisXML.Entitymodel.SystemMsg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Mapper
public interface SystemMsgMapper {

    public List<SystemMsg> getSysMsg(@Param("lastLogin") Date lastLogin);
}
