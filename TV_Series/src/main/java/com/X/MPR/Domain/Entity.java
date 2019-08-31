package com.X.MPR.Domain;

import com.X.MPR.Service.UOW.UnitOfWork;

public class Entity {
	private long id;
	
	private EntityState state;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EntityState getState() {
		return state;
	}

	public void setState(EntityState state) {
		this.state = state;
	}

	protected void markNew() {
		UnitOfWork.getCurrent().registerNew(this);
	}
	protected void markNClean() {
		UnitOfWork.getCurrent().registerClean(this);
	}
	protected void markDirty() {
		UnitOfWork.getCurrent().registerDirty(this);
	}
	protected void markRemoved() {
		UnitOfWork.getCurrent().registerRemoved(this);
	}
}
