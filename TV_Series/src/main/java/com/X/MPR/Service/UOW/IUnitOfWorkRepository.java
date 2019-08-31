package com.X.MPR.Service.UOW;
import com.X.MPR.Domain.Entity;
public interface IUnitOfWorkRepository {


		public void persistAdd(Entity entity);
		public void persistUpdate(Entity entity);
		public void persistDelete(Entity entity);

}
