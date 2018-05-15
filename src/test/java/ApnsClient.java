import com.huskyv.core.error.ErrorDispatcher;
import com.huskyv.core.error.ErrorListener;
import com.huskyv.core.error.ErrorModel;
import com.huskyv.core.manager.ApnsServiceManager;
import com.huskyv.core.model.Alert;
import com.huskyv.core.model.ApnsConfig;
import com.huskyv.core.model.Payload;
import com.huskyv.core.model.PushNotification;
import com.huskyv.core.service.ApnsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.HashMap;

public class ApnsClient {

    private static final Logger log = LoggerFactory.getLogger(ApnsClient.class);

    private static final String TOKEN = "081ee7fad05acd1d24e285bcb74a0e17e3a063d2a026300bc940306de07f8b49".trim();

    public static void main(String[] args) {
        // 读取证书
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("zz.p12");
        ApnsConfig config = new ApnsConfig();
        config.setName("name1");// 推送服务名称
        config.setDevEnv(true);// 是否是开发环境
        config.setKeyStore(is);// 证书
        config.setPassword("7");// 证书密码
        config.setPoolSize(1);// 线程池大小
        config.setTimeout(3000);// TCP连接超时时间
        config.setTopic("wxl.ZLDemo");// 标题,即证书的bundleID
        ApnsServiceManager.createService(config);


        ErrorDispatcher.getInstance().addListener(new ErrorListener() {
            @Override
            public void handle(ErrorModel errorModel) {
                log.info("收到错误监听:" + errorModel);

            }
        });

        sendNotification(config.getName(), TOKEN);

    }

    public static void sendNotification(String appName, String token) {

        Payload payload = new Payload();
        Alert alert = new Alert();
        alert.setTitle("这是标题");
        alert.setBody("这是内容");
        alert.setSubtitle("这是简介");
        payload.setAlert(alert);
//        payload.addParam("media", new HashMap<String, String>() {{
//            put("type", "video");
//            put("url", "http://olxnvuztq.bkt.clouddn.com/WeChatSight1.mp4");
//        }});

        payload.addParam("media", new HashMap<String, String>() {{
            put("type", "image");
//            put("url", "http://h.hiphotos.baidu.com/image/pic/item/a5c27d1ed21b0ef48c509cecd1c451da80cb3ec3.jpg");
            put("url", "http://wx3.sinaimg.cn/mw690/00728KIDgy1fpj0qxannqg30bn05wnpe.gif");
        }});

//        payload.addParam("media", new HashMap<String, String>() {{
//            put("type", "autio");
//            put("url", "http://ting666.yymp3.com:86/new27/mljyyj/1.mp3");
//        }});
        payload.setMutablecontent(1);
        payload.setCategory("realtime");
        payload.setBadge(1);
        payload.setSound("default");

        PushNotification notification = new PushNotification();
        notification.setPayload(payload);
        notification.setToken(token);
        ApnsService service = ApnsServiceManager.getService(appName);
        service.sendNotification(notification);// 异步发送
//        boolean result = service.sendNotificationSynch(notification);// 同步发送
    }

}
