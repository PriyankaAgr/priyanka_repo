/*
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.URI;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpRequest;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;


class Result {

    */
/*
     * Complete the 'evaluate' function below.
     *
     * The function is expected to return output as STRING_ARRAY.
     * The function accepts STRING api as parameter.
     *//*


    public static List<String> evaluate(String api) {
        // Write your code here
        String json = getJsonString(api);

        return parseJson(json);
        // return res;
    }

    public static String getJsonString(String apiUrl){
        String jsonString = null;
        try {
            // Create an HTTP GET request
            HttpGet request = new HttpGet(apiUrl);
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                jsonString = EntityUtils.toString(entity);
                // Execute the request
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

    public static List<String> parseJson(String jsonString){
        List<String> output = new ArrayList<>();
        // Parse the JSON response using Gson
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Groups>>() {}.getType();

        // List<Groups> jsonObject = gson.fromJson(jsonString, Groups.class);
        //  JsonArray jsonArray = gson.fromJson(jsonString).getAsJsonArray();
        List<Groups> groupList = gson.fromJson(jsonString, listType);

        Map<String, String> hm = new HashMap<>();
        for(Groups group : groupList){
            StringBuilder sb = new StringBuilder();
            sb.append(group.getGroupName()+":");
            for(Expression expression : group.getExpressions()){
                if(expression.getExpressionType().equals("DIRECT")){
                    sb.append(expression.getName()).append(":").append(expression.getExpression());
                    hm.put(expression.getName(), expression.getExpression());
                }
                else if(expression.getExpressionType().equals("RS_EXPRESSION")){
                    List<String> dep = expression.getDependencies();
                    //String exp = null;
                    for(String d : dep){
                        //String[] tmp = expression.getExpression().split("}");
                        String exp = expression.getExpression();
                        int idx=exp.indexOf("}");
                        exp = exp.substring(idx+1);
                        String newExp = "("+hm.get(d)+exp+")"+" RS";

                        sb.append(expression.getName()).append(":").append(newExp);

                    }
                }
                else if(expression.getExpressionType().equals("DOLLAR_EXPRESSION")){
                    List<String> dep = expression.getDependencies();
                    for(String d : dep){
                        String exp = expression.getExpression();
                        int idx=exp.indexOf("}");
                        exp = exp.substring(idx+1);
                        // String[] tmp = expression.getExpression().trim().split("}");
                        String newExp = "("+hm.get(d)+exp+")"+" $";

                        sb.append(expression.getName()).append(":").append(newExp);

                    }
                }
                sb.append(":");



            }
            String res = group.getExpressions().isEmpty()?sb.toString() : sb.deleteCharAt(sb.length()-1).toString();
            //sb.append(":");
            output.add(res);
            System.out.println(res);
        }
        return output;

    }


}
class Groups{
    String groupName;
    List<Expression> expressions;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Expression> getExpressions() {
        return expressions;
    }

    public void setExpressions(List<Expression> expressions) {
        this.expressions = expressions;
    }
    public void addExpression(Expression expression) {
        this.expressions.add(expression);
    }
}

class Expression{
    String name;
    String expressionType;
    String expression;
    List<String> dependencies;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpressionType() {
        return expressionType;
    }

    public void setExpressionType(String expressionType) {
        this.expressionType = expressionType;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public List<String> getDependencies() {
        return dependencies;
    }

    public void setDependencies(List<String> dependencies) {
        this.dependencies = dependencies;
    }
}




public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String api = bufferedReader.readLine();

        List<String> result = Result.evaluate(api);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
*/
