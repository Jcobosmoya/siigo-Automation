package com.siigo.api.models;

public class User {

    private String name;
    private String job;

    public User(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    // Static inner Builder class
    public static class UserBuilder {
        private String name;
        private String job;

        public UserBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder andJob(String job) {
            this.job = job;
            return this;
        }

        public User build() {
            return new User(name, job);
        }
    }

    public static UserBuilder anUser() {
        return new UserBuilder();
    }
} 