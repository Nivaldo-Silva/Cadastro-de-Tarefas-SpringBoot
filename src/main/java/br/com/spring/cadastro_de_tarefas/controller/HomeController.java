package br.com.spring.cadastro_de_tarefas.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.spring.cadastro_de_tarefas.model.Cadastro;


@Controller
public class HomeController {
    
    List<Cadastro> tasks = new ArrayList<>();

  @GetMapping("/create")
  public ModelAndView home() {
    ModelAndView mv = new ModelAndView("create");
    mv.addObject("task", new Cadastro());
    return mv;
  }

  @PostMapping("/create")
  public String create(Cadastro task) {
    System.out.println(" Get ID" + task.getId());

    if (task.getId() != null) {
      Cadastro taskFind = tasks.stream().filter(taskItem -> task.getId().equals(taskItem.getId())).findFirst().get();
      tasks.set(tasks.indexOf(taskFind), task);
    } else {
      Long id = tasks.size() + 1L;
      tasks.add(new Cadastro(id, task.getName(), task.getDate()));
    }

    return "redirect:/list";
  }

  @GetMapping("/list")
  public ModelAndView list() {
    ModelAndView mv = new ModelAndView("list");
    mv.addObject("tasks", tasks);
    return mv;
  }


  @GetMapping("/edit/{id}")
  public ModelAndView edit(@PathVariable("id") Long id) {
    ModelAndView mv = new ModelAndView("create");

    Cadastro taskFind = tasks.stream().filter(task -> id.equals(task.getId())).findFirst().get();
    mv.addObject("task", taskFind);
    return mv;
  }

}
