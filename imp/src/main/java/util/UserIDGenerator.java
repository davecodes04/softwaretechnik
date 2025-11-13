package util;

import java.util.HashMap;
import java.util.Map;

public class UserIDGenerator {

    private static final Map<String, Integer> currentIds = new HashMap<>();

    static {
        // Initialize starting points for each role
        currentIds.put("EMPLOYEE", 50);
        currentIds.put("SUPERVISOR", 20);
        currentIds.put("HR", 5);
        currentIds.put("CEO", 1);
    }

    // Generate next id that isn't taken
    public static synchronized int getNextId(String role) {
        role = role.toUpperCase();
        int nextId = currentIds.getOrDefault(role, 1000); // fallback for unknown roles
        currentIds.put(role, nextId + 1);
        return nextId;
    }
}