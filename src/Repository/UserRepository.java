package Repository;

import Entity.User;

public class UserRepository extends Repository<User>{
	public UserRepository(String fileName) {
        super(fileName);
	}
}