import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (req, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/results", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/results.vtl");

      MyGame testGame = new MyGame();
        String phrase = request.queryParams("phrase");
        String word = request.queryParams("word");
        String wordReplace = request.queryParams("wordReplace");

        String results = testGame.findAndReplace(phrase, word, wordReplace);

        model.put("phrase", phrase);
        model.put("word", word);
        model.put("wordReplace", wordReplace);
        model.put("results", results);

      return new ModelAndView(model, layout);
     }, new VelocityTemplateEngine());
}
}
