package ABB;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.LinkedHashMap;
import java.util.List;

public class Api {
    private int statuscode;
    String books;
    public void sendGetRequest() {
        Response resp= RestAssured.get("https://demoqa.com/BookStore/v1/Books");
        statuscode=resp.getStatusCode();
        books=resp.getBody().asString();
    }
    public boolean verifyStatusCode(int expectedStatusCode){
        if(expectedStatusCode==statuscode){
            return true;
        }else{
            return false;
        }
    }
  public boolean getTitleandAuthor(){
        boolean titleandauthor=false;
      JsonPath jsonPath = new JsonPath(books);
      List<LinkedHashMap<String, Object>> bookslist = jsonPath.getList("books");
      if(!bookslist.isEmpty()){
      for (LinkedHashMap<String, Object> book : bookslist) {
          if(!book.get("title").toString().isEmpty()&&!book.get("author").toString().isEmpty()){
          String titles = book.get("title").toString();
          String author = book.get("author").toString();
          System.out.println("Title: " + titles);
          System.out.println("Author: " + author);
          titleandauthor= true;
      }else{
              titleandauthor= false;
          }
      }
      }else{
          titleandauthor= false;
      }
      return titleandauthor;
  }
}
