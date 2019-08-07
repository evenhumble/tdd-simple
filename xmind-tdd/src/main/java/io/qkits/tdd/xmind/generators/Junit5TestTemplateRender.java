package io.qkits.tdd.xmind.generators;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;

/**
 * @author Junit5TestTemplateGenerator
 * @date created on 2019-05-05 #: EPIC ##: Feature ###: detail
 **/
public class Junit5TestTemplateRender {

  public static void generateJunit5TC(String mdFile, String fileName) throws IOException {
    AllureTestModel allureTestModel = new AllureTestModel();
    List<String> mdContent = Resources.readLines(Resources.getResource(mdFile), Charsets.UTF_8);

    String currentFeature = "";
    for (String line : mdContent) {
      if (line.startsWith("###")) {
        AllureFeature feature = new AllureFeature();
        feature.setDesc(currentFeature + "-" + line.replace("###", "").trim());
        feature.setName(line.replace("###", "").trim().replace(" ", "_"));
        allureTestModel.features.get(currentFeature).add(feature);
      } else if (line.startsWith("##")) {
        currentFeature = line.replace("##", "").trim();
        allureTestModel.features.putIfAbsent(currentFeature, new ArrayList<>());
        //todo: handle no use case issue

      } else if (line.startsWith("#")) {
        allureTestModel.setEpic(line.replace("#", "").trim());
      }
    }

    JtwigTemplate template = JtwigTemplate.classpathTemplate("junit_allure_template.twig");
    JtwigModel model = JtwigModel.newModel().with("context", allureTestModel);
    template.render(model, new FileOutputStream(new File(fileName + ".java")));
  }

  /**
   * main entry point of generator
   */
  public static void main(String[] args) throws IOException {
    Junit5TestTemplateRender.generateJunit5TC("Java_BeanUtil.md", "HutoolUtilTest.java");

  }

  @Data
  public static class AllureTestModel {

    private String epic;
    private Map<String, List<AllureFeature>> features = new HashMap<>();
  }

  @Data
  public static class AllureFeature {

    private String name;
    private String desc;
  }
}
