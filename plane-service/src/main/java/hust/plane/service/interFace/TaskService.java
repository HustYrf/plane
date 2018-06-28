package hust.plane.service.interFace;

import java.util.List;

import hust.plane.mapper.pojo.Task;
import hust.plane.utils.page.TailPage;
import hust.plane.utils.page.TaskPojo;


public interface TaskService {
	
	public List<TaskPojo> getALLTask();
	
	public TailPage<TaskPojo> queryPage(Task task,TailPage<TaskPojo> page);

	public void saveTask(Task task);

}
