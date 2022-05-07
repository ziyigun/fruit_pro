package com.ali.service.impl;

import com.ali.entity.Fruit;
import com.ali.mapper.FruitMapper;
import com.ali.service.FruitService;
import com.ali.util.DataUtil;
import com.ali.vo.BarVO;
import com.ali.vo.DataVO;
import com.ali.vo.PieVO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2022-05-07
 */
@Service
public class FruitServiceImpl extends ServiceImpl<FruitMapper, Fruit> implements FruitService {

    @Autowired
    private FruitMapper fruitMapper;

    @Override
    public BarVO barVOList() {
        BarVO barVO = new BarVO();
        List<String> names = new ArrayList<>();
        List<DataVO> values = new ArrayList<>();
        //先查出来数据
        List<Fruit> fruits = fruitMapper.selectList(null);
        for (Fruit fruit : fruits) {
            names.add(fruit.getName());
            DataVO dataVO = new DataVO();//销量、颜色
            dataVO.setValue(fruit.getSale());
            Map<String, String> map = DataUtil.createItemStyle(fruit.getSale());//根据销量，返回不同的颜色
            dataVO.setItemStyle(map);
            values.add(dataVO);
        }
        barVO.setNames(names);
        barVO.setValues(values);
        return barVO;
    }

    @Override
    public List<PieVO> pieVOList() {
        List<PieVO> pieVOList = new ArrayList<>();
        List<Fruit> fruits = fruitMapper.selectList(null);
        for (Fruit fruit : fruits) {
            PieVO pieVO = new PieVO();
            pieVO.setName(fruit.getName());
            pieVO.setValue(fruit.getSale());
            pieVO.setItemStyle(DataUtil.createItemStyle(fruit.getSale()));
            pieVOList.add(pieVO);
        }
        return pieVOList;
    }
}
