package kz.runtime.stat_service.spring63catalog.config;

import jakarta.persistence.EntityNotFoundException;
import kz.runtime.stat_service.spring63catalog.model.User;
import kz.runtime.stat_service.spring63catalog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Username: " + username);
        User user = userRepository
                .findByLogin(username)
                .orElseThrow(() -> new EntityNotFoundException("Пользователь с login=" + username + " не найден!"));

        return new UserDetailsImpl(user);
    }
}
