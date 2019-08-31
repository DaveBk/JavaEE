package domain;

import java.util.ArrayList;
import java.util.List;

import repositories.ApplicationRepository;

public class DummyAplicationRepository implements ApplicationRepository 
{
	private static List<Domain> db = new ArrayList<Domain>();
	@Override
	public Domain getApplicationByEmail(String email)
	{
		for(Domain app:db){
			if(app.getEmail().equalsIgnoreCase(email))
				return app;
		}
		return null;
		
	}
	@Override
	public List<Domain> getAllRecords()
	{
		return db;
	}


@Override
public void add(Domain app){
	db.add(app);
}

@Override
public int count(){
	return db.size();
}
}