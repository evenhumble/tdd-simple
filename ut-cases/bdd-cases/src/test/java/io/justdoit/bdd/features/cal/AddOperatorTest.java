package io.justdoit.bdd.features.cal;


import org.junit.Assert;

/**
 * @author: patrick on 2018-12-08
 * @Description:
 */
public class AddOperatorTest {

  @org.junit.Test
  public void calculate() {
    AddOperator operator = new AddOperator();
    Double result = operator.calculate(12,14);
    Assert.assertEquals(result,Double.valueOf(26));
    Assert.assertEquals(operator.symbol(),"+");
  }
}