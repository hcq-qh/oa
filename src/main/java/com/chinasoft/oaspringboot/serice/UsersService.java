package com.chinasoft.oaspringboot.serice;

import com.chinasoft.oaspringboot.domain.Users;
import org.springframework.stereotype.Service;

@Service
public interface UsersService {
   public Users SelectAllByName();
}
