package Repository;

import Entity.User;
/**
 * Repository required to encapsulate the logic required to access the data sources for user.
 * 
 */
public class UserRepository extends Repository<User> {

    public UserRepository(String fileName) {
        super(fileName);
    }
    
}
