package cn.nb.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.nb.service.AdminService;
import cn.nb.web.vo.AdminVo;

/**
 * 	登录controller
 * 	@author xuyao
 * */
@Controller
@RequestMapping("/")
public class LoginController extends BaseController{
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView clist(AdminVo adminVo, HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		ModelAndView mav = new ModelAndView();
//		mav.addObject("list",list);
		
		if(adminService.exitAdmin(adminVo)){
			request.getSession().setAttribute("AdminVo", adminVo);
			mav.setViewName("main.jsp");
		}else{
			request.getSession().setAttribute("AdminVo", null);
			mav.setViewName("index.jsp");
		}
		System.out.println(username+" "+password);
		//HttpResponse.responseContentTypeJson(response, "");
		return mav;
	}
	
}
