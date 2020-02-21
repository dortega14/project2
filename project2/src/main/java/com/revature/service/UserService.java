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
 * 
 * @author TeamLeo
 * <br>
 * <br>
 * This class is the only class that can communicate with the UserDao class inside of the Dao layer.
 * 
 *
 */
@Service
public class UserService {
	
	private UserDao ud;
	
	@Autowired
	public void setUd(UserDao ud) {
		this.ud = ud;
	}

	public List<User> readAll() {
		return ud.findAll();
	}
	
	public User findById(int id) {
		return ud.findById(id);
	}

	public User update(User user) {
		return ud.update(user);
	}

	public User insert (User user) {
		return ud.insert(user);
	}
	
	public void delete(User user) {
		ud.delete(user);
	}
	
	public User findByUsername(String name) {
		return ud.findByName(name);
	}
	
	public User findUserByEmail(String email) {
		return ud.findByEmail(email);
	}
	
	public boolean checkPassword(String username, String password, User u)
    {
        String toHash = username + password + "salt";
        String hashText = "";
        try
        {
            MessageDigest md = MessageDigest.getInstance("md5");
            
            // digest() method is called to calculate message digest 
            //  of an input digest() return array of byte 
            byte[] messageDigest = md.digest(toHash.getBytes()); 
  
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest); 
  
            // Convert message digest into hex value 
            hashText = no.toString(16); 
            while (hashText.length() < 32) { 
                hashText = "0" + hashText; 
            }
        } catch (NoSuchAlgorithmException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (u.getPassword().equals(hashText))
        {
            return true;
        }
        return false;
    }

}
