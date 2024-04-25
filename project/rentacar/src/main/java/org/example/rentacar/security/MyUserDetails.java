package org.example.rentacar.security;

import lombok.AllArgsConstructor;
import org.example.rentacar.model.Customer;
import org.example.rentacar.model.InventoryCoordinator;
import org.example.rentacar.model.RentalAgent;
import org.example.rentacar.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;


    public class MyUserDetails implements UserDetails {
        private final User user;
        public MyUserDetails(User user){
            this.user=user;
        }
        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            if(user instanceof Customer)
                authorities.add(new SimpleGrantedAuthority("CUSTOMER"));
            else if(user instanceof InventoryCoordinator){
                authorities.add(new SimpleGrantedAuthority("INVENTORY_COORDINATOR"));
            }else if (user instanceof RentalAgent){
                authorities.add(new SimpleGrantedAuthority("RENTAL_AGENT"));
            }
            return authorities;
        }

        @Override
        public String getPassword() {
            return user.getPassword();
        }

        @Override
        public String getUsername() {
            return user.getEmailAddress();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }
