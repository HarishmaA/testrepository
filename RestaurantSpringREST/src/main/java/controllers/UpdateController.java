package controllers;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

@RestController
public class UpdateController {
	@PutMapping(path = "/update", produces = "application/json")
	public String update(@RequestParam(value="receipeId") Long receipeId, @RequestParam(value="receipeName") String receipeName) {
		Key receipeKey = KeyFactory.createKey("Receipe", receipeId);
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Entity result = null;
		try {
			result = datastore.get(receipeKey);
		} catch (EntityNotFoundException e) {
			return "Oops! Receipe not found!!";
		}
		result.setProperty("receipeName", receipeName);
		datastore.put(result);
		return "Successfully Updated!!!";
	}
}
