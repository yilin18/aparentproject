package com.offcn.controller;

import com.offcn.pojo.Person;
import com.offcn.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * company: www.abc.com
 * Author: 苏依林
 * Create Data: 2019/12/23
 */
@Controller
public class PersonController {
    @Autowired
    PersonService personService;

    /***
     * 获取全部用户信息
     * @return
     */
    @GetMapping("/")
    public String getPersonList(Model model) {
        Map map = personService.getPersonMap();
        List<Person> list = (List<Person>) map.get("list");
        model.addAttribute("page", list);
        model.addAttribute("ProviderVersion", map.get("ProviderVersion"));
        return "person/list";
    }

    /***
     * 跳转到新增用户界面
     * @param person
     * @return
     */
    @RequestMapping("/toAdd")
    public String toadd(Person person) {
        return "person/personAdd";//跳转到personAdd.html
    }

    /***
     * 新增用户
     * @param person
     * @return
     */
    @PostMapping("/add")
    public String createPerson(Person person) {
        personService.createPerson(person);
        return "redirect:/";
    }

    @RequestMapping("/toEdit/{id}")
    public String toEdit(Model model, @PathVariable("id") Long id) {
        Person person = personService.getPerson(id);
        model.addAttribute("person", person);
        return "person/personEdit"; //跳转到personEdit.html页面
    }

    @RequestMapping("/edit")
    public String edit(Person person) {
        personService.updatePerson(person.getId(), person);
        return "redirect:/";//获取列表数据并显示
    }


    /***
     * 删除指定id用户
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable("id") Long id) {
        personService.deletePerson(id);
        return "redirect:/";

    }

}
