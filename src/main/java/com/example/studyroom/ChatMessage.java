package com.example.studyroom;

public class ChatMessage  {

    private String type;
    private String studentName;
    private String content;
    private String roomId;

    private String mood;
    private String exam;
    private String college;
    private String city;
    private String subject;
    private String bio;
    private String lookingFor;

    public ChatMessage()  {

    }

    public String getType() {
        return type;
    }

    public void setType(String type)  {
        this.type = type;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName)  {
        this.studentName = studentName;
    }

    public String getContent()  {
        return content;
    }

    public void setContent(String content)  {
        this.content = content;
    }

    public String getRoomId()  {
        return roomId;
    }

    public void setRoomId(String roomId)    {
        this.roomId = roomId;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood)    {
        this.mood = mood;
    }

    public String getExam()    {
        return exam;
    }

    public void setExam(String exam)    {
        this.exam = exam;
    }

    public String getCollege()  {
        return college;
    }

    public void setCollege(String college)  {
        this.college = college;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city)    {
        this.city = city;
    }

    public String getSubject()  {
        return subject;
    }

    public void setSubject(String subject)  {
        this.subject = subject;
    }

    public String getBio()  {
        return bio;
    }

    public void setBio(String bio)  {
        this.bio = bio;
    }

    public String getLookingFor()   {
        return lookingFor;
    }

    public void setLookingFor(String lookingFor)    {
        this.lookingFor = lookingFor;
    }

}