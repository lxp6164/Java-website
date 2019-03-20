package com.lxp.LittleMusic.services;

import com.lxp.LittleMusic.controllers.UserMessageController;
import com.lxp.LittleMusic.controllers.UserPlayerListControllor;
import com.lxp.LittleMusic.models.UserMessage;
//import com.lxp.LittleMusic.models.UserPlayerList;
//import com.lxp.LittleMusic.models.UserPlayerListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

@Component
public class UploadFileService {
   // @Autowired
    //private UserPlayerListControllor userPlayerListControllor;
    @Autowired
    private UserMessageController userMessageController;

    //上传文件
    public void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }

    //音乐数是否超过10
    public boolean isMusicListFull(String userName){
        List<UserMessage> ul = userMessageController.findUser(userName);
        if(ul.get(0).getMusicCount()>=10)return true;
        else return false;

    }

}
