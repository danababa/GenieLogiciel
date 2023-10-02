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
  Item element = new Item("Aged Brie", 0, 0);
  GildedRose app = new GildedRose(new Item[] {element});
  app.updateQuality();
  assertEquals("Aged Brie", element.name, "different name");
  }

  @Test 
  @DisplayName("Test name of Backstage passes ")
  void testBackstage(){
  Item element = new Item("Backstage passes to a TAFKAL80ETC concert",0, 9);
  GildedRose app = new GildedRose(new Item[] {element});
  app.updateQuality();
  assertEquals("Backstage passes to a TAFKAL80ETC concert", element.name, "same name");
  }

  // if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
  // items[i].quality = items[i].quality - 1;}
  @Test 
  @DisplayName("Test quality > 0 ")
  void testQuality(){
  Item element = new Item("foo", 0, 2);
  GildedRose app = new GildedRose(new Item[] {element});
  app.updateQuality();
  assertEquals(0, element.quality, "quantity less than zero");
  }
  @Test 
  @DisplayName("Test quality <= 0 ")
  void testQuality2(){
  Item element = new Item("foo", 0, 0);
  GildedRose app = new GildedRose(new Item[] {element});
  app.updateQuality();
  assertEquals(0, element.quality, "quantity less than zero");
  }


  // if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
  @Test 
  @DisplayName("Test Sulfuras, Hand of Ragnaros")
  void testName2(){
  Item element = new Item("Sulfuras, Hand of Ragnaros", 0, 49);
  GildedRose app = new GildedRose(new Item[] {element});
  app.updateQuality();
  assertEquals("Sulfuras, Hand of Ragnaros", element.name, "different name");
  }

  @Test 
  @DisplayName("Test Sulfuras, Hand of Ragnaros with sellIn < 0")
  void testName3(){
  Item element= new Item("Sulfuras, Hand of Ragnaros", -1, 49);
  GildedRose app = new GildedRose(new Item[] {element});
  app.updateQuality();
  assertEquals("Sulfuras, Hand of Ragnaros", element.name, "different name");
  }

  // test if (items[i].quality < 50)
  @Test 
  @DisplayName("Test quality > 50 if name is Backstage passes to a TAFKAL80ETC concert ")
  void testLT(){
  Item element= new Item("Backstage passes to a TAFKAL80ETC concert", 10, 50);
  GildedRose app = new GildedRose(new Item[] {element});
  app.updateQuality();
  assertEquals(50, element.quality, "quantity greater than fifty");
  }

  @Test 
  @DisplayName("Test quality < 50 with sellIn > 0 ")
  void testLT3(){
  Item element= new Item("Backstage passes to a TAFKAL80ETC concert", 1, 49);
  GildedRose app = new GildedRose(new Item[] {element});
  app.updateQuality();
  assertEquals(50, element.quality, "quantity greater than fifty");
  }

  @Test 
  @DisplayName("Test quality > 50 with sellIn > 0")
  void testGT3(){
  Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 51);
  GildedRose app = new GildedRose(new Item[] {element});
  app.updateQuality();
  assertEquals(51, element.quality, "quantity greater than fifty");
  }

   @Test 
  @DisplayName("Test quality < 50 with name Aged Brie")
  void testGTRqnd(){
  Item element = new Item("Aged Brie", -1, 49);
  GildedRose app = new GildedRose(new Item[] {element});
  app.updateQuality();
  assertEquals(50, element.quality, "quantity greater than fifty");
  }

  @Test 
  @DisplayName("Test SellIn < 11 ")
  void testSellInLT(){
  Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 9, 0);
  GildedRose app = new GildedRose(new Item[] {element});
  app.updateQuality();
  assertEquals(8, element.sellIn, "SellIn less than eleven");
  }

   @Test 
  @DisplayName("Test SellIn = 11 ")
  void testSellInEq(){
  Item element = new Item("Backstage passes to a TAFKAL80ETC concert",11, 0);
  GildedRose app = new GildedRose(new Item[] {element});
  app.updateQuality();
  assertEquals(10, element.sellIn, "SellIn less than eleven");
  }

  @Test 
  @DisplayName("Test SellIn > 11 ")
  void testSellInGT(){
  Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 12, 0);
  GildedRose app = new GildedRose(new Item[] {element});
  app.updateQuality();
  assertEquals(11, element.sellIn, "SellIn greater than eleven");
  }

  @Test 
  @DisplayName("Test toString")
  void toStringTest(){
  Item element = new Item("Aged Brie", 12, 0);
  assertEquals("Aged Brie, 12, 0", element.toString(), "name not in correct format");
  }




}

