package com.ioomex;


import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@Slf4j
public class IoomexAplication {
  public static void main(String[] args) throws UnknownHostException {
    ConfigurableApplicationContext runApp = SpringApplication.run(IoomexAplication.class, args);
    run(runApp);
  }

  private  static void run(ConfigurableApplicationContext run) throws UnknownHostException {
    System.out.println("-----------------------------------");
    Environment env = run.getEnvironment();
    String ip = InetAddress.getLocalHost().getHostAddress();
    String port = env.getProperty("server.port");
    String path = env.getProperty("server.servlet.context-path");
    path = StrUtil.isNotEmpty(path) ? path : "";
    log.info("\n----------------------------------------------------------\n\t"
      + "Application  is running! Access URLs:\n\t" + "Local: \t\thttp://localhost:" + port + path
      + "\n\t" + "External: \thttp://" + ip + ":" + port + path + "\n\t" + "swagger-ui: \thttp://" + ip
      + ":" + port + path + "swagger-ui.html\n\t" + "Doc: \t\thttp://" + ip + ":" + port + path
      + "doc.html\n" + "----------------------------------------------------------");
    log.info("启动成功 V0.0.1{}", System.currentTimeMillis());
  }
}