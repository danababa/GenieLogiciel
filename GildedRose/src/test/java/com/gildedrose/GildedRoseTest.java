package com.gildedrose;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {

  @Test
  @DisplayName("Test that the name is unchanged")
  void testName() {
  Item element = new Item("foo", 0, 0);
  GildedRose app = new GildedRose(new Item[] {element});
  app.updateQuality();
  assertEquals("foo", element.name, "the name changed");
  }

  @Test 
  @DisplayName("Test name is not Aged Brie ")
  void testAgedBrie(){
  Item element1 = new Item("Aged Brie", 0, 0);
  GildedRose app = new GildedRose(new Item[] {element1});
  app.updateQuality();
  assertEquals("Aged Brie", element1.name, "different name");
  }

  @Test 
  @DisplayName("Test Backstage passes ")
  void testBackstage(){
  Item element2 = new Item("Backstage passes to a TAFKAL80ETC concert",0, 9);
  GildedRose app = new GildedRose(new Item[] {element2});
  app.updateQuality();
  assertEquals("Backstage passes to a TAFKAL80ETC concert", element2.name, "same name");
  }


  // if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
  //   items[i].quality = items[i].quality - 1;}
  
  @Test 
  @DisplayName("Test quality > 0 ")
  void testQuality(){
  Item element3 = new Item("foo", 0, 2);
  GildedRose app = new GildedRose(new Item[] {element3});
  app.updateQuality();
  assertEquals("foo", element3.name, "quantity less than zero");
  }

  // if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
  @Test 
  @DisplayName("Test Sulfuras, Hand of Ragnaros")
  void testName2(){
  Item element4 = new Item("Sulfuras, Hand of Ragnaros", 0, 49);
  GildedRose app = new GildedRose(new Item[] {element4});
  app.updateQuality();
  assertEquals("Sulfuras, Hand of Ragnaros", element4.name, "different name");
  }

  @Test 
  @DisplayName("Test Sulfuras, Hand of Ragnaros")
  void testName3(){
  Item element4 = new Item("Sulfuras, Hand of Ragnaros", -1, 49);
  GildedRose app = new GildedRose(new Item[] {element4});
  app.updateQuality();
  assertEquals("Sulfuras, Hand of Ragnaros", element4.name, "different name");
  }

  // test if (items[i].quality < 50)
  @Test 
  @DisplayName("Test quality > 50 if name is Backstage passes to a TAFKAL80ETC concert ")
  void testLT(){
  Item element3 = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49);
  GildedRose app = new GildedRose(new Item[] {element3});
  app.updateQuality();
  assertEquals("Backstage passes to a TAFKAL80ETC concert", element3.name, "quantity greater than fifty");
  }

  @Test 
  @DisplayName("Test quality < 50 ")
  void testGT(){
  Item element3 = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 51);
  GildedRose app = new GildedRose(new Item[] {element3});
  app.updateQuality();
  assertEquals("Backstage passes to a TAFKAL80ETC concert", element3.name, "quantity greater than fifty");
  }

  @Test 
  @DisplayName("Test quality > 50 in all other casses  ")
  void testLT2(){
  Item element3 = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 49);
  GildedRose app = new GildedRose(new Item[] {element3});
  app.updateQuality();
  assertEquals("Backstage passes to a TAFKAL80ETC concert", element3.name, "quantity greater than fifty");
  }

  @Test 
  @DisplayName("Test quality < 50 ")
  void testGT2(){
  Item element3 = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 51);
  GildedRose app = new GildedRose(new Item[] {element3});
  app.updateQuality();
  assertEquals("Backstage passes to a TAFKAL80ETC concert", element3.name, "quantity greater than fifty");
  }


  @Test 
  @DisplayName("Test quality > 50 in all other casses  ")
  void testLT3(){
  Item element3 = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 49);
  GildedRose app = new GildedRose(new Item[] {element3});
  app.updateQuality();
  assertEquals("Backstage passes to a TAFKAL80ETC concert", element3.name, "quantity greater than fifty");
  }

  @Test 
  @DisplayName("Test quality < 50 ")
  void testGT3(){
  Item element3 = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 51);
  GildedRose app = new GildedRose(new Item[] {element3});
  app.updateQuality();
  assertEquals("Backstage passes to a TAFKAL80ETC concert", element3.name, "quantity greater than fifty");
  }
  @Test 
  @DisplayName("Test SellIn < 11 ")
  void testSellInLT(){
  Item element3 = new Item("Backstage passes to a TAFKAL80ETC concert", 9, 0);
  GildedRose app = new GildedRose(new Item[] {element3});
  app.updateQuality();
  assertEquals("Backstage passes to a TAFKAL80ETC concert", element3.name, "SellIn less than eleven");
  }

  @Test 
  @DisplayName("Test SellIn > 11 ")
  void testSellInGT(){
  Item element3 = new Item("Backstage passes to a TAFKAL80ETC concert", 12, 0);
  GildedRose app = new GildedRose(new Item[] {element3});
  app.updateQuality();
  assertEquals("Backstage passes to a TAFKAL80ETC concert", element3.name, "SellIn greater than eleven");
  }



}

