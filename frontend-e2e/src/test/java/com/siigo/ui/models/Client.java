package com.siigo.ui.models;

public class Client {
    private String name;
    private String email;
    private String phone;
    private String address;
    private String id;

    public Client() {
        // Default constructor
    }

    public Client(String name, String email, String phone, String address, String id) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.id = id;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    // Builder pattern for easy client creation
    public static class Builder {
        private String name;
        private String email;
        private String phone;
        private String address;
        private String id;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Client build() {
            return new Client(name, email, phone, address, id);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
} 