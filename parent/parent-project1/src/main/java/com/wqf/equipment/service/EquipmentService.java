package com.wqf.equipment.service;

import com.wqf.equipment.entity.Equipment;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 设备表(Equipment)表服务接口
 *
 * @author makejava
 * @since 2020-05-12 11:56:29
 */
@Service
public interface EquipmentService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Equipment queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Equipment> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param equipment 实例对象
     * @return 实例对象
     */
    Equipment insert(Equipment equipment);

    /**
     * 修改数据
     *
     * @param equipment 实例对象
     * @return 实例对象
     */
    Equipment update(Equipment equipment);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}