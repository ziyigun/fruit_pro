package com.ali.service;

import com.ali.entity.Fruit;
import com.ali.vo.BarVO;
import com.ali.vo.PieVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2022-05-07
 */
public interface FruitService extends IService<Fruit> {
    /**
     * 获取柱状图水果数据
     * @return
     */
    public BarVO barVOList();

    public List<PieVO> pieVOList();
}
