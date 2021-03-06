package hust.plane.web.controller;

import java.util.ArrayList;
import java.util.List;

import hust.plane.utils.pojo.InfoTplData;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hust.plane.mapper.pojo.Route;
import hust.plane.service.interFace.RouteService;
import hust.plane.utils.JsonUtils;
import hust.plane.utils.LineUtil;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


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
		List<String> listString = LineUtil.pathToArray(path);
		String position = listString.get(0);

		InfoTplData infoTplData=new InfoTplData("巡检路线1","<img src=\"http://s7d2.scene7.com/is/image/Caterpillar/C10602924?$cc-s$\" />","工程机械行业或许不是最危险的，但是危险程度也不低。我们身边随时都有事故发生。当我在网络上看到那么多事故的照片时，我甚至有时候都想放弃这一行去改行做其他的  可是我除了会开挖机还会干什么呢！都说隔行如隔山 。都到了有家庭的年纪了再去改行我又应该拿什么去撑起这个家呢！没有办法只有硬着头皮继续走下去。当我在这一行做的越久我就越胆小，当看到别人干一些比较危险的活或者做一些比较危险的动作的时候我都很佩服他，我承认我不如他。");
		String result = JsonUtils.objectToJson(infoTplData);
		model.addAttribute("infoData",result);
		model.addAttribute("position",position);

		model.addAttribute("path",path);
		return "route";
	}
    /**
     * @author rfYang  
     * @date 2018/6/29 14:12  
     * @param [mv]  
     * @return java.lang.String  
     */
//	@RequestMapping(value = "/testRoute",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
//	@ResponseBody
//	public String testRoute(ModelAndView mv){
//		InfoTplData infoTplData=new InfoTplData("光缆干线1","<img src=\"http://s7d2.scene7.com/is/image/Caterpillar/C10602924?$cc-s$\" />","工程机械行业或许不是最危险的，但是危险程度也不低。我们身边随时都有事故发生。当我在网络上看到那么多事故的照片时，我甚至有时候都想放弃这一行去改行做其他的  可是我除了会开挖机还会干什么呢！都说隔行如隔山 。都到了有家庭的年纪了再去改行我又应该拿什么去撑起这个家呢！没有办法只有硬着头皮继续走下去。当我在这一行做的越久我就越胆小，当看到别人干一些比较危险的活或者做一些比较危险的动作的时候我都很佩服他，我承认我不如他。");
//		String result = JsonUtils.objectToJson(infoTplData);
//		return result;
//
//	}

}
