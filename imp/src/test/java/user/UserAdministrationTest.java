package user;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserAdministrationTest {

    // Has to run before each test so it can clear the user list, since UserAdministration is static //////
    @BeforeEach
    void setUp() {
        UserAdministration.clear();
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////

    // Test adding a user, and then searching for them by id //////////////////////////////////////////////
    @Test
    void testAddUserSuccessfully() {
        User u = new Employee();
        u.setEmail("joe@example.com");
        UserAdministration.addUser(u);

        assertEquals(1, UserAdministration.getAllUsers().size());
        assertEquals(u, UserAdministration.findById(50));
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////

    // Making sure that two users who have the same id don't exist at the same time ///////////////////////
    @Test
    void testAddUserDuplicateIdNotAdded() {
        User u1 = new Employee();
        u1.setId(1);
        u1.setEmail("john@example.com");
        User u2 = new Employee();
        u2.setId(1);
        u2.setEmail("susan@example.com");

        UserAdministration.addUser(u1);
        UserAdministration.addUser(u2);

        assertEquals(1, UserAdministration.getAllUsers().size());
        assertEquals("john@example.com", UserAdministration.findById(1).getEmail());
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////

    // Searching for an existing user by their id /////////////////////////////////////////////////////////
    @Test
    void testFindByIdUserExists() {
        User u = new Employee();
        UserAdministration.addUser(u);

        assertEquals(u, UserAdministration.findById(50));
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////

    // Searching for users which do not exist by id and email /////////////////////////////////////////////
    @Test
    void testFindByIdUserNotFound() {
        assertNull(UserAdministration.findById(50));
    }

    @Test
    void testFindByEmailNotFound() {
        assertNull(UserAdministration.findByEmail("doesnotexist@mail.com"));
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////


}
