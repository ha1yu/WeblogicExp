package com.example.weblogicexp;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;

public class HelloController {

    @FXML
    private TextField urlInputForCheck;

    @FXML
    private TextField jndiInputForCheck;

    @FXML
    private TextField rmiInputForCheck;

    @FXML
    private TextField jrmpInputForCheck;
    @FXML
    private TextField dnsLogInputForCheck;
    @FXML
    private ComboBox<String> vulsNameOfAll;

    @FXML
    private TextArea baseInfoOutPut;


    /*
    *   初始化 各个模块的按钮以及默认值
    */
    @FXML
    void initialize() throws Exception {
        this.initVulsChoise();  // 首页默认的漏洞编号
    }

    private void initVulsChoise(){
        //有问题，没办法添加到选择框框中
        List<String> list= new ArrayList<>();
        list.add("cve-2022-1212");
        list.add("cve-2015-1234");
        list.add("ALL_ECHO");
        vulsNameOfAll.setItems(FXCollections.observableArrayList(list));
    }

    @FXML
    private void StartCheckAllVuls(){
        // 获取URL vuls编号 JNDI RMI JRPM DNSlog， URL不可为空，其他可为空。
        String targetUrl = urlInputForCheck.getText().strip();
        String jndiUrl = jndiInputForCheck.getText().strip();
        String rmiUrl = rmiInputForCheck.getText().strip();
        String jrmpUrl = jrmpInputForCheck.getText().strip();
        String dnsLogURL = dnsLogInputForCheck.getText().strip();
        String vulNameCheck = vulsNameOfAll.getValue();

        baseInfoOutPut.setText("[*] 解析单个URL检测时,设置的所有参数:\n");
        baseInfoOutPut.appendText("目标: " + targetUrl + "\n");
        baseInfoOutPut.appendText("JNDI: " + jndiUrl + "\n");
        baseInfoOutPut.appendText("RMI: " + rmiUrl + "\n");
        baseInfoOutPut.appendText("JRMP: " + jrmpUrl + "\n");
        baseInfoOutPut.appendText("DNSLog: " + dnsLogURL + "\n");
        List<String> checkVulsName = new ArrayList<>();
        if(vulNameCheck.contains("ALL_ECHO")){
            checkVulsName.add();
        }

        baseInfoOutPut.appendText("VULName: " + vulNameCheck + "\n");
        baseInfoOutPut.appendText("[*] 参数解析完成，开始检测漏洞...");

    }
}
