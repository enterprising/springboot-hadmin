package com.sparrow.hadmin.controller.admin.vacation;

import com.sparrow.hadmin.common.JsonResult;
import com.sparrow.hadmin.entity.Vacation;
import com.sparrow.hadmin.service.IVacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 假期管理
 * <p>
 * Created by peng.tan on 17/12/20.
 */
@Controller @RequestMapping("/admin/vacation") public class VacationController {

    @Autowired private IVacationService vacationService;

    /**
     * 用户管理初始化页面
     *
     * @return
     */
    @RequestMapping(value = { "/", "/index" }) public String index() {
        System.out.println("hello vacation!");
        return "admin/user/index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(ModelMap map) {
        return "admin/vacation/form";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(ModelMap map) {

        System.out.println("get edit!");

        return "admin/vacation/form";
    }

    @RequestMapping(value= {"/edit"} ,method = RequestMethod.POST)
    @ResponseBody
    public JsonResult edit(Vacation vacation, ModelMap map) {

        System.out.println("edit");

        try {
            vacationService.saveOrUpdate(vacation);
        } catch (Exception e) {
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }

}
