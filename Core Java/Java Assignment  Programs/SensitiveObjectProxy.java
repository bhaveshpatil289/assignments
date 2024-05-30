package com.wipro.Assignments;

class SensitiveObjectProxy {
    private SensitiveObject sensitiveObject;
    private String correctPassword;


    public SensitiveObjectProxy(String secretKey, String correctPassword) {
        this.sensitiveObject = new SensitiveObject(secretKey);
        this.correctPassword = correctPassword;
    }


    public String getSecretKey(String password) {
        if (authenticate(password)) {
            return sensitiveObject.getSecretKey();
        } else {
            throw new SecurityException("Invalid password. Access denied.");
        }
    }


    private boolean authenticate(String password) {
        return correctPassword.equals(password);
    }
}

