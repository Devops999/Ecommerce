package com.niit.dao;

import java.util.List;

import com.niit.domain.Supplier;

public interface SupplierDao {
	public boolean insert(Supplier supplier);

	public boolean update(Supplier supplier);

	public boolean delete(Supplier supplier);

	public Supplier getSupplierById(int id);

	public Supplier getSupplierByName(String name);

	public List<Supplier> list();
}
