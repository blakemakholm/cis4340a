// Note that this code does not run, it is simply to document the SEI Java Rule with the non-compliant
// and compliant code as shown below

// Non-compliant Solution
if (loginSuccessful) {
    logger.severe("User login succeeded for: " + username);
    } else {
    logger.severe("User login failed for: " + username);
    }

// Compliant Solution
    if (loginSuccessful) {
    logger.severe("User login succeeded for: " + sanitizeUser(username));
    } else {
    logger.severe("User login failed for: " + sanitizeUser(username));
    }

public String sanitizeUser(String username) {
    return Pattern.matches("[A-Za-z0-9_]+", username))
    ? username : "unauthorized user";
    }