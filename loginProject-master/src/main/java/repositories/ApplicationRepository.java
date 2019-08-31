package repositories;

import java.util.ArrayList;
import java.util.List;

import domain.Domain;

public interface ApplicationRepository {
	
	Domain getApplicationByEmail(String email);
	void add(Domain app);
	int count();
	List<Domain> getAllRecords();

}





