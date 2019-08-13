package io.justdoit.bdd.features.cal;

/**
 * @author: patrick on 2018-12-08
 * @Description:
 */
public class AddOperator implements Operator,HasSymbol{

  @Override
  public Double calculate(double origin, double handleData) {
    return origin+handleData;
  }

  @Override
  public String symbol() {
    return "+";
  }
}
