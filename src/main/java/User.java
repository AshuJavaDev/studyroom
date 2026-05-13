package com.example.studyroom;

public class User   {
    private String name;
    private String role;
    private int id;
    private String subject;

    public User(String name, String role, String subject, int id)   {
        this.name = name;
        this.role = role;
        this.subject = subject;
        this.id = id;
    }

    public String getname()     {
        return name;
    }

    public String getrole()     {
        return role;
    }

    public String getsubject()  {
        return subject;
    }

    public int getid()     {
        return id;
    }

}