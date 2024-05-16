package com.exterro;

import java.util.List;

public interface Service_Admin {


	public void saver(Admin_Regi add);

	public boolean checkCredentials(String name,String password);

	public void adding(Admin_add_on ad);

	public List<Admin_add_on> findAll();

	public List<Admin_add_on> findByGender(String gender);

	public List<Admin_add_on> findByColumnNameContaining(String find);

	public Cart_Adder saver_cart(Cart_Adder ad);

	public List<Cart_quantity> findingAll();

	public Integer find_qty(String productid);

	public Cart_quantity saver_qty_cart(Cart_quantity qty);

}
