package com.revature.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.UserDao;
import com.revature.model.User;
/**
 * @author TeamLeo
 * This class is the only class that can communicate with the UserDao class inside of the Dao layer.
 * Service layer for the User model.
 */
@Service
public class UserService {
	
	/**
	 * Initializes UserDao
	 */
	private UserDao ud;
	
	/**
	 * Automatically creates an association 
	 * to the UserDao
	 * @param ud
	 */
	@Autowired
	public void setUd(UserDao ud) {
		this.ud = ud;
	}

	/**
	 * Returns all users
	 * @return finAll()
	 */
	public List<User> readAll() {
		return ud.findAll();
	}
	
	/**
	 * Returns a user by id
	 * @param id
	 * @return findById(id)
	 */
	public User findById(int id) {
		return ud.findById(id);
	}

	/**
	 * Updates a user
	 * @param user
	 * @return update(user)
	 */
	public User update(User user) {
		return ud.update(user);
	}
	
	/**
	 * Inserts a user
	 * @param user
	 * @return insert(user)
	 */
	public User insert (User user) {
		return ud.insert(user);
	}
	
	/**
	 * Deletes a user
	 * @param user
	 */
	public void delete(User user) {
		ud.delete(user);
	}
	
	/**
	 * Returns User by name
	 * @param name
	 * @return findByName(name)
	 */
	public User findByUsername(String name) {
		return ud.findByName(name);
	}
	
	public boolean checkPassword(String username, String password, User u)
    {
        String toHash = username + password + "salt";
        String hashText = "";
        try
        {
            MessageDigest md = MessageDigest.getInstance("md5");
            
            /**
             * digest() method is called to calculate message digest 
             * of an input digest() return array of byte
             */ 
            byte[] messageDigest = md.digest(toHash.getBytes()); 
  
            /**
             * Converts byte array into signum representation. 
             */
            BigInteger no = new BigInteger(1, messageDigest); 
  
            /**
             * Converts message digest into hex value. 
             */
            hashText = no.toString(16); 
            while (hashText.length() < 32) { 
                hashText = "0" + hashText; 
            }
        } catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }

        if (u.getPassword().equals(hashText))
        {
            return true;
        }
        return false;
    }

}
