package edu.sandau.b230111.b23011111.mapper;

import edu.sandau.b230111.b23011111.entity.Klass;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface KlassMapper {
    List<Klass> findALL();
    List<Klass> findALLBySelective(Klass klass);
    @Delete("delete from Klass where id=#{id}")
    void deleteById(Integer id);
    @Insert("insert into Klass(id,name,major) values(#{id},#{name},#{major})")
    void save(Klass s);

    @Update("update Klass set name=#{name},major=#{major} where id=#{id}")
    void update(Klass s);
    @Select("select * from Klass where id=#{id}")
    Klass getReferenceById(Integer id);
}
