package hust.plane.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hust.plane.mapper.pojo.Route;
import hust.plane.service.interFace.RouteService;
import hust.plane.utils.JsonUtils;
import hust.plane.utils.LineUtil;


@Controller
public class RouteController {
	
	@Autowired
	public RouteService routeServiceImpl;
	
	//得到路由分布。解决路径序列
	@RequestMapping("/routeList")
	public String getAllRoute(Model model)
	{
		
		List<Route> allRoute = routeServiceImpl.getAllRoute();
		ArrayList<ArrayList<Double>> s=LineUtil.stringLineToList(allRoute.get(1).getRoutePath());
		String path=JsonUtils.objectToJson(s);
		model.addAttribute("path",path);
		return "route";
	}

}
