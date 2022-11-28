package ir.asran.common;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HttpService {
    @Autowired
    private Environment environment;

    public JSONObject sendPostRequest(String userName,String path, JSONObject jsonInput) {
//        String url = this.environment.getProperty("restful.api.address") + path;
        String url = this.environment.getProperty("ls.address") + path;

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type", "application/json");
        httpHeaders.set("User-Id", userName);
        httpHeaders.set("App-Token", this.environment.getProperty("ls.app.token"));
        httpHeaders.set("Req-Id", this.environment.getProperty("ls.post.request.id"));
        httpHeaders.set("App-Id", this.environment.getProperty("ls.app.id"));

        HttpEntity<JSONObject> httpEntity = new HttpEntity<JSONObject>(jsonInput, httpHeaders);

        RestTemplate restTemplate = new RestTemplate();
        setTimeout(restTemplate,5000000);
        return restTemplate.postForObject(url, httpEntity, JSONObject.class);
    }

    private void setTimeout(RestTemplate restTemplate, int timeout) {

        //Explicitly setting ClientHttpRequestFactory instance to
        //SimpleClientHttpRequestFactory instance to leverage
        //set*Timeout methods
        restTemplate.setRequestFactory(new SimpleClientHttpRequestFactory());
        SimpleClientHttpRequestFactory rf = (SimpleClientHttpRequestFactory) restTemplate
                .getRequestFactory();
        rf.setReadTimeout(timeout);
        rf.setConnectTimeout(timeout);
    }



}