package com.sda.p26_optionals;

import java.util.Optional;

public class Main {
    public static void main1(String[] args) {
        // Why Optionals?
        User vipUser = new User();
        //System.out.println(vipUser.getAddress()); // null
        //System.out.println(vipUser.getAddress().getCountry()); // throw NPE (null pointer exception)

        // to avoid NPE without Optionals we have to rewrite our code like this to do null check at every stage:
        if (vipUser != null) {
            Address address = vipUser.getAddress();
            if (address != null) {
                System.out.println(address.getCountry());
            }
        }

        // but the same logic with the use of Optionals
        Country country = Optional.ofNullable(vipUser)    // Optional<User>
                .map(user -> user.getAddress())  // Optional<Address>
                .map(address -> address.getCountry())  // Optional<Country>
                .orElse(null);  // = get() if non-empty, otherwise return 'null'
        System.out.println(country); // null


        Integer number = 5;
        // If number contains a value, anotherNumber will get the same value
        Optional<Integer> anotherNumber = Optional.ofNullable(number);

        // otherwise, if number is null, another number will become EMPTY (NOT null this time because of using
        // ofNullable method)
        System.out.println(anotherNumber); // Optional[5]

        // anotherNumber = Optional.ofNullable(null);
        // System.out.println(anotherNumber); // Optional.empty


        // second way of creating optionals
        // using of() method you have to make sure that its argument is a non-null object
        // Optional<Integer> someNumber = Optional.of(null); // throws NPE because it contains null

        // we can check if  anotherNumber contains a value or not using isPresent()
        if (anotherNumber.isPresent()) {
            System.out.println(anotherNumber.get()); // get() unwraps the value inside an optional
        } else {
            System.out.println("anotherNumber is empty");
        }

        // How to create an empty optional using empty() method
        User user = new User();
        Optional<User> emptyUser = Optional.empty();
        // emptyUser.get(); // throws NoSuchElementException: No value present

        // What's the difference between Optional.of() and Optional.ofNullable()
        User anotherUser = null;
        // Optional<User> opt = Optional.of(anotherUser); // if anotherUser is null, we get NPE
        Optional<User> opt = Optional.ofNullable(anotherUser); // if anotherUser is null, we get Optional.empty object, no NPE is thrown


        // How to return default value using Optionals
        User someUser = null;
        User myUser = Optional.ofNullable(someUser).orElse(new User()); // if someUser is null, return a new user by default
        System.out.println(myUser); // User[address=null]


        // How to transform(map) Optional values
        Country estonia = new Country();
        estonia.setIsoCode("EE");

        Address tallinn = new Address();
        tallinn.setCountry(estonia);

        User eeUser = new User();
        eeUser.setAddress(tallinn);

        Optional<User> eeUserOpt = Optional.ofNullable(eeUser);

        // let's transform Optional<User> to Optional<Address>
        Optional<Address> addressOpt = eeUserOpt.map(u -> u.getAddress());
        Address address = addressOpt.get();

    }


    public static void main(String[] args) {

        Player player = new Player("John", "john@gmail.com");

        // let's create an optional out of it
        Optional<Player> optionalPlayer = Optional.ofNullable(player);

        // unwrap an object inside an optional using get
        Player extractedPlayer = optionalPlayer.get();

        // check if an optional contains a value or not
        System.out.println(optionalPlayer.isPresent()); // true

        // execute a custom logic (printing email) if an optional contains a value
//        if(optionalPlayer.isPresent()) {
//            System.out.println(optionalPlayer.get().getEmail());
//        }
        optionalPlayer.ifPresent(p -> System.out.println(p.getEmail()));

        // return a default value
        Player defaultPlayer = optionalPlayer.orElse(new Player("default", "default@gmail.com"));

        // transform values using map()
        String email = optionalPlayer    // Optional<Player>
                .map(p -> p.getEmail())  // Optional<String>
                .get(); // String

        // transform values using flatMap()
        // flatMap() is a 2 step process: map() + flat()
        Member member = new Member("John", Optional.of("john@gmail.com"));
        Optional<Member> memberOpt = Optional.of(member);

        String emailAddress = memberOpt   // Optional<Member>
                //.map(m -> m.getEmail())   // Optional<Optional<String>>
                .flatMap(m -> m.getEmail()) // Optional<String>
                .orElse("Email Not Found"); // String

        System.out.println(emailAddress); // john@gmail.com


        // Filtering values using filter()
        Optional<Player> filteredPlayer = optionalPlayer  // Optional<Player>
                .filter(p -> p.getEmail().contains("gmail")); // Optional<Player>
        // using filter, if the optionalPlayer passes the filter( meaning its email contains "gmail")
        // it will be returned inside filteredPlayer
        // otherwise, if the optionalPlayer doesn't pass the filter, empty will be returned inside filteredPlayer
        System.out.println(filteredPlayer.isPresent()); // true
    }
}

/*
 * Please read more about Optionals here: https://stackify.com/optional-java/
 */
