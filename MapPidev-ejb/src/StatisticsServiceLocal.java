package dashboard.interfaces;

import java.io.IOException;
import java.util.List;

import javax.ejb.Local;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import tn.esprit.entities.DayOff;
import tn.esprit.entities.Project;
import tn.esprit.entities.User;

@Local
public interface StatisticsServiceLocal {
	
	
	public Integer countProjects();
	public Integer countMandats();
	public Integer countClients();
	public Integer countResources();
	public Integer countResourcesByAvail(Integer avai);
	public List<Project> maplatlong() throws Exception;
	public List<User> listClients();
	public List<User> searchClientsByName(String firstN);
	public List<DayOff> listDayOff() throws Exception;
	public List<Project> searchProject(String nameP);
	 
	

}
