//package com.wqf.utils;
//
//import com.creatunion.modules.SerialNumber.entity.SerialNumber;
//import com.creatunion.modules.SerialNumber.service.SerialNumberService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Date;
//
//@Service
//@Transactional
//public class IdUtils {
//
//    @Autowired
//    private SerialNumberService serialNumberService;
//
//    public static String getId(){
//        return new Date().getTime()+"";
//    }
//
//    public String getId(String type){
//        synchronized (this){
//            String yearAndMonth = DateUtils.getYear() + DateUtils.getMonth();
//            SerialNumber serialNumber = serialNumberService.getNumberByTypeAndTimeStr(type, yearAndMonth);
//            String id = null;
//            if(serialNumber == null){
//                SerialNumber serialNumber1 = new SerialNumber();
//                serialNumber1.setType(type);
//                serialNumber1.setTimeStr(yearAndMonth);
//                serialNumber1.setNumber(1);
//                serialNumberService.save(serialNumber1);
//                id = serialNumber1.getType()+"-"+serialNumber1.getTimeStr()+"-"+"0001";
//            }else{
//                int i = serialNumber.getNumber() + 1;
//                String number = null;
//                serialNumber.setNumber(i);
//                serialNumberService.save(serialNumber);
//                int length = (i + "").length();
//                if(length == 1){
//                    number =  "000"+i;
//                }else if(length == 2){
//                    number =  "00"+i;
//                }else if(length == 3){
//                    number =  "0"+i;
//                }else{
//                    number =  ""+i;
//                }
//                id = serialNumber.getType()+"-"+serialNumber.getTimeStr()+"-"+number;
//            }
//            return id;
//        }
//    }
//}
