package top.dcode.doj.dao.user;

import com.baomidou.mybatisplus.extension.service.IService;
import top.dcode.doj.pojo.entity.user.Session;

public interface SessionEntityService extends IService<Session> {

    public void checkRemoteLogin(String uid);

}
