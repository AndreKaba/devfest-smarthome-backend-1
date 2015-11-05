package cz.gug.webapi.util;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by jacktech24 on 19.10.15.
 */
public class Net {

    public static <T> Response<T> fetchUrl(String urlString, Class<? extends T> type) {
        try {
            URL url = new URL(urlString);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            StringBuilder builder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            reader.close();

            Gson gson = new Gson();
            T content = gson.fromJson(builder.toString(), type);
            return Response.create(true, content);
        } catch (IOException e) {
            return Response.create(false, null);
        } catch (JsonSyntaxException e) {
            return Response.create(false, null);
        }
    }

    public static String toUrlQuery(String... params) {
        StringBuilder builder = new StringBuilder();
        for(int i = 0;i < params.length;i += 2) {
            builder.append("&").append(params[i]).append("=").append(params[i+1]);
        }
        return builder.toString();
    }

    public static class Response<T> {

        private T mContent;
        private boolean mSuccess;

        private Response(boolean success, T content) {
            this.mContent = content;
            this.mSuccess = success;
        }

        public T getContent() {
            return mContent;
        }

        public boolean isSuccess() {
            return mSuccess;
        }

        public static <T> Response<T> create(boolean success, T content) {
            return new Response<>(success, content);
        }

    }

}
