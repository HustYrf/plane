package hust.plane.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hust.plane.mapper.mapper.RouteMapper;
import hust.plane.mapper.pojo.Route;
import hust.plane.service.interFace.RouteService;

@Service
public class RouteServiceImpl implements RouteService {
	
	@Autowired
	private RouteMapper routeMapper;

	@Override
	public List<Route> getAllRoute() {
		// TODO Auto-generated method stub
		List<Route> routeList = routeMapper.selectALLRoute();
		return routeList;
	}

}
