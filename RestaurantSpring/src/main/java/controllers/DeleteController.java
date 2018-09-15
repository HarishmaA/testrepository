package controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

@RestController
public class DeleteController {
	@DeleteMapping(path = "/delete", produces = "application/json")
	public String delete(@RequestParam(value="receipeId",required=true) Long receipeId) {
		Key receipeKey = KeyFactory.createKey("Receipe", receipeId);
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		datastore.delete(receipeKey);
		return "Successfully deleted ReceipeId " + receipeId;
	}
}
