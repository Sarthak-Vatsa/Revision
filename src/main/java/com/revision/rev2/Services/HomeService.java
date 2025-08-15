package com.revision.rev2.Services;

import com.revision.rev2.Dao.UserRepo;
import com.revision.rev2.Models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeService
{
    @Autowired
    private UserRepo userRepo;

    public void registerUser(Users user)
    {
        userRepo.save(user);
    }
}
