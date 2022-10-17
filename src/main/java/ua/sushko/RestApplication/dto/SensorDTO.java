package ua.sushko.RestApplication.dto;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class SensorDTO {
    @NotEmpty(message = "Назва не може бути пустою!")
    @Size(min = 2, max = 30, message = "Назва сенсору повинна містити від 2 до 30 символів")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
