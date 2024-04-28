package com.egor.mel8.Json;

public class Stats {

    private String name;
    private Integer age;
    private Boolean cute;
    private String[] salaries;

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Boolean getCute() {
        return cute;
    }

    public String[] getSalaries() {
        return salaries;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setCute(Boolean cute) {
        this.cute = cute;
    }

    public void setSalaries(String[] salaries) {
        this.salaries = salaries;
    }
}
