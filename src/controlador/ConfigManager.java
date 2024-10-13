/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;


import java.io.*;
import java.util.Properties;

public class ConfigManager {
    private Properties properties = new Properties();
    private final String configFilePath = "config.properties";

    public ConfigManager() {
        loadConfig();
    }

public void loadConfig() {
    File configFile = new File(configFilePath);
    if (!configFile.exists()) {
        // Si el archivo no existe, crea uno con valores predeterminados
        try (OutputStream output = new FileOutputStream(configFilePath)) {
            properties.setProperty("theme", "light"); // Valor predeterminado
            properties.store(output, null);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Luego, intenta cargar el archivo
    try (InputStream input = new FileInputStream(configFilePath)) {
        properties.load(input);
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}


    public void saveConfig() {
        try (OutputStream output = new FileOutputStream(configFilePath)) {
            properties.store(output, null);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getTheme() {
        return properties.getProperty("theme", "light");
    }

    public void setTheme(String theme) {
        properties.setProperty("theme", theme);
        saveConfig();
    }
}
