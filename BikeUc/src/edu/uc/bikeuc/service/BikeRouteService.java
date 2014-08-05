package edu.uc.bikeuc.service;

import java.util.ArrayList;

import android.content.Context;

import edu.uc.bikeuc.dao.BikeRouteDAO;
import edu.uc.bikeuc.dao.IBikeRouteDAO;
import edu.uc.bikeuc.dto.BikeRoute;

public class BikeRouteService implements IBikeRouteService {
	//declare a data access object 
	private IBikeRouteDAO routeDAO;	

	public BikeRouteService(Context ctx) {
		//instantiate the data access object
		routeDAO = new BikeRouteDAO(ctx);
	}

	@Override
	public ArrayList<BikeRoute> fetchAllRoutes() throws Exception {
		//call the method on the data access object
		ArrayList<BikeRoute> routes = new ArrayList<BikeRoute>();
		routes = routeDAO.fetchAllRoutes();
		//return the value
		return routes;
	}

	@Override
	public BikeRoute fetchRouteById(Integer id) throws Exception {
		//call the method on the data access object
		BikeRoute route = routeDAO.fetchRouteById(id);
		//return the value
		return route;
	}

	@Override
	public BikeRoute fetchNearestRoute(double lat, double lon) throws Exception {
		//call the method on the data access object
		BikeRoute route = routeDAO.fetchNearestRoute(lat, lon);
		//return the value
		return route;
	}

	@Override
	public void save(BikeRoute route) throws Exception {
		//call the method on the data access object
		routeDAO.save(route);
		//no return
	}

	@Override
	public String fetchPrime() throws Exception {
		//call the method on the data access object
		String status = routeDAO.fetchPrime();
		//no return
		return status;
	}
	
	@Override
	public BikeRoute fetchFirstRoute() throws Exception {
		//call the method on the data access object
		BikeRoute route = routeDAO.fetchFirstRoute();
		//return the value
		return route;
	}

}
