package com.vegitables.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vegitables.entities.Admin;
import com.vegitables.entities.Customer;
import com.vegitables.entities.User;
import com.vegitables.repository.ILoginRepository;

@Service
public class ILoginServiceImpl implements ILoginService {

//	@Autowired
//	 IUserRepository userRepo;

	@Autowired
	ILoginRepository loginRepo;

	/*
	 * Method Name - validatingLoginCustomer, Parameter List - User object, Return
	 * type - String , Description - Validating user to check whether he/she is
	 * Customer.
	 */
	@Override
	public String validateLoginCustomer(User user) {
		// TODO Auto-generated method stub
		String str = null;
		Optional<Customer> customerObj = loginRepo.findByEmailId(user.getUserId());
		if (!customerObj.isPresent()) {
			System.out.println(customerObj);
			str = "Customer not found.";

		} else {
			String pwd = customerObj.get().getPassword();
			if (!pwd.equals(user.getPassword())) {
				str = "Wrong password";

			} else {
				str = "Logged in successful as a Customer";
			}
		}
		return str;
	}

	/*
	 * Method Name - validatingLoginUser, Parameter List - User object, Return type
	 * - String , Description - Validating user to check whether he/she is Admin.
	 */
	@Override
	public String validateLoginAdmin(User user) {
		// TODO Auto-generated method stub
		String str = null;
		Optional<Admin> adminObj = loginRepo.findByAdminId(user.getUserId());
		if (!adminObj.isPresent()) {
			System.out.println(adminObj);
			str = "Admin not found.";

		} else {
			String pwd = adminObj.get().getPassword();
			if (!pwd.equals(user.getPassword())) {
				str = "Wrong password";

			} else {
				str = "Logged in successful as a Admin";
			}
		}
		return str;
	}

}
