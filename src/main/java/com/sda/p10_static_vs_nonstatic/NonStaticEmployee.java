package com.sda.p10_static_vs_nonstatic;

public class NonStaticEmployee {
    private int id;
    private String name;
    private String company;

    public NonStaticEmployee(int id, String name, String company) {
        this.id = id;
        this.name = name;
        this.company = company;
    }

    public void display() {
        System.out.println("StaticEmployee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                '}');
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getCompany() {
        return company;
    }
}
