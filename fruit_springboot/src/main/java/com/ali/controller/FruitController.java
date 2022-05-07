package com.ali.controller;


import com.ali.entity.Fruit;
import com.ali.service.FruitService;
import com.ali.vo.BarVO;
import com.ali.vo.PieVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 * @since 2022-05-07
 */
@RestController
@RequestMapping("/fruit")
public class FruitController {
    @Autowired
    private FruitService fruitService;

    @GetMapping("/list")
    public List<Fruit> getFruits(){
        return fruitService.list();
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteFruit(@PathVariable("id") Integer id){
        return fruitService.removeById(id);
    }

    @GetMapping("/find/{id}")
    public Fruit FindById(@PathVariable("id") Integer id){
        return fruitService.getById(id);
    }

    @PutMapping("/update")
    public boolean update(@RequestBody Fruit fruit){
        return fruitService.updateById(fruit);
    }

    @PostMapping("/add")
    public boolean add(@RequestBody Fruit fruit){
        return fruitService.save(fruit);
    }

    @GetMapping("/barVO")
    public BarVO barVO(){
        return fruitService.barVOList();
    }
    
    @GetMapping("/pieVO")
    public List<PieVO> pieVO(){
        return fruitService.pieVOList();
    }
}

