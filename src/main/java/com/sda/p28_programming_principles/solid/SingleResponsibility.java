package com.sda.p28_programming_principles.solid;

import com.sda.p26_optionals.User;

// SOLID principle
// S: Single Responsibility Principle (SRP)
// Definition: A class should have only one reason to change, meaning it should have only one job or responsibility.
public class SingleResponsibility {

    static class UserBad {
        private String name;
        private String email;

        // getters&setters
        // ...

       public boolean authenticate(String password) {
           // authentication logic...
           return true;
       }

       public void signup(User user) {
           //...
       }
    }

    static class UserGood {
        private String name;
        private String email;

        // getters&setters
        // ...
    }

    static class AuthenticationService {
        public boolean authenticate(String password) {
            // authentication logic...
            return true;
        }
    }

    static class SignupService {
        public void signup(User user) {
            //...
        }
    }


}
