package edu.sandau.b230111.b23011111.controller;

import edu.sandau.b230111.b23011111.entity.Klass;
import edu.sandau.b230111.b23011111.service.KlassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("klass")
public class KlassController {
    @Autowired
    private KlassService klassService;
//    @Autowired
//    private KlassRespository klassRespository;
//    @RequestMapping("/search")
//    public String search(ModelMap map,Klass klass){
//       // List<Klass> klasss=klassRespository.findByNameAndAge(klass.getName(),klass.getAge());
//        if("".equals(klass.getName())){
//            klass.setName(null);
//        }
//        List<Klass> klasss=klassService.findAll(klass);//从数据库取数据
//        map.put("stu1",klassService.findAll(klass));
//        return "list";
//    }
//    @RequestMapping("/")
//    public String index(Model model){
//        Klass s=new Klass("fsj","1");
//        model.addAttribute("name",s.getName());
//        model.addAttribute("id", s.getId());
//        model.addAttribute("id", s.getAge());
//        return "list";
//    }
    //    @RequestMapping("/index2")
//    public String index2(ModelMap model){
//        Klass s1=new Klass("fsj",30);
//        Klass s2=new Klass("fsj",30);
//        Klass s3=new Klass("fsj",30);
//        List<Klass> klassList=new ArrayList<>();
//        klassList.add(s1);
//        klassList.add(s2);
//        klassList.add(s3);
//        model.put("stu1",klassList);
//        return "list";
//    }

    //    public static List<Klass> klassList=new ArrayList<>();
//    static {
//        Klass s1=new Klass("fsj","1");
//        Klass s2=new Klass("fsj1","2");
//        Klass s3=new Klass("fsj2","3");
//        Klass s4=new Klass(" ","4");
//        klassList.add(s1);
//        klassList.add(s2);
//        klassList.add(s3);
//        klassList.add(s4);
//    }
    @RequestMapping("/list")
    public String list(ModelMap map, Klass klass) {
        if ("".equals(klass.getName())) {
            klass.setName(null);
        }
        map.put("stu1", klassService.findAll(klass));//从数据库取数据
        return "klass/list";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        klassService.deleteById(id);
        return "redirect:/klass/list";
    }

    @RequestMapping("create")
    public String create() {
        return "/klass/create";
    }

    @RequestMapping("save")
    public String save(Klass s) {
        if (s.getId() != null)
            klassService.update(s);
        else
            klassService.save(s);
        return "redirect:/klass/list";
    }

    @RequestMapping("update/{id}")
    public String update(@PathVariable Integer id, ModelMap map) {
        Klass s = klassService.getReferenceById(id);
        map.put("klass", s);
        return "klass/update";
    }

}


