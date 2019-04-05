package com.v2gdemo.backend;

import org.junit.Test;

import static org.junit.Assert.*;

public class InitialDataCreatorTest {

  @Test
  public void createRespawnPoints() throws Exception{
    InitialDataCreator initialDataCreator = new InitialDataCreator(null,null,null,null,null);
    initialDataCreator.createRespawnPoints();

  }
}
