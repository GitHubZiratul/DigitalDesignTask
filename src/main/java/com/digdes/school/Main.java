package com.digdes.school;

public class Main {
    public static void main(String[] args) throws Exception {
        String str = "INSERT VALUES 'id'=5,'active'=false";
        JavaSchoolStarter javaSchoolStarter = new JavaSchoolStarter();
        javaSchoolStarter.execute(str);
        javaSchoolStarter.execute("INSERT VALUES 'lastNAME'='GTR'");
        javaSchoolStarter.execute("INSERT VALUES 'lastNAME'='SWQ','ACTIVE'=true");
        javaSchoolStarter.execute("insert values 'lastName' ='  Фе  доров','id'=5,'age'=40,'active'=true");

    }
}