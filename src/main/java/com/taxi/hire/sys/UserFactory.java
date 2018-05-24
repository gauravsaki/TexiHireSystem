package com.taxi.hire.sys;

public class UserFactory {
    public static User getUserInstance(String roleName) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        User user = null;
        for (UserRole userRole : UserRole.values()) {
            if (userRole.toString().equals(roleName)) {
                try {
                    Class c = Class.forName("com.taxi.hire.sys."+roleName);
                    user = (User) c.newInstance();
                    return user;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    throw new ClassNotFoundException("Role is not exist :");

                }

            }
        }
        return user;
        // throw an IllegalArgumentException or return null

    }
}
