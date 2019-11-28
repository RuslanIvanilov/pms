package ru.s7;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.s7.staff.AppPropertySaver;
import ru.s7.staff.User;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@RequestMapping("")
@Controller
public class MainController{

    public static final String PROPERTIES =  "app.properties";
    Properties properties;
    User user;

    private Properties getProperty(){
        if(properties == null) {
            InputStream input = getClass().getClassLoader().getResourceAsStream("app.properties");
            properties = new Properties();
            try {
                properties.load(input);
            } catch (IOException | NullPointerException e) {
                e.printStackTrace();
            }
        }
        return properties;
    }

    @RequestMapping(method = RequestMethod.GET, value={"/","main"})
    public String initMain(ModelMap model) throws UnsupportedEncodingException {
        Properties properties = getProperty();
        String appName =  properties.getProperty("app-name") ;

        if (user != null && !user.getUserName().isEmpty()) {
            model.addAttribute("message", appName + " / " + properties.getProperty("main-frame-title"));
            model.addAttribute("main_frame_title", appName + " " + properties.getProperty("main-frame-title"));
            model.addAttribute("setup_admin_caption", properties.getProperty("settings-frame-name"));
            model.addAttribute("templates_path", properties.getProperty("main-frame-template-path"));
            model.addAttribute("templates_path_caption", properties.getProperty("main-frame-template-caption"));
            model.addAttribute("reports_path", properties.getProperty("main-frame-reports-path"));
            model.addAttribute("reports_path_caption", properties.getProperty("main-frame-reports-caption"));
            model.addAttribute("template_list", getListOfFiles(properties, properties.getProperty("main-frame-template-path")));
            model.addAttribute("report_list", getListOfFiles(properties, properties.getProperty("main-frame-reports-path")));

            return "main";
        } else {
            model.addAttribute("app_name", properties.getProperty("app-name"));
            model.addAttribute("auth_frame_caption", properties.getProperty("auth-frame-caption"));
            return "auth";
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/setup" )
    public void initSetup(ModelMap model){
        Properties properties = getProperty();
        String settingFrameName = properties.getProperty("settings-frame-name");
        model.addAttribute("settings_name" , settingFrameName);
        model.addAttribute("settings_frame_title" , properties.getProperty("app-name") + " " + settingFrameName );
        model.addAttribute("save_button", properties.getProperty("setup-save-button"));
        model.addAttribute("back_button", properties.getProperty("setup-back-button"));
        model.addAttribute("main_frame_template_path", "Template files path:" );
        model.addAttribute("main_frame_template_path_value", properties.getProperty("main-frame-template-path") );
        model.addAttribute("main_frame_reports_path", "Report files path:" );
        model.addAttribute("main_frame_reports_path_value", properties.getProperty("main-frame-reports-path") );
        model.addAttribute("main_frame_use_local_path", "Use home path from application" );
        model.addAttribute("main_frame_use_local_path_value", properties.getProperty("main-frame-use-local-path") );

    }

    @RequestMapping(method = RequestMethod.POST, value = "/auth" )
    public String auth(@RequestParam("login") String login, @RequestParam("pass") String pass,ModelMap model) throws UnsupportedEncodingException {
        System.out.println("AUTH is submitted! LOGIN: " + login + " PASS hashCode : " + pass.hashCode() );

        if(user == null ){ user = new User(); }
        user.setUserName(login);
        user.setPassHash( Long.valueOf(pass.hashCode()) );

        return initMain(model);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/setup_save", produces = "text/plain;charset=UTF-8" )
    public String saveSetup(@RequestParam("template_path") String template_path, @RequestParam("reports_path") String reports_path, ModelMap model) throws UnsupportedEncodingException {
        Properties properties = getProperty();
        properties.setProperty("main-frame-template-path", template_path);
        properties.setProperty("main-frame-reports-path", reports_path);
        String path = this.getClass().getClassLoader().getResource("app.properties").getPath();
        AppPropertySaver.save(properties, path);
       return initMain(model);
    }

    public List<String> getListOfFiles(Properties properties, String directoryPath){
        String path = getPathByProperty(PROPERTIES);
        if(properties.getProperty("main-frame-use-local-path").contains("false")) path = "";
        File folder = new File(path+directoryPath);
        File[] files = folder.listFiles();

        List<String> list = new ArrayList<String>();

        if(files != null) {
            for (File file : files) {
                if (!file.getName().contains(".DS_Store"))
                    list.add(file.getName());
            }
        }
        return list;
    }

    public String getPathByProperty(String properties) {
        URL resource = getClass().getClassLoader().getResource(properties);
        String path = resource.getPath();
        Path folderPath = Paths.get(path);
        String directory = folderPath.getParent().toString();
        return directory;
    }


}
