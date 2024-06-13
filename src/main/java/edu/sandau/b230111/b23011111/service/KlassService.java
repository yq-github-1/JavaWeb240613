package edu.sandau.b230111.b23011111.service;

import edu.sandau.b230111.b23011111.entity.Klass;
import edu.sandau.b230111.b23011111.mapper.KlassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class KlassService {
    @Autowired
    private KlassMapper klassMapper;
//    @Autowired
//    private KlassRespository klassRespository;

    public List<Klass> findAll(Klass klass) {
        return klassMapper.findALLBySelective(klass);
//        return klassRespository.findAll(Example.of(klass));
    }
     public void deleteById(Integer id) {
         klassMapper.deleteById(id);
    }
    public void save(Klass s){
        klassMapper.save(s);
    }
    public Klass getReferenceById(Integer id) {
        return klassMapper.getReferenceById(id);
    }
    public void update(Klass s){
        klassMapper.update(s);
    }
}
