package com.wqf.equipment.controller;


import com.wqf.equipment.service.EquipmentService;
import com.wqf.security.User;
import com.wqf.utils.ResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * hzj 设备
 */
@RestController
@RequestMapping("equipment")
public class EquipmentController {
    Logger logger = LoggerFactory.getLogger(getClass());

//    @Autowired
//    private EquipmentService equipmentService;
    /**
     * 设备管理-新增
     * @param
     * @return
     */
    @RequestMapping("insert")
    @ResponseBody
    @Transactional
    public ResultVo insert() {
//        logger.info("equipment/insert----------入参"+equipmentEntity.toString());
        try{
//            equipmentService.insertIndex(equipmentEntity);
            return new ResultVo();
        }catch (Exception e){
            e.printStackTrace();
            return new ResultVo();
        }
    }

//    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//    public static String encodePassword(String password){
//        return bCryptPasswordEncoder.encode(password);
//    }
//
//    public static void main(String[] args) {
//        String password = "123456";
//        String pwd = encodePassword(password);
//        System.out.println(pwd);
//    }
}