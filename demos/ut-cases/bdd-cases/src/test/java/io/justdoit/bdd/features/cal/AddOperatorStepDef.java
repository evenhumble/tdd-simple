package io.justdoit.bdd.features.cal;

import org.junit.Assert;

import cucumber.api.java8.En;

/**
 * @author: patrick on 2018-12-08
 * @Description:
 */
public class AddOperatorStepDef implements En {
  double origin,hanleData;
  Double actResult;
  public AddOperatorStepDef() {
    AddOperator operator = new AddOperator();

    Given("^two numbers (\\d+) and (\\d+)$", (Integer arg0, Integer arg1) -> {
      origin =arg0;
      hanleData=arg1;
    });
    When("add these two numbers", () -> {
      // Write code here that turns the phrase above into concrete actions
      this.actResult = operator.calculate(origin,hanleData);
    });

    Then("the result should be {int}", (Integer int1) -> {
      // Write code here that turns the phrase above into concrete actions
      Assert.assertEquals(this.actResult,Double.valueOf(28));
    });
  }
}
