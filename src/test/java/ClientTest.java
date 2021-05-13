import cn.hutool.http.HttpRequest;
import cn.hutool.http.Method;
import com.ridkorfid.notify.client.Client;
import com.ridkorfid.notify.client.ClientBuilder;
import com.ridkorfid.notify.client.config.Configuration;
import com.ridkorfid.notify.client.utils.Notify;
import com.ridkorfid.notify.client.utils.SleepUtil;
import org.junit.Test;

import java.net.InetSocketAddress;
import java.net.Proxy;

/**
 * @author qiu
 * @date 2021/5/7
 */
public class ClientTest {

    public static void main(String[] args) {
//        Notify.push("test message");
        Notify.push(new RuntimeException("hahahahah"));
        SleepUtil.sleep(40);
    }


//    @Test
    public void func1() {
//        Notify.push("test message");
//        Notify.push(new RuntimeException("hahahahah"));

        Notify.logInfo("kasdfhkjadfhkjshf");
        Notify.logDebug("kasdfhkjadfhkjshf");
        Notify.logError("kasdfhkjadfhkjshf");
        SleepUtil.sleep(100);
    }


//    @Test
    public void func() {

        HttpRequest httpRequest = new HttpRequest("http://127.0.0.1:8080//notice/post");
        httpRequest.setMethod(Method.POST);
        // test 本地代理
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 8888));
        String result = httpRequest.setProxy(proxy).execute().body();

        System.out.println(result);
    }

    @Test
    public void setEndPoint() {

        Configuration configuration = new Configuration();
        configuration.setEndPoint("http://127.0.0.1:7099/notice/post");

        Client build = ClientBuilder.build(configuration);
        Notify.setClient(build);
        Notify.logInfo("kasdfhkjadfhkjshf");
        Notify.logDebug("kasdfhkjadfhkjshf");
        Notify.logError("kasdfhkjadfhkjshf");

        SleepUtil.sleep(10);
    }
}
