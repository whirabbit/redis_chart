package com.fehead.chart.demos.controller;

import com.fehead.chart.demos.pojo.FormMessage;
import com.fehead.chart.demos.pojo.ResultToForm;
import com.fehead.chart.demos.pojo.ResultToList;
import com.fehead.chart.demos.service.AllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChartController {
    @Autowired
    AllService allService;
    /*
    * 获取表格信息
    * */
    @CrossOrigin(origins = {"*"},maxAge = 3000)
    @GetMapping("/form/{name}")
    public ResultToForm form(@PathVariable String name){
    ResultToForm resultToForm =new ResultToForm();
    resultToForm.setCode(200);
        List<FormMessage> formMessage = allService.getFormMessage( name);
        resultToForm.setMessage(formMessage);
    resultToForm.setLength(formMessage.size());
        return resultToForm;
    }
    /*
     * 获取列表信息
     * */
    @CrossOrigin(origins = {"*"},maxAge = 3000)
    @GetMapping("/list")
    public ResultToList list(){
        ResultToList resultToList=new ResultToList();
        resultToList.setCode(200);
        List list=allService.getList();
        resultToList.setList(list);
        resultToList.setLength(list.size());
        return resultToList;
    }
}
