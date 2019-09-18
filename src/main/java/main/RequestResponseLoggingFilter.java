package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;


@Component
public class RequestResponseLoggingFilter implements Filter {
    @Autowired
    private ConfigMap configMap;

    private static String getApiFromClientRequest(String url) {
        String[] split = url.split("/");
        return split[split.length - 1];
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String requestURI = req.getRequestURI();
        System.out.println("Logging Request" + req.getMethod() + requestURI);
        String clientId = parseHeaderAndGetClientMapping(req);
        Map<String, String> clientConfiguration = configMap.getClientConfiguration(clientId);
        String urlToHit = getUrlToHit(requestURI, clientConfiguration.get(getApiFromClientRequest(requestURI)));
        RequestDispatcher reqDisObj = req.getServletContext().getRequestDispatcher("/" + urlToHit);
        reqDisObj.forward(req, res);
    }

    private String getUrlToHit(String reqURL, String versionUrl) {
        return reqURL + "/" + versionUrl.replace(".", "/");
    }

    private String parseHeaderAndGetClientMapping(HttpServletRequest req) {
        return configMap.getHeaderFiledToRead() != null ? req.getHeader(configMap.getHeaderFiledToRead()) : "clientId";
    }
}