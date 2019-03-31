package dashboard.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArray;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.xpath.XPathExpression;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import dashboard.interfaces.StatisticsServiceLocal;
import dashboard.interfaces.StatisticsServiceRemote;
import tn.esprit.entities.DayOff;
import tn.esprit.entities.Project;
import tn.esprit.entities.User;

@Stateless
@LocalBean
public class StatisticsService implements StatisticsServiceLocal, StatisticsServiceRemote {

	@PersistenceContext(unitName="MapPidev-ejb")
	EntityManager em;
	
	@Override
	public Integer countProjects() {
		// TODO Auto-generated method stub
		Client client = ClientBuilder.newClient();

		WebTarget target = client.target("http://localhost:21514/api/nbreProjects");

		Response response = target.request().get();

		Integer result = response.readEntity(Integer.class);
		System.out.println(result);
		return result;

	}

	@Override
	public Integer countMandats() {
		// TODO Auto-generated method stub
		Client client = ClientBuilder.newClient();

		WebTarget target = client.target("http://localhost:21514/api/nbrMandats");

		Response response = target.request().get();

		Integer result = response.readEntity(Integer.class);
		System.out.println(result);
		return result;
	}

	@Override
	public Integer countClients() {
		// TODO Auto-generated method stub
		Client client = ClientBuilder.newClient();

		WebTarget target = client.target("http://localhost:21514/api/nbreClients");

		Response response = target.request().get();

		Integer result = response.readEntity(Integer.class);
		System.out.println(result);
		return result;
	}

	@Override
	public Integer countResources() {
		// TODO Auto-generated method stub
		Client client = ClientBuilder.newClient();

		WebTarget target = client.target("http://localhost:21514/api/nbreResources");

		Response response = target.request().get();

		Integer result = response.readEntity(Integer.class);
		System.out.println(result);
		return result;
	}

	@Override
	public Integer countResourcesByAvail(Integer availability) {
		Integer count = Math.toIntExact((Long)em.createQuery("SELECT count(r) FROM User r where r.availability =:availability").setParameter("availability",availability).getSingleResult());
		return count;
	}

	@Override
	public List<Project> maplatlong() throws Exception {
		// TODO Auto-generated method stub
		
		List<Project> listprojects = new ArrayList<>();
		TypedQuery<Project> q = em.createQuery("SELECT e from Project e",Project.class);
		listprojects = q.getResultList();
		List<Project> resultprojects = new ArrayList<>();
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();   
	    Date dateNow =format.parse(format.format(calendar.getTime()));
		
		for (Project r : listprojects) {
			
		    //System.out.println(format.format(calendar.getTime()));
		    
		    //System.out.println(dateNow);
		    Date datebegin = format.parse((r.getDateBegin()).substring(0,10));
		    Date dateend = format.parse((r.getDateEnd()).substring(0,10));
		    
		    //System.out.println(format.format(datebegin));
		    
		    long diffInMillies = Math.abs(dateNow.getTime() - datebegin.getTime());
		    long totalDayPass = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		    
		    long diffInMillies1 = Math.abs(dateend.getTime() - datebegin.getTime());
		    long peridoOfProject = TimeUnit.DAYS.convert(diffInMillies1, TimeUnit.MILLISECONDS);
		    
		    System.out.println("Total Day Pass " + totalDayPass);
		    System.out.println("Period Of Project " + peridoOfProject);
		    
		    double cout = ((double)totalDayPass/(double)peridoOfProject)*100;
		    
		    DecimalFormat df = new DecimalFormat("##");
		    String dx=df.format(cout);
		    cout =Double.valueOf(dx);
		    System.out.println("Le Taux est " + cout);
		    
		
			
			
			String longitude = "";
			String latitude = "";
			String adress = r.getAddress_Address();
			
			int responseCode = 0;
		    String api = "https://maps.googleapis.com/maps/api/geocode/xml?key=AIzaSyCOISCpK2Xf8oSV3WAEIiJbYrs2rN5wgDE&address=" + URLEncoder.encode(adress, "UTF-8") + "&sensor=true";
		    URL url = new URL(api);
		    HttpURLConnection httpConnection = (HttpURLConnection)url.openConnection();
		    httpConnection.connect();
		    responseCode = httpConnection.getResponseCode();
		    if(responseCode == 200)
		    {
		      DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();;
		      Document document = builder.parse(httpConnection.getInputStream());
		      XPathFactory xPathfactory = XPathFactory.newInstance();
		      XPath xpath = xPathfactory.newXPath();
		      javax.xml.xpath.XPathExpression expr = xpath.compile("/GeocodeResponse/status");
		      String status = (String)expr.evaluate(document,XPathConstants.STRING);
		      if(status.equals("OK"))
		      {
		         expr =  xpath.compile("//geometry/location/lat");
		         latitude = (String)expr.evaluate(document, XPathConstants.STRING);
		         expr = xpath.compile("//geometry/location/lng");
		         longitude = (String)expr.evaluate(document, XPathConstants.STRING);
		         System.out.println(latitude);
		         System.out.println(longitude);
		         
		      }
		      else
		      {
		         throw new Exception("Error from the API - response status: "+status);
		      }
		    }
		  
		    int Id = r.getProjectId();
		    String Name = r.getName();
		    String dateb = (r.getDateBegin()).substring(0,10);
		    String datee = (r.getDateEnd()).substring(0,10);
		    int totalNbrRessources = r.getTotalNbrRessources();
		    int totalNbrRessourcesLevio = r.getTotalNbrRessourcesLevio();
		    
		    
		    resultprojects.add(new Project(Id,Name,adress,longitude,latitude,cout,dateb,datee, totalNbrRessources,totalNbrRessourcesLevio));
		    
		    
		    }
		
		
		
		return resultprojects;
	}

	@Override
	public List<User> listClients() {
		// TODO Auto-generated method stub
		List<User> listclients = new ArrayList<>();
		TypedQuery<User> q = em.createQuery("SELECT e from User e where e.type = 0",User.class);
		listclients = q.getResultList();
		
		return listclients;
	}

	@Override
	public List<User> searchClientsByName(String firstN) {
		// TODO Auto-generated method stub
		List<User> listclients = new ArrayList<>();
		TypedQuery<User> q = em.createQuery("SELECT e from User e where e.type = 0 and e.firstName =:firstName",User.class).setParameter("firstName",firstN);
		listclients = q.getResultList();
		
		return listclients;
	}

	@Override
	public List<DayOff> listDayOff() throws Exception {
		// TODO Auto-generated method stub
		List<DayOff> dayOffs = new ArrayList<>();
		TypedQuery<DayOff> q = em.createQuery("SELECT e from DayOff e",DayOff.class);
		dayOffs = q.getResultList();
		
		List<DayOff> resultDayOff =  new ArrayList<>();
		
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		for (DayOff r : dayOffs) { 
			
			String statName = "";
			
			String dateb = (r.getDateBegin()).substring(0,10);
			String datee = (r.getDateEnd()).substring(0,10);
			Integer state = r.getState();
			User resource  =r.getUser();
			
			if (r.getState() == 0) {
				
				statName="SeekDays";
				
			}
			
			else if (r.getState() == 1) {
				
				statName="Maternety";
				
				
			}
			
			else statName = "Holidays";
			
			
			resultDayOff.add(new DayOff(dateb,datee,state,resource,statName));
				
		}
		
		
		
		return resultDayOff;
	}

	@Override
	public List<User> resources() {
		// TODO Auto-generated method stub
		List<User> listResources = new ArrayList<>();
		TypedQuery<User> q = em.createQuery("SELECT e from User e where e.type = 1",User.class);
		listResources = q.getResultList();
		
		return listResources;
	}

	@Override
	public List<Project> searchProject(String nameP) {
		// TODO Auto-generated method stub
		List<Project> listp = new ArrayList<>();
		TypedQuery<Project> q = em.createQuery("SELECT e from Project e where e.name =:nameP",Project.class).setParameter("nameP",nameP);
		listp = q.getResultList();
		
		return listp;
	}


}
