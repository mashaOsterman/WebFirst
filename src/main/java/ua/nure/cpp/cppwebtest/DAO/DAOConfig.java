package ua.nure.cpp.cppwebtest.DAO;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "database")
public class DAOConfig {
    private String type = "MySQL";
    private String url = "jdbc:mysql://localhost:3306/course_work";
    private String user= "root";
    private String password = "11017811";


    public DAOConfig() {
    }

    public DAOConfig(String type) {
        this.type = type;
    }

    public DAOConfig(String type, String url, String user, String password) {
        this.type = type;
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "DAOConfig{" +
                "type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
