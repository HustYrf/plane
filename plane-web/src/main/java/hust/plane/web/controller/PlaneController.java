package hust.plane.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hust.plane.mapper.pojo.Plane;
import hust.plane.service.interFace.PlaneService;
import hust.plane.utils.JsonUtils;
import hust.plane.utils.PointUtil;

@Controller
public class PlaneController {
	@Autowired
	public PlaneService planeServiceimpl;
	
	@RequestMapping("/plane")
	//获取飞机信息
	//实例解决经纬度路径
	public String getAllPlane(Model model)
	{
		List<Plane> allPlane = planeServiceimpl.getAllPlane();
		List<Double> p=PointUtil.StringPointToList(allPlane.get(0).getFlongda());
		String pp =JsonUtils.objectToJson(p);
		model.addAttribute("pp",pp);		
		return "plane";
	}

	
	@RequestMapping("/planeList")
	//获取飞机列表信息
	//实例解决经纬度路径
	public String getPlaneList(Model model)
	{
		List<Plane> allPlane = planeServiceimpl.getAllPlane();
		List planeList = new ArrayList<String>();
		List planeInfoList = new ArrayList<String>();
		
		for(int i=0;i<allPlane.size();i++) {
			List<Double> p=PointUtil.StringPointToList(allPlane.get(i).getFlongda());
			String planeitem =JsonUtils.objectToJson(p);
			Plane plane = allPlane.get(i);
			plane.setFlongda(null);;
			String planeinfoitem = JsonUtils.objectToJson(plane);
			planeList.add(planeitem);
			planeInfoList.add(planeinfoitem);
		}
		
		model.addAttribute("planeListInfo",planeInfoList.toString());
		model.addAttribute("planepoints",planeList.toString());	
		
		return "planeList";
	}
}
