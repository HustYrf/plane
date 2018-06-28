package hust.plane.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hust.plane.mapper.mapper.PlaneMapper;
import hust.plane.mapper.pojo.Plane;
import hust.plane.service.interFace.PlaneService;

@Service
public class PlaneServiceImpl implements PlaneService{
	
	@Autowired
	public PlaneMapper planeMapper;

	@Override
	public List<Plane> getAllPlane() {
		
		List<Plane> planeList = planeMapper.selectALLPlane();
		return planeList;
	}

}
