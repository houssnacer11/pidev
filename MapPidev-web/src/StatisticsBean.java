package dashboard.statistics.managedBean;



import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.itextpdf.text.pdf.codec.Base64.OutputStream;

import dashboard.service.StatisticsService;
import tn.esprit.entities.DayOff;
import tn.esprit.entities.Project;
import tn.esprit.entities.User;

@ManagedBean
@ViewScoped
public class StatisticsBean {

	private Integer nbProjects;
	private Integer nbClients;
	private Integer nbMandats;
	private Integer nbResources;
	private Integer nbResourcesByAva;
	private List<Project> map ;
	private List<User> listOfClients;
	private String keyword;
	private String keywordproject;
	private List<DayOff> dayList ;
	private List<User> listOfResources;
	private List<Project> listOfProjects;

//	private Iterable<Project> projectstaux = new ArrayList<>();

	@EJB 	 	
	StatisticsService statservice;
	

	public Integer nbOfProjects() {

		nbProjects = statservice.countProjects();
		return nbProjects;

	}

	public Integer nbOfClients() {

		nbClients = statservice.countClients();
		return nbClients;

	}

	public Integer nbOfMandats() {

		nbMandats = statservice.countMandats();
		return nbMandats;

	}

	public Integer nbOfResources() {

		nbResources = statservice.countResources();
		return nbResources;

	}
	
	public Integer nbOfResourcesAvai(Integer avai) {
		
		nbResourcesByAva = statservice.countResourcesByAvail(avai);
		return nbResourcesByAva;
		
	}
	
	public List<Project> mapLon() throws Exception {
		map = statservice.maplatlong();
		return map;
		
	}
	
	public List<User> clients() {
		if (null==keyword || "".equals(keyword)) {
		listOfClients = statservice.listClients();
		 }
		else {
			
			
			listOfClients = statservice.searchClientsByName(keyword);
			
		}
		
		return listOfClients;
		
		
	}
	
	
	public List<Project> projects() throws Exception {
		
		if (null==keywordproject || "".equals(keywordproject)) {
			listOfProjects = statservice.maplatlong();
			 }
			else {
				
				
				listOfProjects = statservice.searchProject(keywordproject);
				
			}
			
			return listOfProjects;
			
		
		
	}
	
	public void createPDF() {
		
		FacesContext facesContext=FacesContext.getCurrentInstance();
		ExternalContext externalContext=facesContext.getExternalContext();
		HttpSession session=(HttpSession) externalContext.getSession(true);
		String url ="http://localhost:18080/MapPidev-web/xhtml/clients-reports.xhtml:jessionid="+session.getId()+"?pdf=true";
			try {
				
				ITextRenderer renderer=new ITextRenderer();
				renderer.setDocument(new URL(url).toString());
				renderer.layout();
				HttpServletResponse response=(HttpServletResponse) externalContext.getResponse();
				response.reset();
				response.setContentType("application/pdf");
				response.setHeader("Content-Disposition", "inline; filename=\"print-file.dpf\"");
				java.io.OutputStream outputStream=response.getOutputStream();
				renderer.createPDF(outputStream);
				
				
				
			} catch(Exception ex) {
				
				ex.printStackTrace();
				
			}
			
			facesContext.responseComplete();
			
		
	}
	
	public List<User> listResources(){
		
		listOfResources = statservice.resources();
		return listOfResources;
		
		
	}
	
	public List<User> clientsSearch() {
		
		listOfClients = statservice.searchClientsByName(keyword);
		return listOfClients;
		
	}
	
	
	public List<DayOff> listDayOff() throws Exception {
		
		dayList = statservice.listDayOff();
		return dayList;
		
	}


	

	public Integer getNbClients() {
		return nbClients;
	}

	public void setNbClients(Integer nbClients) {
		this.nbClients = nbClients;
	}

	public Integer getNbMandats() {
		return nbMandats;
	}

	public void setNbMandats(Integer nbMandats) {
		this.nbMandats = nbMandats;
	}

	public Integer getNbResources() {
		return nbResources;
	}

	public void setNbResources(Integer nbResources) {
		this.nbResources = nbResources;
	}

	public Integer getNbProjects() {
		return nbProjects;
	}

	public void setNbProjects(Integer nbProjects) {
		this.nbProjects = nbProjects;
	}

	public Integer getNbResourcesByAva() {
		return nbResourcesByAva;
	}

	public void setNbResourcesByAva(Integer nbResourcesByAva) {
		this.nbResourcesByAva = nbResourcesByAva;
	}

	public List<Project> getMap() {
		return map;
	}

	public void setMap(List<Project> map) {
		this.map = map;
	}

	public List<User> getListOfClients() {
		return listOfClients;
	}

	public void setListOfClients(List<User> listOfClients) {
		this.listOfClients = listOfClients;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public List<DayOff> getDayList() {
		return dayList;
	}

	public void setDayList(List<DayOff> dayList) {
		this.dayList = dayList;
	}

	public List<User> getListOfResources() {
		return listOfResources;
	}

	public void setListOfResources(List<User> listOfResources) {
		this.listOfResources = listOfResources;
	}

	public String getKeywordproject() {
		return keywordproject;
	}

	public void setKeywordproject(String keywordproject) {
		this.keywordproject = keywordproject;
	}

	public List<Project> getListOfProjects() {
		return listOfProjects;
	}

	public void setListOfProjects(List<Project> listOfProjects) {
		this.listOfProjects = listOfProjects;
	}
	
	
	
	
	


	

	
	

	

}
